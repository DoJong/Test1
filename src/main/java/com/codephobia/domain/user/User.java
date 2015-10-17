package com.codephobia.domain.user;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by waldo on 2015-10-17.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    /**
    * 유저의 키값
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    /**
     * 이메일
     */
    private String email;

    /**
     * 패스워드
     */
    private String password;

    /**
     * 이름
     */
    private String name;

    /**
     * 간단한 자기소개
     */
    private String bio;

    /**
     * 프로필 이미지
     */
    private String profileImage;

    /**
     * 전화번호
     */
    private String phoneNumber;

    /**
     * 등록날짜
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
