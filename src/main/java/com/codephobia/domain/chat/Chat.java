package com.codephobia.domain.chat;

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
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chatId;

    /**
     * 대화를 전송한 유저의 키 값
     */
    private Long authorId;

    /**
     * 카에리토모 요청의 키
     */
    private Long request_id;

    /**
     * 데이터 필드
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
