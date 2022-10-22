package com.example.fitstproject.api;

import com.example.fitstproject.dto.ArticleForm;
import com.example.fitstproject.entity.Article;
import com.example.fitstproject.repository.ArticleRepository;
import com.example.fitstproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Slf4j //log.info
@RestController//RESTAPI용 컨트롤러 데이터(jSON)를 반환한다
public class ArticleAPIController {


    @Autowired // 생성객체를 가져와 연결하는 어노테이션
    private ArticleService articleService;
//    private ArticleRepository articleRepository;
    // GET 목록조회
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();

    }
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){

        return articleService.show(id);
    }

    // POST
    //RequestBody는 요청한 데이터가 dto로 간다! 라는 어노테이션!
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
        Article created = articleService.create(dto);
        return (created != null)?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}
//
//    // PATCH
//    // 수정
    // ResponseEntity<Article>에 Article의 데이터가 json형태로 담겨진다
@PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id ,
                                         @RequestBody ArticleForm dto){
    Article created = articleService.create(dto);
    return (created != null) ?
            ResponseEntity.status(HttpStatus.OK).body(created) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}
//        //1. 수정용 엔티티를 생성해야한다
//        Article article= dto.toEntity();
//        log.info("id: {}, article:{}",id,article.toString());
//        //2. 대상 엔티티를 조회
//        Article target = articleRepository.findById(id).orElse(null);
//
//        //3. 잘못된 요청 처리 (대상이 없거나 , id가 다른 경우)
//        if (target==null || id !=article.getId()){
//            // 400 잘못된 요청 응답!
//            log.info("잘못된 요청 ! id: {}, article:{}",id,article.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//            //200,400이나 상태코드 나온것들을 출력하고싶으면 PATCH 부분에서 Article 을 ResponseEntity<Article>로 변경해라
//        }
//        //4. 업데이트 및 정상응답(200)
//        target.patch(article);
//        Article updated = articleRepository.save(target);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);


    //DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
//        //대상 찾기
//       Article target = articleRepository.findById(id).orElse(null);
//       //잘못된 요청 처리
//        if(target == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        //대상 삭제
//        articleRepository.delete(target);

        Article deleted = articleService.delete(id);
        //데이터 반환
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
        //트랜잭션 -> 실패 -> 롤백
        @PostMapping("/api/transaction-test")
        public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos) {
            List<Article> createdList = articleService.createArticles(dtos);
            return (createdList != null) ?
                    ResponseEntity.status(HttpStatus.OK).body(createdList) :
                    ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
}




