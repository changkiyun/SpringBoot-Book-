package com.example.firstpriject.api;

import com.example.firstpriject.dto.CoffeeDto;
import com.example.firstpriject.entity.Article;
import com.example.firstpriject.entity.Coffee;
import com.example.firstpriject.repository.CoffeeRepository;
import com.example.firstpriject.service.CoffeeService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CoffeeApiController {
    private final CoffeeService coffeeService;

    private final CoffeeRepository coffeeRepository;

    //조회
    @GetMapping("/api/coffees")
    public List<Coffee> findAll() {
        return coffeeService.findAll();
    }

    @GetMapping("/api/coffees/{id}")
    public Coffee findOne(@PathVariable Long id) {
        return coffeeService.find(id);
    }

    //생성
    @PostMapping("/api/coffees")
    public ResponseEntity<Coffee> save(@RequestBody CoffeeDto dto) {
        Coffee saved = coffeeService.save(dto);
        return (saved != null) ?
                ResponseEntity.status(HttpStatus.OK).body(saved) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        //file
    }

    //수정
    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> patch(@PathVariable Long id, @RequestBody CoffeeDto dto) {
        Coffee patched = coffeeService.patch(id, dto);

        return (patched != null)?
                ResponseEntity.status(HttpStatus.OK).body(patched) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/api/transection-test")
    public ResponseEntity<List<Coffee>> transectionTest(@RequestBody List<CoffeeDto> dtos) {
        List<Coffee> coffeeList = coffeeService.createArticles(dtos);

        return (coffeeList != null)?
                ResponseEntity.status(HttpStatus.OK).body(coffeeList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

@PostConstruct
private void testData() {
    coffeeRepository.save(new Coffee(null, "aaaa", 1111));
    coffeeRepository.save(new Coffee(null, "bbbb", 2222));
    coffeeRepository.save(new Coffee(null, "cccc", 3333));
}


}
