package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件操作的service
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);


    /**
     * 文件上传的service方法
     * @param file 要上传的文件
     * @param path 文件路径
     * @return 返回上传文件的UUID文件名
     */
    public String upload(MultipartFile file,String path){
        //获取上传的文件的文件名
        String fileName = file.getOriginalFilename();
        //获取文件的扩展名，获取最后一个.后的字符串 +1是为了去除.
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        //将文件名用UUID来更改，防止重复
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        //创建文件路径
        File fileDir = new File(path);
        //如果文件路径不存在
        if(!fileDir.exists()){
            //让我们有权限 可写入
            fileDir.setWritable(true);
            //创建所有不存在的路径的文件夹
            fileDir.mkdirs();
        }
        //通过路径和文件名，创建文件
        File targetFile = new File(path,uploadFileName);

        try {
            //将文件上传到该路径下
            file.transferTo(targetFile);

            //将文件上传到ftp服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));

            //上传完到服务器上，再将该路径下的文件删除
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }
        //返回上传文件的UUID文件名
        return targetFile.getName();
    }

}
