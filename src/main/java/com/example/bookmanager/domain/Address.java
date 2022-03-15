package com.example.bookmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {  // 시와 구는 enum타입으로 관리하면 더 좋을 것 같다
    private String city;    // 시

    private String district;    // 구

    @Column(name = "address_detail")
    private String detail;  // 상세주소

    private String zipCode; // 우편번호
}
