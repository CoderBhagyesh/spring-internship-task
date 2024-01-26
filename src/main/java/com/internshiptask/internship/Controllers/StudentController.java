package com.internshiptask.internship.Controllers;

import com.internshiptask.internship.Entities.Student;
import com.internshiptask.internship.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student) {
        String result = studentService.addStudent(student);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getStudent(@PathVariable("id") Integer id) {
        try {
            Student student = studentService.getStudent(id);
            return new ResponseEntity(student, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_details")
    public ResponseEntity updateStudentDetails(@RequestParam("id") Integer id, @RequestBody Student student) {
        try {
            String result = studentService.updateStudentDetails(id, student);
            return new ResponseEntity(result, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") Integer id) {
        try {
            String result = studentService.deleteStudent(id);
            return new ResponseEntity(result, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
