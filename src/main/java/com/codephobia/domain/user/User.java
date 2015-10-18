package com.codephobia.domain.user;

import com.codephobia.domain.account.Account;
import com.codephobia.domain.accusation.Accusation;
import com.codephobia.domain.cardinfo.CardInfo;
import com.codephobia.domain.chat.Chat;
import com.codephobia.domain.payment.Payment;
import com.codephobia.domain.request.Request;
import com.codephobia.domain.request.RequestApply;
import com.codephobia.domain.request.RequestStatus;
import com.codephobia.domain.snsuser.SnsUser;
import com.codephobia.domain.usergrade.UserGrade;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private Long userId;

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

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Account> accounts;

    @OneToMany(mappedBy = "accusedUser", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Accusation> accused;

    @OneToMany(mappedBy = "accuser", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Accusation> accuser;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<CardInfo> cardinfos;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Chat> chats;

    @OneToMany(mappedBy = "receivedUser", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Payment> received;

    @OneToMany(mappedBy = "acceptedUser", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Payment> accepted;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Request> requests;

    @OneToMany(mappedBy = "requestApplier", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<RequestApply> requestApplies;

    @OneToMany(mappedBy = "requestApplier", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<RequestStatus> requestStatuses;

    @OneToMany(mappedBy = "snsUser", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SnsUser> snsUsers;

    @OneToMany(mappedBy = "escortedUser", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<UserGrade> escorteds;

    @OneToMany(mappedBy = "escortUser", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<UserGrade> escorts;

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
