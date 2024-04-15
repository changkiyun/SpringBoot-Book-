package com.example.firstpriject.dto;

import com.example.firstpriject.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CoffeeDto {
    private Long id;
    private String name;
    private Integer price;

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }
}
