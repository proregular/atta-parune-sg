package com.green.attaparunever2.reservation.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Schema(title = "예약 요청 등록")
public class ReservationPostReq {
    @Schema(title = "주문 PK", requiredMode = Schema.RequiredMode.REQUIRED)
    private long orderId;
    @Schema(title = "예약 인원 수")
    private int reservationPeopleCount;
    @Schema(title = "사용자 연락처")
    private String userPhone;
    @Schema(title = "예약 시간")
    private String reservationTime;
}