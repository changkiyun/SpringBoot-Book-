package com.example.firstpriject.repository;

import com.example.firstpriject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
