package com.codephobia.domain.request;

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
@Table(name = "request")
public class Request {

    /**
     * 카에리 토모 찾기 요청의 키값
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer requestId;

    /**
     * 신청자 id의 외래키
     */
    private Integer authorId;

    /**
     * 실제 에스코트한 시간
     */
    private Date escortTime;

    /**
     * 금액
     */
    private Integer escortPrice;

    /**
     * 예상 에스코트 시간
     */
    private String estimatedEscortTime;

    /**
     * 출발위치 지명
     */
    private String locationFrom;

    /**
     * 도착위치 지명
     */
    private String locationTo;

    /**
     * 출발위치 GPS좌표
     */
    private String locationFromCoordinate;

    /**
     * 도착위치 GPS좌표
     */
    private String locationToCoordinate;

    /**
     * 직선거리
     */
    private String distance;

    /**
     * 요청 내용
     */
    private String requestContent;

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
