package com.example.firstpriject.repository;

import com.example.firstpriject.entity.Article;
import com.example.firstpriject.entity.Coffee;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
    @Override
    ArrayList<Coffee> findAll();
}
