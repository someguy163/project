package com.example.fitstproject.dto;

import com.example.fitstproject.entity.Article;
import lombok.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class ArticleForm {
    private Long id;
    private String title;
    private String content;
    private String text;
    // AllArgsConstructor을 사용하면 아래 주석 생략가능
   // public ArticleForm(String title, String content) {
   //     this.title = title;
   //     this.content = content;
   // }

//@ToString을 사용하면 아래 주석들을 생략가능하다.
  //  public String toString() {
  //      return "ArticleForm{" +
   //             "title='" + title + '\'' +
   //             ", content='" + content + '\'' +'}';
  //  }

    public Article toEntity() {

        return new Article(id,title,content,text);
    }
}
