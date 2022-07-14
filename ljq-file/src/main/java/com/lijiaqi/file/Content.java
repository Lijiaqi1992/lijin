package com.lijiaqi.file;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2020-07-02
 */
public class Content {

    public static void main(String[] args) throws IOException {
        getset();
    }

    public static void getset() throws IOException {
        Set<String> se = new HashSet<>();

        File dir = new File("E:\\下载的软件\\wpa-dictionary-master");
        File[] files = dir.listFiles();
        for (File file : files) {
            BufferedReader bfr = new BufferedReader(new FileReader(file));
            String line;
            while((line = bfr.readLine()) !=null){
                se.add(line);
            }
            bfr.close();
        }

        File tmp = new File("E:\\下载的软件\\wpa-dictionary-master\\all.txt");
        BufferedWriter bfw = new BufferedWriter(new FileWriter(tmp));
        int i = 0;
        for(String s : se){
            bfw.write(s);
            bfw.newLine();
            if(tmp.length() > 4096000){
                tmp = null;
                bfw.flush();
                bfw.close();
                i++;
                tmp = new File("E:\\下载的软件\\wpa-dictionary-master\\all"+i+".txt");
                bfw = new BufferedWriter(new FileWriter(tmp));
            }
        }
        bfw.flush();

    }

}
