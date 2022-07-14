package com.lijiaqi.file;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.List;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2022-02-26
 */
public class TT {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\ideaTydicWorkplace\\myTest\\lession\\ljq-file\\src\\main\\java\\com\\lijiaqi\\file\\TTT.txt");
        List<String> strings = FileUtils.readLines(file);
        int m = 1;
        for(int i = 0; i<strings.size(); i++){
            if(i == 0 || i%3 == 0 ){
                System.out.print(m + "    " + strings.get(i)+"     ");
                m++;
            }
            if(i%3 == 2 ){
                System.out.println(strings.get(i));
            }
        }
    }


    ;
}
