package com.lijiaqi.file;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.text.DecimalFormat;

/**
 * @描述： 做相册时候用的批量重命名相片文件名的程序，
 * 1、使用word的另存为html方式实现的图片的批量压缩
 * 2、使用此程序重命名文件使其与压缩后的文件名对应
 * 3、依照相册模板导入图片
 * 4、输出html代码，方便粘贴
 * @作者： 李佳琪
 * @时间 2020-06-25
 */
public class FileRename {

    public static void main(String[] args) {
        try {
            gd("G:\\相册\\fuji\\北京动物园", "G:\\相册\\fuji\\北京动物园复制", "image");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param srcPath 源文件夹
     * @param outPath 目标文件夹
     * @param prefix  生成文件的前缀
     * @throws IOException
     */
    public static void gd(String srcPath, String outPath, String prefix) throws IOException {
        File srcFileDir = new File(srcPath);
        File outDir = new File(outPath);
        if (!outDir.exists()) {
            outDir.mkdirs();
        }
        File[] files = srcFileDir.listFiles();
        FileInputStream fin = null;
        FileOutputStream fou = null;
        StringBuffer sbf = new StringBuffer();
        DecimalFormat df = new DecimalFormat("000");
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            fin = new FileInputStream(file);
            String newFileName = prefix + df.format(i + 1) + ".jpg";
            File outFile = new File(outPath + File.separator + newFileName);
            sbf.append("<figure class=\"gallery-item\">");
            sbf.append("<img src=\"./images/Thumbnail/"+newFileName+"\" alt=\"\">");
            sbf.append("</figure>");
            sbf.append("\n\r");
            fou = new FileOutputStream(outFile);
            IOUtils.copy(fin, fou);
        }
        if (fin != null)
            fin.close();
        if (fou != null)
            fou.close();
        System.out.println(sbf.toString());
    }
}
