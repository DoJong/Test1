package com.codephobia.domain.payment;

import com.codephobia.domain.request.Request;
import com.codephobia.domain.request.RequestApply;
import com.codephobia.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "payment")
public class Payment {

    /**
     * 지불에 대한 키값
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    /**
     * 요청에 대한 외래키
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Request request;

    /**
     * 요청 승인에 대한 외래키
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private RequestApply requestApply;

    /**
     * 지불할 사용자
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private User requestedUser;

    /**
     * 지불받을 사용자
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private User acceptedUser;

    /**
     * 지불 방법(크래딧카드 or 페이팔)
     */
    private String method;

    /**
     * 지불한 날짜
     */
    private Date payedDate;

    /**
     * 지불 금액
     */
    private Integer payedPrice;

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
