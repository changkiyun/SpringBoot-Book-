package com.example.firstpriject.service;

import com.example.firstpriject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;
    @Test
    void index() {
        //예상 데이터
        List<Article> articles = articleService.index();
        Article article = new Article(null, "aaaa", "1111");
        Article article1 = new Article(null, "bbbb", "2222");
        Article article2 = new Article(null, "cccc", "3333");
        List<Article> expected = new ArrayList<>(Arrays.asList(article, article1, article2));
        //실제 데이터

        //비교 및 검증
        assertEquals(expected.toString(), articles.toString());


    }
}