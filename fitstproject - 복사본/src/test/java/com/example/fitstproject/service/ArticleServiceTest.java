package com.example.fitstproject.service;

import com.example.fitstproject.dto.ArticleForm;
import com.example.fitstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest // 해당 클래스는 스프링부트와 연동되어 테스팅 된다.

class ArticleServiceTest {

    @Autowired ArticleService articleService;
    @Test // 테스트를 위한 어노테이션이다
    void index() {

        //예상
        Article a = new Article(1L ,"가가가","1111","ㅁㅁㅁㅁ");
        Article b = new Article(2L ,"나나나","2222","ㄴㄴㄴㄴ");
        Article c = new Article(3L ,"다다다","3333","ㅇㅇㅇㅇ");

       List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));
        //실제
        List<Article> articles= articleService.index();

        //비교
        assertEquals(expected.toString(),articles.toString());
    }

    @Test
    void show_성공___존재하는_id입력() {

        //예상
        Long id = 1L;
        Article expected = new Article(id,"가가가","1111","ㅁㅁㅁㅁ");
        //실패
        Article article = articleService.show(id);
        //비교
        assertEquals(expected.toString(),article.toString());
    }
    @Test
    void show_실패___존재하지않는_id입력() {
        //예상
        Long id = -1L;
        Article expected = null;
        //실패
        Article article = articleService.show(id);
        //비교
        assertEquals(expected,article);

    }

    @Test
    @Transactional //데이터가 조회가 아닌 변경 삭제인 경우에는
    //트랜잭션으로 묶어야한다.
    void create_성공_title과_content_만_있는_DTO() {
        //예상
        String title= "라라라라";
        String content="4444";
        String text="ㅂㅂㅂㅂ";
        ArticleForm dto = new ArticleForm(null,title,content,text);
        Article expected = new Article(4L,title,content,text);
        //실제

        Article article =articleService.create(dto);
        //비교
        assertEquals(expected.toString(),article.toString());
    }
    @Test
    @Transactional
    void create_실패__id가__포함된_dto입력() {
        String title= "라라라라";
        String content="4444";
        String text="ㅂㅂㅂㅂ";
        ArticleForm dto = new ArticleForm(4L,title,content,text);
        Article expected = null;
        //실제
        Article article =articleService.create(dto);
        //비교
        assertEquals(expected,article);




    }
}