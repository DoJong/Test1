package com.codephobia.domain.snsuser;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sns_user")
public class SnsUser {

    /**
     * SNS로 가입한 유저의 키값
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long snsId;

    /**
     * user의 외래 키값
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private User snsUser;

    /**
     * 이메일
     */
    private String email;

    /**
     * 이름
     */
    private String name;

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
