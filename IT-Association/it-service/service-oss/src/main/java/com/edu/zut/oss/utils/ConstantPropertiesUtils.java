package com.edu.zut.oss.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author lyl
 * @program: IT-Association
 * @package com.edu.zut.oss.utils
 * @description: 配置类
 * @date 2021-03-10 17:35
 **/
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint ;
    @Value("${aliyun.oss.file.keyid}")
    private String accessKeyId ;
    @Value("${aliyun.oss.file.keysecret}")
    private String accessKeySecret ;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName ;

    public static String END_POINT;
    public static String ACCESSKEYID;
    public static String ACCESSKEYSECRET;
    public static String BUCKETNAME;

//    // 创建OSSClient实例。
//    OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT=endpoint;
        ACCESSKEYID=accessKeyId;
        ACCESSKEYSECRET=accessKeySecret;
        BUCKETNAME=bucketName;
    }

//// 创建存储空间。
//ossClient.createBucket(bucketName);
//
//// 关闭OSSClient。
//ossClient.shutdown();
}
