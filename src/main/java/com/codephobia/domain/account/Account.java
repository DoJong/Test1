package com.codephobia.domain.account;

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
@Table(name = "account")
public class Account {
    /**
     * 계좌에 대한 키값
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;

    /**
     * 계좌의 소유주에 대한 사용자 외래키
     */
    private Integer userId;

    /**
     * 계좌 은행
     */
    private String accountBank;

    /**
     * 계좌 번호
     */
    private String accountNumber;

    /**
     * 계좌 소유주 이름
     */
    private String accountUserName;

    /**
     * 가맹점 이름
     */
    private String branchName;

    /**
     * 가맹점 번호
     */
    private String branchNumber;

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