package com.uthmanIV.cruddemo.entity;

import com.uthmanIV.cruddemo.entity.DAO.StudentDAO;
import com.uthmanIV.cruddemo.exceptions.StudentErrorResponse;
import com.uthmanIV.cruddemo.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentDAO studentDAO;

    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        if (studentDAO.findById(id)==null){
            throw new StudentNotFoundException("Student Not found");
        }
        return studentDAO.findById(id);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(e.getMessage());
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
