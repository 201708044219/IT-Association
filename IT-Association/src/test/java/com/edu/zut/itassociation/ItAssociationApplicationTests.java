package com.edu.zut.itassociation;

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
}
