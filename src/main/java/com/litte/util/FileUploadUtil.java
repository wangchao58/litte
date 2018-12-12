package com.litte.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
@Component
@ConfigurationProperties(prefix="file")
@PropertySource("classpath:fileupload.properties")
public class FileUploadUtil {
	public String uploadpath;
	/*public static String filesizelimt;
    public static String filesizemax; 
    public static String downloadFilePath;*/
    public String baseUrl;
    /*public static String syncTarget;
    public static String isSysnc;*/
    /*public static String getSyncTarget() {
		return syncTarget;
	}

	public static void setSyncTarget(String syncTarget) {
		FileUploadUtil.syncTarget = syncTarget;
	}

	public static String getIsSysnc() {
		return isSysnc;
	}

	public static void setIsSysnc(String isSysnc) {
		FileUploadUtil.isSysnc = isSysnc;
	}

	public static String getDownloadFilePath() {
		return downloadFilePath;
	}

	public static void setDownloadFilePath(String downloadFilePath) {
		FileUploadUtil.downloadFilePath = downloadFilePath;
	}

	public static String getUploadpath() {
		return uploadpath;
	}

	public static void setUploadpath(String uploadpath) {
		FileUploadUtil.uploadpath = uploadpath;
	}

	public static String getFilesizelimt() {
		return filesizelimt;
	}

	public static void setFilesizelimt(String filesizelimt) {
		FileUploadUtil.filesizelimt = filesizelimt;
	}

    public static String getFilesizemax() {
		return filesizemax;
	}

	public static void setFilesizemax(String filesizemax) {
		FileUploadUtil.filesizemax = filesizemax;
	}

	public static String getBaseUrl() {
		return baseUrl;
	}

	public static void setBaseUrl(String baseUrl) {
		FileUploadUtil.baseUrl = baseUrl;
	}

	static {
        Properties prop = new Properties();   
        InputStream in = Object.class.getResourceAsStream("/fileupload.properties");
        try {   
            prop.load(in);
            uploadpath = prop.getProperty("uploadpath").trim();
			baseUrl = prop.getProperty("baseUrl").trim();
            *//*filesizelimt = prop.getProperty("filesizelimt").trim();
            filesizemax = prop.getProperty("filesizemax").trim();   
            downloadFilePath = prop.getProperty("downloadFilePath").trim();
            syncTarget =  prop.getProperty("syncTarget").trim();
            isSysnc =  prop.getProperty("isSysnc").trim();*//*
			in.close();
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    } 
    
	public static String getFileName(String oldfilename){
		SimpleDateFormat sDateFormat;
		Random r = new Random();
		int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // 获取随机数
		sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // 时间格式化的格式
		String nowTimeStr = sDateFormat.format(new Date()); // 当前时间
		String extName = null;
		if (oldfilename.lastIndexOf(".") >= 0) {
			extName = oldfilename.substring(oldfilename
					.lastIndexOf("."));
		}
		String newFileName = nowTimeStr + rannum + extName;
		return newFileName;
	}
	
	*/

	public String getUploadpath() {
		return uploadpath;
	}

	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
