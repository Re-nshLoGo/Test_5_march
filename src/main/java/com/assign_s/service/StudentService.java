package com.assign_s.service;

import com.assign_s.dao.StudentRepo;
import com.assign_s.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    public int save(Student student) {
        Student st = studentRepo.save(student);
        return st.getId();
    }

    public List<Student> getSt(String name) {
        List<Student> studentList = null;
        if(name != null){
            studentList = studentRepo.findByFirstName(name);
        }else{
            studentList = studentRepo.findAllStudent();
        }
        return studentList;
    }

    public void delete(int id) {
        studentRepo.deleteStudentById(id);
    }
}
