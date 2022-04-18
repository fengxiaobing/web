package com.example.demo.service;


import com.example.demo.common.JsonResult;
import com.example.demo.entity.StudentEntity;

public interface StudentService {
    JsonResult findAllStudent();
    JsonResult addStudent(StudentEntity studentEntity);
    JsonResult updateStudent(int id, StudentEntity student);
}

