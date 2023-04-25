package com.excel.data.exceldataprocess.repository;

import com.excel.data.exceldataprocess.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
