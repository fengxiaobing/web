package com.example.demo.entity;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 学生实体类
 * @Table(name="student") JPA自动创建student表
 */
@Data
@Table(name="student")
@Entity
@DynamicUpdate
public class StudentEntity extends BaseEntity {

    /**
     * 姓名
     */
    @Column(name="name")
    private String name;
    /**
     * 年龄
     */
    @Column(name="age")
    private Long age;

}



