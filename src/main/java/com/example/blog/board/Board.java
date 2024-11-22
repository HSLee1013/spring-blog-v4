package com.example.blog.board;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

// 모델
// DB에서 조회해서 가져온 ResultSet을 기본 생성자를 호출해서 instance를 생성하고 리플렉션으로 값을 채운다.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Table(name = "board_tb")
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Integer id;
    private String title;
    private String content;
    @CreationTimestamp
    private Timestamp createdAt;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
