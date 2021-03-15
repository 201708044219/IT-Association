package com.edu.zut.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.zut.commonutils.R;
import com.edu.zut.eduservice.entity.Teacher;
import com.edu.zut.eduservice.entity.vo.TeacherQuery;
import com.edu.zut.eduservice.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyl
 * @since 2021-01-09
 */
@Api(description="讲师管理")
@RestController
@RequestMapping("/teachermanage/teacher")
@CrossOrigin(origins = "*")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * @Description: 返回所有教师信息
     * @Param: []
     * @return: java.util.List<com.edu.zut.eduservice.entity.Teacher>
     * @Author: lyl
     * @Date: 2021/1/9
     */
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R findAll(){
        List<Teacher> list = teacherService.list(null);
        return R.ok().data("items",list);
    }

    /**
     * @Description: 逻辑删除
     * @Param: [id]  ：PathVariable：该注解表示通过路径进行传递
     * @return: boolean
     * @Author: lyl
     * @Date: 2021/1/9
     */
    @DeleteMapping("removeTeacher/{id}")
    public R removeTeacher(@PathVariable String id){
        boolean b = teacherService.removeById(id);
        if(b){
            return R.ok();
        }else {
            return R.error();
        }

    }

    /**
     * @Description: 分页查询
     * @Param: [current, limit]:[当前页,每页的数据条数]
     * @return: com.edu.zut.commonutils.R
     * @Date: 2021/1/12
     */
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,@PathVariable long limit){
        //创建page对象
        Page<Teacher> pageTeacher=new Page<>(current,limit);
        //调用方法实现分页，调用方法的时候，底层封装，把分页所有数据封装到pageTeacher对象里面
        teacherService.page(pageTeacher,null);
        long total=pageTeacher.getTotal();//得到总记录数
        List<Teacher> records = pageTeacher.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    /**
     * @Description: 多条件组合查询
     * @Param: [current, limit, teacherQuery]
     * @return: com.edu.zut.commonutils.R
     * @Date: 2021/1/12
     */
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current, @PathVariable long limit,@RequestBody(required = false) TeacherQuery teacherQuery){
        Page<Teacher> page=new Page<>(current,limit);
        QueryWrapper<Teacher> wrapper=new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if(StringUtils.isNoneEmpty(name)){
            wrapper.like("name",name);
        }
        if(level!=null){
            wrapper.eq("level",level);
        }
        if(StringUtils.isNoneEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if(StringUtils.isNoneEmpty(end)){
            wrapper.le("gmt_create",end);
        }
        teacherService.page(page,wrapper);
        long total=page.getTotal();//得到总记录数
        List<Teacher> records = page.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    /**
     * @Description: 添加教师信息
     * @Param: [teacher]
     * @return: com.edu.zut.commonutils.R
     * @Date: 2021/1/12
     */
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        if(save){
            return R.ok();
        }else {
            return R.error();
        }
    }
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        return R.ok().data("teacher",teacher);
    }
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody Teacher teacher){
        boolean flag = teacherService.updateById(teacher);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

