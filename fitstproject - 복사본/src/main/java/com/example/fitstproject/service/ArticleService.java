package com.example.fitstproject.service;


import com.example.fitstproject.dto.ArticleForm;
import com.example.fitstproject.entity.Article;
import com.example.fitstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service// 서비스 선언 (서비스 객체를 스프링 부트에 생성)
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        if(article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        Article article= dto.toEntity();
        log.info("id: {}, article:{}",id,article.toString());
        //2. 대상 엔티티를 조회
        Article target = articleRepository.findById(id).orElse(null);

        //3. 잘못된 요청 처리 (대상이 없거나 , id가 다른 경우)
        if (target==null || id != article.getId()){
            // 400 잘못된 요청 응답!
            log.info("잘못된 요청 ! id: {}, article:{}",id,article.toString());
            return null;
            //200,400이나 상태코드 나온것들을 출력하고싶으면 PATCH 부분에서 Article 을 ResponseEntity<Article>로 변경해라
        }
        //4. 업데이트 및 정상응답(200)
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;

    }

    public Article delete(Long id) {
        //대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        //잘못된 요청 처리
        if(target == null) {
            return null;
        }
        //대상 삭제
        articleRepository.delete(target);
     return target;
    }

    public List<Article> createArticles(List<ArticleForm> dtos) {
        // dto 묶음을 entity묶음으로 변환
       List<Article> articleList = dtos.stream()
                        .map(dto -> dto.toEntity())
                                .collect(Collectors.toList());
        //entity묶음을 DB로 저장

        articleList.stream()
                .forEach(article -> articleRepository.save(article));
        //forEach 하나씩 반복한다

        //강제 예외 발생
        articleRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("결제실패!")

        );
        // 결과값 반환
        return articleList;
    }
}
