package com.example.firstpriject.repository;

import com.example.firstpriject.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
