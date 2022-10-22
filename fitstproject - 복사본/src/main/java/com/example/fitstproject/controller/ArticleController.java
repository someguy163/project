package com.example.fitstproject.controller;

import com.example.fitstproject.dto.ArticleForm;
import com.example.fitstproject.entity.Article;
import com.example.fitstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j // 로깅을 위한 어노테이션이다 (문법)
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해놓은 객체를 가져다가 자동 연결

    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
//Post 방식으로 전달하려고 했기에 PostMapping을 import한다.
   public String creatArticle(ArticleForm form, RedirectAttributes rttrr){
        //로깅을 사용하려면 @Slf4j를 import한다.
        log.info("추가요청");
        log.info(form.toString());
        //System.out.println(form.toString()); -> 로깅기능으로 대체!

//        1.DTO를 Entity로 변환해야한다
           Article article = form.toEntity();
           log.info(article.toString());
       // System.out.println(article.toString());

//        2.Repository 에게 Entity를 DB안에 저장하게 한다.
       Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());
        rttrr.addFlashAttribute("insertmsg","추가가 완료되었습니다");

        return "redirect:/articles/"+ saved.getId();
   }
//데이터를 웹 페이지에서 보기
    //@PathVariable은 URL 패스로 부터 입력이된다 라는 걸 의미한다.
   @GetMapping("/articles/{id}")
        public String show(@PathVariable Long id, Model model){
        log.info("id="+id);
        //1. id로 데이터를 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //id 값을 통해서 찾았는데 id 값이없으면 null을 반환해라.

        //2. 가져온 데이터를 모델에 등록하자!
        model.addAttribute("article",articleEntity);

        //3. 보여줄 페이지를 설정한다.

        return "articles/show";
       }
       @GetMapping("/articles")
        public String index(Model model){
            //1. 모든 article을 가져온다
           List<Article> articleEntitylist=articleRepository.findAll();
            //2. 가져온 Article 묶음을 뷰로 전달한다.
           model.addAttribute("articleList",articleEntitylist);
            //3. 뷰 페이지를 설정한다.
        return "articles/index";
        //articles/index.mustache가 나올수있도록 한다.
        }
        @GetMapping("/articles/{id}/edit")
        public String edit(@PathVariable Long id , Model model){
        Article articleEntity =articleRepository.findById(id).orElse(null);
        model.addAttribute("article",articleEntity);
             return "articles/edit";
        }
        @PostMapping("/articles/update")
        public String update(ArticleForm form){
            log.info(form.toString());
            //1. dto를 엔티티로 변환
            Article articleEntity=form.toEntity();
            log.info(articleEntity.toString());
            //2. entity를 db로 저장한다
            //2-1 DB에 기존 데이터를 가져온다
            Article target =articleRepository.findById(articleEntity.getId()).orElse(null);
            //2-2 기존 데이터의 값을 수정 한다.
            if(target != null){
                articleRepository.save(articleEntity);//엔티티가 db로 갱신된다.
            }
            //3. 수정 결과 페이지로 리다이렉트 한다.
            return "redirect:/articles/"+articleEntity.getId();
        }
    //delete controller
            @GetMapping("articles/{id}/delete")
            //patnvariable은 url의 주소를 가져오기 위해 사용된다.
            public String delete(@PathVariable Long id, RedirectAttributes rttr){
                log.info("삭제 요청");

                //1. 삭제 대상을 가져온다.
                Article target =articleRepository.findById(id).orElse(null);
                log.info(target.toString());
                //2. 대상을 삭제한다.
                if (target != null){
                    articleRepository.delete(target);
                    rttr.addFlashAttribute("deletemsg","삭제가 완료되었습니다");
                }
                //3. 결과페이지로 리다이렉트 한다!
                return "redirect:/articles";
            }
}
