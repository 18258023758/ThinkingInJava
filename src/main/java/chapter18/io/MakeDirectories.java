package chapter18.io;

import java.io.File;
import java.io.IOException;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/3/1
 */
public class MakeDirectories {

    public static void main(String[] args) throws IOException {
        File directory = new File("F:\\DownLoad\\test");

        if (!directory.exists()){
            directory.mkdirs();
        }else {
            System.out.println("---getName------"+directory.getName());
            System.out.println("---getAbsoluteFile----"+directory.getAbsoluteFile());
            System.out.println("---getAbsolutePath------"+directory.getAbsolutePath());
            System.out.println("---getParent------"+directory.getParent());
            System.out.println("---getPath------"+directory.getPath());
            System.out.println("---canExecute------"+directory.canExecute());
            System.out.println("---canRead------"+directory.canRead());
            System.out.println("---canWrite------"+directory.canWrite());
            System.out.println("---lastModified------"+directory.lastModified());
            System.out.println("---length------"+directory.length());
        }
        File file = new File("F:\\DownLoad\\test\\1.txt");

        if (!file.exists()){
          file.createNewFile();
        }else {
            System.out.println("--- file getName------"+file.getName());
            System.out.println("--- file getAbsoluteFile----"+file.getAbsoluteFile());
            System.out.println("--- file getAbsolutePath------"+file.getAbsolutePath());
            System.out.println("--- file getParent------"+file.getParent());
            System.out.println("--- file getPath------"+file.getPath());
            System.out.println("--- file canExecute------"+file.canExecute());
            System.out.println("--- file canRead------"+file.canRead());
            System.out.println("--- file canWrite------"+file.canWrite());
            System.out.println("--- file lastModified------"+file.lastModified());
            System.out.println("--- file length------"+file.length());
        }
    }
}
