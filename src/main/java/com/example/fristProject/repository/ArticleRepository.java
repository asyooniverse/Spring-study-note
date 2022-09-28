package com.example.fristProject.repository;

import com.example.fristProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article,Long> {
    @Override
    ArrayList<Article> findAll();
    // <관리대상 Entity, 대푯값의 타입>
}
