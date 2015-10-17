package com.codephobia.domain.usergrade;

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
@Table(name = "user_grade")
public class UserGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gradeId;

    /**
     * 에스코트 받은 유저의 키값 (카에리토모 리퀘스트를 요청한 유저)
     */
    private Long escortedUserId;

    /**
     * 에스코트를 해준 유저의 키값 (돈 받을 사람)
     */
    private Long escortUserId;

    /**
     * 카에리토모 요청 데이터의 키값
     */
    private Long requestId;

    /**
     * 간단한 평가 내용
     */
    private String comment;

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
