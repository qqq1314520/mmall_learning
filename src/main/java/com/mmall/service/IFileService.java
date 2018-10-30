package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件操作的service
 */
public interface IFileService {

    //文件上传
    String upload(MultipartFile file, String path);
}
