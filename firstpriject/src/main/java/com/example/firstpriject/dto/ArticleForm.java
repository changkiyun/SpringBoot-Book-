package com.example.firstpriject.dto;

import com.example.firstpriject.entity.Article;
import com.example.firstpriject.entity.Member;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class ArticleForm {
    //Article
    private Long id;
    private String title;
    private String content;


    public Article toEntity() {
        return new Article(id, title, content);
    }


}
