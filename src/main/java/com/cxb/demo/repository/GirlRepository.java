package com.cxb.demo.repository;

import com.cxb.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //通过年龄来查询
    List<Girl> findByAge(Integer age);
}
