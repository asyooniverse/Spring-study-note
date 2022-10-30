package com.example.fristProject.repository;

import com.example.fristProject.entity.Article;
import com.example.fristProject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // JPA와 연동한 테스트
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticledId() {
        /* Case 1: 4번 게시글의 모든 댓글 조회 */
        {
            // 입력 데이터 준비
            Long articleId = 4L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticledId(articleId);

            // 수행과정 예상
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글ㄱ");
            Comment a = new Comment(1L, article, "Park", "굳 윌 헌팅");
            Comment b = new Comment(2L, article, "Kim", "아이 엠 샘");
            Comment c = new Comment(3L, article, "Choi", "쇼생크의 탈출");
            List<Comment> expected = Arrays.asList(a,b,c);


            // 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력");
        }

        /* Case 1: 1번 게시글의 모든 댓글 조회 */
        {
            // 입력 데이터 준비
            Long articleId = 1L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticledId(articleId);

            // 수행과정 예상
            Article article = new Article(1L, "가가가가", "1111");
            List<Comment> expected = Arrays.asList();

            // 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글의 모든 댓글을 출력");
        }

        /* Case 9: 1번 게시글의 모든 댓글 조회 */
        {
            // 입력 데이터 준비
            Long articleId = 1L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticledId(articleId);

            // 수행과정 예상
            Article article = new Article(1L, "가가가가", "1111");
            List<Comment> expected = Arrays.asList();

            // 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글의 모든 댓글을 출력");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1: "Park"의 모든 댓글 조회 */
        {
            // 준비
            String nickname = "Park";
            // 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);
            // 예상
            Comment a = new Comment(1L, new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ"), nickname, "굳 윌 헌팅");
            Comment b = new Comment(4L, new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱㄱ"), nickname, "치킨");
            Comment c = new Comment(7L, new Article(6L, "당신의 취미는?", "댓글 ㄱㄱㄱ"), nickname, "조깅");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 검증
            assertEquals(expected.toString(), comments.toString(), "Park의 모든 댓글을 출력!");
        }

        /* Case 2: "Kim"의 모든 댓글 조회 */
        {
            String nickname = "Kim";

            List<Comment> comments = commentRepository.findByNickname(nickname);

            Comment a = new Comment(2L, new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ"), nickname, "아이 엠 샘");
            Comment b = new Comment(5L, new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱㄱ"), nickname, "샤브샤브");
            Comment c = new Comment(8L, new Article(6L, "당신의 취미는?", "댓글 ㄱㄱㄱ"), nickname, "유튜브");
            List<Comment> expected = Arrays.asList(a, b, c);

            assertEquals(expected.toString(), comments.toString(), "Kim의 모든 댓글을 출력!");
        }
        /* Case 3: null "의 모든 댓글 조회 */
        {

            List<Comment> comments = commentRepository.findByNickname(null);

            List<Comment> expected = Arrays.asList();

            assertEquals(expected.toString(), comments.toString(), "null의 모든 댓글을 출력!");
        }

        /* Case 1: ""의 모든 댓글 조회 */
        {
            String nickname = "";

            List<Comment> comments = commentRepository.findByNickname(nickname);

            List<Comment> expected = Arrays.asList();

            assertEquals(expected.toString(), comments.toString(), "''의 모든 댓글을 출력!");
        }

        /* Case 1: i가 들어간 모든 댓글 조회 */
//        {
//            String word = "i";
//            List<Comment> comments = commentRepository.findByNickname(word);
//            Comment a = new Comment(2L, new Article(4L,"당신의 인생 영화는?","댓글 ㄱ"), word,"아이 엠 샘");
//            Comment b = new Comment(3L, new Article(4L,"당신의 인생 영화는?","댓글 ㄱ"), word,"쇼생크의 탈출");
//            Comment c = new Comment(5L, new Article(5L,"당신의 소울 푸드는?","댓글 ㄱㄱ"), word,"샤브샤브");
//            Comment d = new Comment(6L, new Article(5L,"당신의 소울 푸드는?","댓글 ㄱㄱ"), word,"초밥");
//            Comment e = new Comment(8L, new Article(6L,"당신의 취미는?","댓글 ㄱㄱㄱ"), word,"유튜브");
//            Comment f = new Comment(9L, new Article(6L,"당신의 취미는?","댓글 ㄱㄱㄱ"), word,"독서");
//
//            List<Comment> expected = Arrays.asList(a,b,c,d,e,f);
//
//            assertEquals(expected.toString(), comments.toString(), "i가 들어간 닉네임의 모든 댓글을 출력!");
//        }
    }
}