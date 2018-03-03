package chapter18.io;

import java.io.*;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc 字符流（16） 为了国际化适应了UNICODE编码
 * @date 2018/3/1
 */
public class BufferedInputFile {

    public static String read(String path) throws IOException {
        String s;
        StringBuffer buffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            while ((s=reader.readLine())!=null){
                buffer.append(s).append("\n");
            }
        }
        return buffer.toString().toUpperCase();
    }

    public static void write(String path,String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))){

            String[] str = content.split("\n");
            for (int index=0;index<str.length;index++){
                writer.write(str[index]);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "F:\\DownLoad\\test\\1.txt";
        System.out.println(read(path));
        write(path,read(path));
    }
}
