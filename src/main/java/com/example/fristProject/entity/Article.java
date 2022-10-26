package com.example.fristProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity // 이 어노테이션을 선언해야 DB가 해당 객체를 인식 가능
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자 어노테이션
@ToString
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id를 자동 생성하는 어노테이션
    private Long id; // 대푯값, 값들을 구분짓기 위함

    @Column // DB에서 관리하는 테이블에 연결 되기 위한 어노테이션
    private String title;

    @Column
    private String content;

    public void patch(Article article) {
        if(article.title!=null)
            this.title = article.title;
        if(article.content!=null)
            this.content = article.content;
    }
}
