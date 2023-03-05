package com.assign_s.dao;

import com.assign_s.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Query(value = "select * from student_tbl where active = true",nativeQuery = true)
    public List<Student> findAllStudent();
    @Query(value = "select * from student_tbl where first_name = :firstname",nativeQuery = true)
    public List<Student> findByFirstName(String firstname);
    @Modifying
    @Transactional
    @Query(value = "update student_tbl set active = false where id = :id",countQuery = "select count(*) from student_tbl",
    nativeQuery = true)
    public void deleteStudentById(@Param("id") Integer id);
}
