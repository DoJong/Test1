package com.codephobia.domain.accusation;

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
@Table(name = "accusation")
public class Accusation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userAccusationId;

    /**
     * 신고 당한 유저의 키값
     */
    private Long accusedUserId;

    /**
     * 신고 내용
     */
    private String comment;

    /**
     * 신고 일자
     */
    private Date regdate;

    /**
     * 신고를 수정한 일자
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
