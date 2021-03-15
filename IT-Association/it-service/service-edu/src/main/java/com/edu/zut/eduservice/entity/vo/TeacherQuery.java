package com.edu.zut.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lyl
 * @program: IT-Association
 * @package com.edu.zut.eduservice.entity.vo
 * @description: vo
 * @date 2021-01-12 18:33
 **/
@Data
public class TeacherQuery implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "教师名称，模糊查询")
    private  String name;

    @ApiModelProperty(value = "头衔，1高级讲师，2首席讲师")
    private  Integer level;

    @ApiModelProperty(value = "查询开始时间",example="2019-01-01 10:10:10")
    private  String begin;

    @ApiModelProperty(value = "查询结束时间",example="2019-01-01 10:10:10")
    private  String end;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
