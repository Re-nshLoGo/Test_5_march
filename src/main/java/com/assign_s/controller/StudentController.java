package com.assign_s.controller;

import com.assign_s.model.Student;
import com.assign_s.service.StudentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("save-student")
    public ResponseEntity<String> saveStudent(@RequestBody String requdata){
        Student student = setStudent(requdata);
        int id = studentService.save(student);
        return new ResponseEntity<>("Student saved with id"+id, HttpStatus.CREATED);
    }
    @GetMapping("/student")
    public List<Student> getStudentByName(@Nullable @RequestParam String name){
        return studentService.getSt(name);
    }
    @DeleteMapping("delete-id/{id}")
    public String deleteById(@PathVariable int id){
        studentService.delete(id);
        return "Deleted";
    }

    private Student setStudent(String requdata) {
        JSONObject json = new JSONObject(requdata);
        Student student = new Student();
        student.setActive(true);
        student.setAge(json.getInt("age"));
        student.setFirstName(json.getString("firstname"));
        student.setLastName(json.getString("lastname"));
        Timestamp admittime = new Timestamp(System.currentTimeMillis());
        student.setAdmissionDate(admittime);
        return student;
    }
}
