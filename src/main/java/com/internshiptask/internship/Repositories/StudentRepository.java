package com.internshiptask.internship.Repositories;

import com.internshiptask.internship.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
