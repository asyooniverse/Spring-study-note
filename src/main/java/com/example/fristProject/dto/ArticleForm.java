package com.example.fristProject.dto;

import com.example.fristProject.entity.Article;

public class ArticleForm {

    private String content;
    private String title;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity(){
        // Entity인 Article 객체를 반환
        return new Article(null, title, content);
    }

}
