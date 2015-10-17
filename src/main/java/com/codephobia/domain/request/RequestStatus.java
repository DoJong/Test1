package com.codephobia.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by benimario on 15. 10. 17..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request_status")
public class RequestStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestAcceptId;

    /**
     * 카에리토모 리퀘스트의 키값
     */
    private Long requestId;

    /**
     * 카에리토모 요청에 대해 에스코트를 지원한 유저의 키값
     */
    private Long requestApplierId;

    /**
     * 카에리토모 요청의 현재 상태
     *
     * REQUESTED        요청함
     * ACCEPTED         수락함
     * COMPLETED        완료함
     * CANCELD          취소함
     */
    private RequestStatusType requestStatus;

    /**
     * 생성날짜
     */
    private Date regdate;

    /**
     * 수정날짜
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
