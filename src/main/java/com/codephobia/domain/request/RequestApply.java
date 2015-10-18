package com.codephobia.domain.request;

import com.codephobia.domain.payment.Payment;
import com.codephobia.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by benimario on 15. 10. 17..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request_apply")
public class RequestApply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestAcceptId;

    /**
     * 카에리토모 리퀘스트의 키값
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Request request;

    /**
     * 카에리토모 요청에 대해 에스코트를 지원한 유저의 키값
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private User requestApplier;

    /**
     * 에스코트 지원 상태
     *
     * APPLIED      지원함
     * ACCEPTED     수락됨
     * COMPLETED    완료함
     * CANCELD      취소됨
     */
    private RequestApplyType applyStatus;

    /**
     * 생성날짜
     */
    private Date regdate;

    /**
     * 수정날짜
     */
    private Date modifiedDate;

    @OneToMany(mappedBy = "requestApply", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Payment> payments;

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
