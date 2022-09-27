package com.example.fristProject.repository;

import com.example.fristProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {
    // <관리대상 Entity, 대푯값의 타입>
}
