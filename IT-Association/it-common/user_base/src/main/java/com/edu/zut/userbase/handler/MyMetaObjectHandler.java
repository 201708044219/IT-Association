package com.edu.zut.userbase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lyl
 * @program: IT-Association
 * @package com.edu.zut.itassociation.handler
 * @description: 创建日期和修改日期自动填充的工具类
 * @date 2021-01-04 16:00
 **/
//交给spring管理
@Component
class DateObjectHandler implements MetaObjectHandler {

    /**
     * @Description: 使用mp实现添加的操作，这个方法就会执行
     * @Param: [metaObject] :元数据对象（表名称，表字段名叫做元数据）
     * @return: void
     * @Author: lyl
     * @Date: 2021/1/4
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //创建时间的自动填充
        this.setFieldValByName("gmtCreate",new Date(),metaObject);
        //修改时间的自动填充
        this.setFieldValByName("gmtModified",new Date(),metaObject);
        this.setFieldValByName("isDelete",false,metaObject);
        //乐观锁的自动填充
//        this.setFieldValByName("version",1,metaObject);

    }
    /**
     * @Description:  使用mp实现修改的操作，这个方法就会执行
     * @Param: [metaObject]
     * @return: void
     * @Author: lyl
     * @Date: 2021/1/4
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        //修改时间的自动填充
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }
}
