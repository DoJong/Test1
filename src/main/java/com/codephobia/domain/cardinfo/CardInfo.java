package com.codephobia.domain.cardinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by waldo on 2015-10-17.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card_info")
public class CardInfo {
    /**
     * 카드 정보의 키값
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cardInfoId;

    /**
     * 카드 소유주 외래키
     */
    private Integer userId;

    /**
     * 카드 번호
     */
    private Integer cardNumber;

    /**
     * 카드 종류
     */
    private String cardSort;

    /**
     * 등록 날짜
     */
    private Date regdate;

    /**
     * 수정 날짜
     */
    private Date modifiedDate;

    @PrePersist
    public void onCreate() {
        regdate = new Date();
        modifiedDate = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        modifiedDate = new Date();
    }
}
