package chapter18.io;

import java.io.File;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/3/1
 */
public class Directory {

    public static File[] local(File dir,String regex){
        return dir.listFiles(new DirFilter(regex));
    }

    public static void main(String[] args) {
        File[] files = local(new File("F:"),"[A-z]*\\.*");
        for (int index=0;index<files.length;index++){
            System.out.println(files[index].getName());
        }
    }
}
