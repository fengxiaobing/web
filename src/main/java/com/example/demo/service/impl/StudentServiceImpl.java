package com.example.demo.service.impl;

import com.example.demo.common.JsonResult;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.utils.JpaUtil;
import com.example.demo.vo.StudentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;


    /**
     * 查找所有学生信息
     *
     * @return
     */
    @Override
    public JsonResult findAllStudent() {
        List<StudentEntity> allStudent = studentRepository.findAll();
        List<StudentVo> studentVo = new ArrayList<>();
        for (StudentEntity entity : allStudent) {
            StudentVo vo = new StudentVo();
            BeanUtils.copyProperties(entity, vo);
            studentVo.add(vo);
        }
        return JsonResult.success(studentVo, "111");
    }

    @Override
    public JsonResult addStudent(StudentEntity studentEntity) {
        StudentEntity save = studentRepository.save(studentEntity);
        StudentVo studentVo = new StudentVo();
        studentVo.setName(save.getName());
        return JsonResult.success(studentVo, "111");
    }

    @Override
    public JsonResult updateStudent(int id, StudentEntity student) {
        StudentEntity studentEntity = studentRepository.getById(id);
        //将student中非空的值赋给studentEntity中,并将studentEntity重新存储
        JpaUtil.copyNotNullProperties(student,studentEntity);
        StudentEntity save = studentRepository.save(studentEntity);
        return JsonResult.success(save, "111");
    }
}


