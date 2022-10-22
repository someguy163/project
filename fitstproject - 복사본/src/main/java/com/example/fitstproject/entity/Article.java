package com.example.fitstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity // DB가 해당 객체를 인식가능하다.
@AllArgsConstructor
@ToString
@NoArgsConstructor// 디폴트 생성자.
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 1..2..3. 자동생성 어노테이션
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String text;

    public void patch(Article article) {
        if(article.title!=null)
            this.title=article.title;
        if(article.content!=null)
            this.content=article.content;
        if(article.text!=null)
            this.title=article.text;
    }




    //@AllargsConstructor
    //public Article(Long id, String title, String content) {
    //    this.id = id;
    //    this.title = title;
    //   this.content = content;
    //}

    //@ToString
  //  @Override
   // public String toString() {
   //    return "Article{" +
    //            "id=" + id +
   //             ", title='" + title + '\'' +
    //            ", content='" + content + '\'' +
     //           '}';
   // }

}
