package com.example.firstpriject.dto;

import com.example.firstpriject.entity.Article;

public class AriticleForm {
    private String title;
    private String content;


    public AriticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "AriticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
