package com.example.firstpriject.dto;

import com.example.firstpriject.entity.Article;
import com.example.firstpriject.entity.Member;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    //Article
    private String title;
    private String content;


    public Article toEntity() {
        return new Article(null, title, content);
    }


}
