package com.example.bookmanager.dto;

import lombok.Data;

@Data
public class BookStatus {
    private int code;
    private String description;

    public BookStatus(int code) {
        this.code = code;
        this.description = parseDescription(code);
    }

    public boolean isDisplayed() {
        return code == 200;
    }

    private String parseDescription(int code) {
        // 자바 8버전 상위버전에서는 람다식으로 좀 더 예쁜 switch문을 사용할 수 있다
        switch (code) {
            case 100:
                return "판매종료";
            case 200:
                return "판매중";
            case 300:
                return "판매보류";
            default:
                return "미지원";
        }
    }
}
