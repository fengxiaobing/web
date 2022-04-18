package com.example.demo.controller;

import com.example.demo.common.JsonResult;
import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
import com.example.demo.vo.StudentVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 学生信息
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/findAllStudent")
    public JsonResult findAllStudent(){
        return  studentService.findAllStudent();
    }
    @GetMapping("/getStudent/{id}")
    public String getUser(@PathVariable String id)
    {

        return id;
    }

    @PostMapping("/AddStudent")
    public JsonResult AddStudent(@RequestParam("name") String name,@RequestParam("age") long age){
        StudentEntity student = new StudentEntity();
        student.setName(name);
        student.setAge(age);
        return studentService.addStudent(student);
    }
    @PostMapping("/updateStudent")
    public JsonResult updateStudent(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("age") long age){
        StudentEntity student = new StudentEntity();
        student.setName(name);
        student.setAge(age);
        return studentService.updateStudent(id,student);
    }
}


