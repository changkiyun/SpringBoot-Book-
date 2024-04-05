package com.example.firstpriject.controller;

import com.example.firstpriject.dto.AriticleForm;
import com.example.firstpriject.entity.Article;
import com.example.firstpriject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(AriticleForm form) {
        System.out.println(form.toString());//dto 객체 출력

        //1. DTO 를 엔티티로 변환
        Article article = form.toEntity();
        System.out.println("article =  " + article.toString());//Ariicle 객체 출력

        //2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        System.out.println("saved = " + saved.toString());// article 객체로 저장된거 출력

        return "";
    }
}
