package com.ljq.plugins.base.file;

import com.ljq.plugins.base.common.CommonTools;
import com.ljq.plugins.base.exception.MyBusinessException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * iview上传控件+springBoot 多文件上传是个假的，不是一次性上传多个文件，而是上传几个文件就请求多少次
 */
public class FileUpload {
    //原图存放路径
    static String dir = "pic";
    //预览图文件路径
    static String dirLess = "pic" + File.separator + "preview";

    //图片原图地址
    static String absolutePath = System.getProperty("user.dir") + File.separator + dir + File.separator;
    //预览图片地址，压缩后的地址
    static String absolutePathLess = System.getProperty("user.dir") + File.separator + dirLess + File.separator;

    public FileUpload() {
        dealDir();
    }

    /**
     * 单文件上传
     *
     * @param file
     * @return
     */
    public Map<String, String> uploadMultipartFile(MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        String oldFileName = file.getOriginalFilename();
        String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));
        String newFileName = CommonTools.uuid() + suffix;
        File dest = new File(absolutePath + newFileName);
        try {
            file.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        map.put("filePath", dir + File.separator + newFileName);
        map.put("filePathLess", dirLess + File.separator + "");
        return map;
    }

    public void download(HttpServletResponse response, String fileName, String filePath) {
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(
                    System.getProperty("user.dir") + File.separator + filePath
            )));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 多文件上传
     * * FIXME iview上传控件+springBoot 多文件上传是个假的，不是一次性上传多个文件，而是上传几个文件就请求多少次  * *
     *
     * @param request
     * @return
     */
    public List<Map<String, String>> handleFileUpload(HttpServletRequest request) {
        List<Map<String, String>> list = new ArrayList<>();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file;
        BufferedOutputStream stream;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String oldFileName = file.getOriginalFilename();
                    String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));
                    String newFileName = CommonTools.uuid() + suffix;

                    stream = new BufferedOutputStream(new FileOutputStream(new File(absolutePath + newFileName)));
                    stream.write(bytes);
                    stream.close();
                    Map<String, String> map = new HashMap<>();
                    map.put("filePath", dir + File.separator + newFileName);
                    map.put("filePathLess", dirLess + File.separator + "");
                    list.add(map);
                } catch (Exception e) {
                    stream = null;
                    throw new MyBusinessException("You failed to upload " + i + " => " + e.getMessage());
                }
            } else {
                throw new MyBusinessException("You failed to upload " + i
                        + " because the file was empty.");
            }
        }
        return list;
    }


    private void dealDir() {
        File file1 = new File(absolutePath);
        File file2 = new File(absolutePathLess);
        if (!file1.exists())
            file1.mkdirs();
        if (!file2.exists())
            file2.mkdirs();
    }

}
