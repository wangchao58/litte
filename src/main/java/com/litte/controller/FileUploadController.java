package com.litte.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.litte.util.BaseController;
import com.litte.util.FileUploadUtil;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件上传
 */
@Controller
@RequestMapping("/file")
public class FileUploadController extends BaseController {

    @Autowired
    FileUploadUtil fileUploadUtil;

    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String uploadFile( @RequestParam( value = "file", required = false ) MultipartFile file) {

       /* Properties prop = new Properties();
        InputStream in = Object.class.getResourceAsStream("/fileupload.properties");*/
        JSONObject result = new JSONObject();
        // 方式一:保存文件目录
        if (!file.isEmpty()) {
            try {
                //prop.load(in);
                //String path =  FileUploadUtil.uploadpath;// 文件保存目录
                String path = fileUploadUtil.getUploadpath();
                //String path =  "E:"+File.separator+"uploadfiles";// 文件保存目录
                String fileName = file.getOriginalFilename();// getOriginalFilename和getName是不一样的哦
                //3新名称(uuid随机数加上后缀名)
                String newfileName=UUIDUtil.getUUID() +fileName.substring(fileName.lastIndexOf("."));
                File targetFile = new File(path);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                File newFile = new File(path,newfileName);
                file.transferTo(newFile);
                result.put("url",path+File.separator+newfileName);
                result.put("fileName",newfileName);
                result.put("success","1");

                return result.toString();
            } catch (Exception e) {
            }
        }

        result.put("success","0");

        return result.toString();
    }

    /**
     * 读取图片
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletRequest request, HttpServletResponse response) {

        String fileName = request.getParameter("fileName");

        if(StringUtil.isEmpty(fileName)) {
            fileName = this.getSession(request).getHeadPortrait();
        }

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        BufferedInputStream bis = null;
        OutputStream os = null;
        FileInputStream fileInputStream = null;
//        Properties prop = new Properties();
//        InputStream in = Object.class.getResourceAsStream("/fileupload.properties");

        try {
            //prop.load(in);
            //String path = FileUploadUtil.uploadpath;// 文件保存目录
            String path = fileUploadUtil.getUploadpath();
            System.out.println(path);
            System.out.println(path);
            System.out.println(path);
            System.out.println(path);
            System.out.println(path);
            System.out.println(path);
            System.out.println(path);
//            String path =  prop.getProperty("uploadpath").trim();// 文件保存目录
           // String path =  "E:"+File.separator+"uploadfiles";// 文件保存目录
            fileInputStream = new FileInputStream(new File(path+File.separator+fileName));
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        bis = new BufferedInputStream(fileInputStream);
        byte[] buffer = new byte[512];
        response.reset();
        response.setCharacterEncoding("UTF-8");

        //不同类型的文件对应不同的MIME类型

        response.setContentType("image/png");
        try {
            response.setContentLength(bis.available());
            os = response.getOutputStream();
            int n;
            while ((n = bis.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }
        } catch (IOException e) {
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (os != null) {
                    os.flush();
                    os.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
            }
        }

    }

}
