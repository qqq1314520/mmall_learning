package com.mmall.util;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * FTP上传工具类
 */
public class FTPUtil {

    private static  final Logger logger = LoggerFactory.getLogger(FTPUtil.class);

    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass = PropertiesUtil.getProperty("ftp.pass");

    public FTPUtil(String ip,int port,String user,String pwd){
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }
    public static boolean uploadFile(List<File> fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(ftpIp,21,ftpUser,ftpPass);
        logger.info("开始连接ftp服务器");
        //img文件夹下
        boolean result = ftpUtil.uploadFile("img",fileList);
        logger.info("开始连接ftp服务器,结束上传,上传结果:{}");
        return result;
    }

    private boolean uploadFile(String remotePath,List<File> fileList) throws IOException {
        boolean uploaded = true;
        FileInputStream fis = null;
        //连接FTP服务器
        if(connectServer(this.ip,this.port,this.user,this.pwd)){
            try {
                //更改工作目录
                ftpClient.changeWorkingDirectory(remotePath);
                //设置缓冲区大小
                ftpClient.setBufferSize(1024);
                //设置编码方式
                ftpClient.setControlEncoding("UTF-8");
                //2进制文件类型
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //打开本地推送模式
                ftpClient.enterLocalPassiveMode();
                for(File fileItem : fileList){
                    fis = new FileInputStream(fileItem);
                    //绑定上传通道
                    ftpClient.storeFile(fileItem.getName(),fis);
                }

            } catch (IOException e) {
                logger.error("上传文件异常",e);
                //文件上传异常，这返回false
                uploaded = false;
                e.printStackTrace();
            } finally {
                //上传完成后关闭流
                fis.close();
                //上传完成后关闭ftp连接
                ftpClient.disconnect();
            }
        }
        return uploaded;
    }

    //连接FTP服务器的方法
    private boolean connectServer(String ip,int port,String user,String pwd){

        boolean isSuccess = false;
        //新建一个FTP客户端
        ftpClient = new FTPClient();
        try {
            //连接FTP服务器
            ftpClient.connect(ip);
            //客户端登录ftp服务器
            isSuccess = ftpClient.login(user,pwd);
        } catch (IOException e) {
            logger.error("连接FTP服务器异常",e);
        }
        return isSuccess;
    }

    private String ip;//ip
    private int port;//端口
    private String user;//用户
    private String pwd;//密码
    private FTPClient ftpClient;//ftpclient

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }
}
