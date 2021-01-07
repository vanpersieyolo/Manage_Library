package com.example.demo.repository;

import com.example.demo.model.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
}
