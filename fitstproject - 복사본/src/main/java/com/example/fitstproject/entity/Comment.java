package com.example.fitstproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //해당 댓글 엔티티가 여러개가, 하나의 Article에 연관된다.
    @JoinColumn(name = "article_id") // 정보의 column의 이름을 정한다.
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;
}
