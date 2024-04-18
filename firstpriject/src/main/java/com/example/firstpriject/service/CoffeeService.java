package com.example.firstpriject.service;

import com.example.firstpriject.dto.CoffeeDto;
import com.example.firstpriject.entity.Article;
import com.example.firstpriject.entity.Coffee;
import com.example.firstpriject.repository.CoffeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    public List<Coffee> findAll() {
        return coffeeRepository.findAll();
    }


    public Coffee find(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    public Coffee save(CoffeeDto dto) {
        Coffee entity = dto.toEntity();
        return coffeeRepository.save(entity);
    }

    public Coffee patch(Long id, CoffeeDto coffeeDto) {
        Coffee coffee = coffeeDto.toEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if (target == null || id != coffee.getId()) {
            return null;
        }

        target.patch(target);
        return coffeeRepository.save(target);
    }

    public Coffee update(Long id, CoffeeDto coffeeDto) {
        Coffee coffee = coffeeDto.toEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if (target == null || id != coffee.getId()) {
            return null;
        }

        target.patch(target);
        return coffeeRepository.save(target);
    }

    public List<Coffee> createArticles(List<CoffeeDto> dtos) {
        List<Coffee> coffeeList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        coffeeList.stream()
                .forEach(coffee -> coffeeRepository.save(coffee));

        coffeeRepository.findById(-1L)
                .orElseThrow(() -> new IllegalArgumentException("faild"));

        return coffeeList;


    }

}
