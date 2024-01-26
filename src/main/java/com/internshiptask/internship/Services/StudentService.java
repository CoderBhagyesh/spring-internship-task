package com.internshiptask.internship.Services;

import com.internshiptask.internship.Entities.Student;
import com.internshiptask.internship.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Student has been added Succesfully to the DB.";
    }

    public Student getStudent(Integer id) throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(!optionalStudent.isPresent()) {
            throw new Exception("Student Id entered is invalid");
        }

        Student student = optionalStudent.get();

        return student;
    }

    public String updateStudentDetails(Integer id, Student newDetails) throws Exception{
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(!optionalStudent.isPresent()) {
            throw new Exception("Student Id entered is invalid");
        }

        Student student = optionalStudent.get();

        // update all the relevant details in the student we got
        student.setName(newDetails.getName());
        student.setEmailID(newDetails.getEmailID());
        student.setAge(newDetails.getAge());
        student.setContactNo(newDetails.getContactNo());

        studentRepository.save(student);
        return "Student's details with student_id: " + id + " are updated succesfully";
    }

    public String deleteStudent(Integer id) throws Exception{
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(!optionalStudent.isPresent()) {
            throw new Exception("Student Id entered is invalid");
        }

        Student student = optionalStudent.get();

        studentRepository.delete(student);

        return "Student's details with student_id: " + id + " are deleted succesfully";
    }
}
