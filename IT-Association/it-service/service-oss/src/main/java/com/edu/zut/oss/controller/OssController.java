package com.edu.zut.oss.controller;

import com.edu.zut.commonutils.R;
import com.edu.zut.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author lyl
 * @program: IT-Association
 * @package com.edu.zut.oss.controller
 * @description:
 * @date 2021-03-10 17:45
 **/
@RestController
@RequestMapping("eduoss/fileoss")
@CrossOrigin
public class OssController {
    @Autowired
    OssService ossService;

    @PostMapping
    public R uploadOssFile(MultipartFile file){
    //获取上传文件 MultipartFile
        String url = ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }
}
