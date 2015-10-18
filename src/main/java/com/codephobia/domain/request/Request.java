package com.codephobia.domain.request;

import com.codephobia.domain.chat.Chat;
import com.codephobia.domain.payment.Payment;
import com.codephobia.domain.user.User;
import com.codephobia.domain.usergrade.UserGrade;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private Long requestId;

    /**
     * 신청자 id의 외래키
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private User author;

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

    @OneToMany(mappedBy = "request", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Chat> chats;

    @OneToMany(mappedBy = "request", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Payment> payments;

    @OneToMany(mappedBy = "request", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<RequestApply> requestApplies;

    @OneToMany(mappedBy = "request", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<RequestStatus> requestStatuses;

    @OneToMany(mappedBy = "request", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<UserGrade> userGrades;

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
