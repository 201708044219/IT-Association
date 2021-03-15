package com.edu.zut.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

/**
 * @author lyl
 * @program: IT-Association
 * @package com.edu.zut.oss.service
 * @description:
 * @date 2021-03-10 17:45
 **/
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
