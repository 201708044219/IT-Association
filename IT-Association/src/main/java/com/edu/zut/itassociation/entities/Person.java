package com.edu.zut.itassociation.entities;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

/**
 * @author lyl
 * @program: IT-Association
 * @package com.edu.zut.itassociation.dao
 * @description:测试
 * @date 2021-01-04 11:18
 **/
public class Person {
//    设置自动生成id，使用的雪花算法
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Integer age;
    private Integer sex;
    private Integer birthday;
//    在进行插入的操作时自动填充时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //    在进行插入和修改的操作时自动填充时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

//    逻辑删除的注解
    @TableLogic
    private Integer deleted;


    public Person(Long id, String name, Integer age, Integer sex, Integer birthday, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Person(Long id) {
        this.id = id;
    }

    public Person() {
    }

    public Person(Long id, String name, Integer age, Integer sex, Integer birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                '}';
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }
}
