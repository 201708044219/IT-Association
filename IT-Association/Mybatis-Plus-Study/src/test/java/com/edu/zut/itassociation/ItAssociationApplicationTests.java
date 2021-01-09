package com.edu.zut.itassociation;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.zut.itassociation.entities.Person;
import com.edu.zut.itassociation.mapper.PersonMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.util.Arrays;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
class ItAssociationApplicationTests {

    @Autowired
    PersonMapper personMapper;

    @Test
    public void findAll() {
        List<Person> list = personMapper.selectList(null);

        System.out.println(list.toString());
    }

    @Test
    public void insert(){

        Person person = personMapper.selectById(1346014263877120002L);
        person.setName("华容");
        personMapper.updateById(person);

    }

    /**
     * @Description: 批量查询
     * @Param: []
     * @return: void
     * @Author: lyl
     * @Date: 2021/1/4
     */
    @Test
    public void selectBatch(){

        List<Person> list = personMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(list);

    }

    /**
     * @Description: 分页测试
     * @Param: []
     * @return: void
     * @Author: lyl
     * @Date: 2021/1/4
     */
    @Test
    public void testPage(){
        //创建page对象
        //传入两个参数： 当前页和每页显示记录数
        Page<Person> page = new Page<>(1, 3);
//        调用mp分页查询的方法
//        调用mp分页铲鲟过程中，底层封装
//        把分页所有数据封装到page对象里面
          personMapper.selectPage(page, null);

//        获取配置中的当前页
        System.out.println(page.getCurrent());
//        获取每页数据集合
        System.out.println(page.getRecords());
//        每页显示记录数
        System.out.println(page.getSize());
        // 得到总记录数
        System.out.println(page.getTotal());
        //得到总页数
        System.out.println(page.getPages());
        //是否有上页
        System.out.println(page.hasNext());
        //是否有下页
        System.out.println(page.hasPrevious());
    }


    /**
     * @Description: 条件查询演示
     * @Param: []
     * @return: void
     * @Author: lyl
     * @Date: 2021/1/9
     */
    @Test
    public void  testSelectQuery(){
        //创建QueryWrapper对象
        QueryWrapper<Person> wrapper=new QueryWrapper<>();

        //通过QueryWrapper设置条件

        //ge 大于 gt 大于等于 le小于  lt小于等于
        //查询 age>=30记录
        wrapper.ge("age",30);  //第一个参数字段的名字。第二个参数为需要设置的数值。
        List<Person> people = personMapper.selectList(wrapper);
        System.out.println(people);

        //eq 等于 ne 不等于
        //between 表示范围
        //like 模糊查询
        //orderByDesc 排序（降序）  orderByAsc 升序
        //last 直接拼接到sql的最后
        //指定要查询的列
        wrapper.select("id");

    }
}
