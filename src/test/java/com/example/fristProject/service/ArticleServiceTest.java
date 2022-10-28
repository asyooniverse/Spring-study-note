package com.example.fristProject.service;

import com.example.fristProject.dto.ArticleForm;
import com.example.fristProject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 해당 클래스는 스프링부트와 연동외어 테스팅
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // 예상
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");

        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제
        List<Article> articles = articleService.index();

        // 비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공() {
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        Article article = articleService.show(id);

        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패() {
        Long id = -1L;
        Article expected = null;
        Article article = articleService.show(id);

        assertEquals(expected, article);
    }

    @Test
    @Transactional
        // 테스트 종료 후 롤백
    void create_성공__title과_content만_있는_dto_압력() {
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);

        Article expected = new Article(4L, title, content);

        Article article = articleService.create(dto);

        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_실패__id가_포함된_dto가_입력된_경우() {
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(1L, title, content);

        Article expected = null;

        Article article = articleService.create(dto);

        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_성공__존재하는_id와_title과_content가_있는_dto_입력() {
        Long id = 3L;
        String title = "마마마마";
        String content = "5555";
        ArticleForm dto = new ArticleForm(id, title, content);

        // 예상
        Article expected = new Article(id, title, content);

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_성공__존재하는_id와_title만_있는_dto_입력() {
        // 예상
        Long id = 3L;
        String title = "마마마마";
        ArticleForm dto = new ArticleForm(id, title, null);
        Article expected = new Article(id, title, null);

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_실패__존재하지_않는_id의_dto_입력() {
        String title = "마마마마";
        String content = "5555";
        ArticleForm dto = new ArticleForm(5L, title, content);
        Article expected = null;

        Article article = articleService.update(5L, dto);

        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_실패__id만_있는_dto_입력() {
        Long id = 2L;
        ArticleForm dto = new ArticleForm(id, null, null);
        Article expected = null;

        Article article = articleService.update(id, dto);

        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void delete_성공() {
        Long id = 1L;
        String title = "가가가가";
        String content = "1111";

        Article expected = new Article(id, title, content);

        Article article = articleService.delete(id);

        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void delete_실패() {
        Article expected = null;

        Article article = articleService.delete(5L);

        assertEquals(expected, article);
    }
}