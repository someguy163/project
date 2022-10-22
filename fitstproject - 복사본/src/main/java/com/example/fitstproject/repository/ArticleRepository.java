package com.example.fitstproject.repository;

import com.example.fitstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    //<1,2>안에는 1. 관리 대상 entity를 넣어야한다.
    //           2. 관리 대상에서 대표값의 타입을 넣어한다.

    @Override
    ArrayList<Article> findAll();
}
