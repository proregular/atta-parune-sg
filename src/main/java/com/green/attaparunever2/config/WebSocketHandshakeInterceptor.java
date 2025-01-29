package com.green.attaparunever2.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.WebSocketSession;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // 헤더 정보 확인
        Map<String, List<String>> headers = request.getHeaders();
        System.out.println(headers);
        // 'userId'와 'role' 값을 추출 (리스트에서 첫 번째 값만 사용)
        List<String> userIdList = headers.get("id");
        List<String> roleList = headers.get("role");

        // 헤더 값이 있을 때만 처리
        String userId = (userIdList != null && !userIdList.isEmpty()) ? userIdList.get(0) : null;
        String role = (roleList != null && !roleList.isEmpty()) ? roleList.get(0) : null;

        // 로그를 찍어보거나 필요한 처리를 할 수 있음
        System.out.println("UserId: " + userId);
        System.out.println("Role: " + role);

        // 핸드쉐이크 진행을 위해 true 반환
        return true;
    }


    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        // 핸드셰이크 후 처리
        System.out.println("Handshake 완료");
    }
}
