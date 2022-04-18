package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//用于主键的自增长
    private Integer id;



    /**
     * @CreatedBy 创建者注解需要我们自己给其设置
     */
    @CreatedBy
    @Column(name = "create_user")
    private String createUser;

    /**
     * @LastModifiedBy 修改者注解需要我们自己给其设置
     */
    @LastModifiedBy
    @Column(name = "update_user")
    private String updateUser;

    /**
     * @CreatedDate 创建时间 JPA自动给其设置
     */
    @CreatedDate
    @Column(name = "create_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    /**
     * @LastModifiedDate 创建时间 JPA自动给其设置
     */
    @LastModifiedDate
    @Column(name = "update_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}


