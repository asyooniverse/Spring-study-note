package com.example.fristProject.controller;

import com.example.fristProject.dto.ArticleForm;
import com.example.fristProject.entity.Article;
import com.example.fristProject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해놓은 객체를 가져다가 자동연결시켜줌 -> 객체를 따로 만들지 않아도 됨
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());

        // 1. DTO를 Entity로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());

        // 2. Repository를 통해 Entity를 DB 안에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "";
    }

}
