package com.green.attaparunever2.reservation;

import com.green.attaparunever2.common.model.ResultResponse;
import com.green.attaparunever2.reservation.model.ReservationPostReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final SimpMessagingTemplate messagingTemplate;

    @PostMapping
    @Operation(summary = "예약 요청")
    public ResultResponse<Integer> postReservation(@RequestBody ReservationPostReq req) {
        System.out.println(req.toString());
        sendReservationNotificationToOwner("1", "1", req);
        return null;
        /*
        int result = reservationService.postReservation(req);
        return ResultResponse.<Integer>builder()
                             .statusCode("200")
                             .resultMsg("예약 요청 완료")
                             .resultData(result)
                             .build();*/
    }

    // 식당 사장님에게 예약 요청 알림을 보내는 메서드
    public void sendReservationNotificationToOwner(String restaurantId, String userId, ReservationPostReq req) {
        // 사장님 구독 경로로 예약 알림 메시지 전송
        messagingTemplate.convertAndSend(
                "/queue/restaurant/" + restaurantId + "/owner/reservation",
                req
        );
    }
}
