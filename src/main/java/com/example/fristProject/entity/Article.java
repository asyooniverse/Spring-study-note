package com.example.fristProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // 이 어노테이션을 선언해야 DB가 해당 객체를 인식 가능
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자 어노테이션
@ToString
@Getter
public class Article {

    @Id
    @GeneratedValue // 자동생성 어노테이션
    private Long id; // 대푯값, 값들을 구분짓기 위함

    @Column // DB에서 관리하는 테이블에 연결 되기 위한 어노테이션
    private String title;

    @Column
    private String content;
}
