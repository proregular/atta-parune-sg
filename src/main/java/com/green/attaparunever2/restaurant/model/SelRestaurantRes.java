package com.green.attaparunever2.restaurant.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelRestaurantRes {
    @Schema(title = "관리자 PK")
    private long adminId;
    @Schema(title = "카테고리 PK")
    private long categoryId;
    @Schema(title = "식당 이름")
    private String restaurantName;
    @Schema(title = "식당 주소")
    private String restaurantAddress;
    @Schema(title = "식당 번호")
    private String restaurantNumber;
    @Schema(title = "식당 사업자번호")
    private String businessNumber;
    @Schema(title = "식당 영업시간")
    private String operatingHours;
    @Schema(title = "식당 설명")
    private String restaurantDescription;
    @Schema(title = "식당 상태")
    private int status;
    @Schema(title = "식당 인원 수용량")
    private int maxCapacity;
    @Schema(title = "위도")
    private double lat;
    @Schema(title = "경도")
    private double lng;
    @Schema(title = "생성 시간")
    private String createdAt;
}
