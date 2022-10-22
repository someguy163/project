package com.example.fitstproject.repository;

import com.example.fitstproject.entity.Article;
import com.example.fitstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@DataJpaTest //JPA와 연동한 테스트
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;


    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        // case1: 4번 게시글의 모든 댓글 조회

        {
            //입력데이터 준비
            Long articleId=4L;
            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //예상
            Article article = new Article(4L,"당신의 인생영화는?","댓글 ㄲ1","df");
            Comment a= new Comment(1L,article,"Park","굳 윌 헌팅");
            Comment b= new Comment(2L,article,"Kim","아이앰샘");
            Comment c= new Comment(3L,article,"Choi","쇼생크탈출");
            List<Comment> expected = Arrays.asList(a,b,c);
            //검증
            assertEquals(expected.toString(),comments.toString());
        }
    }

    @Test
    void findByNickname() {
    }
}