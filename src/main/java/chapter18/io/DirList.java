package chapter18.io;

import java.io.File;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc File类既能代表一个特定的文件，也能代表一个文件夹
 * @date 2018/3/1
 */
public class DirList {

    public static void main(String[] args) {
        File path = new File("F:\\DownLoad");

        String[] list = path.list();
        String[] filterList = path.list(new DirFilter("[A-z]*"));
        System.out.println("/************************* File List ***************************/");
        for (int index = 0;index<list.length;index++){
            System.out.println(list[index]);
        }
        System.out.println("/************************* Filter List ************************/");

        for (int index = 0;index<filterList.length;index++){
            System.out.println(filterList[index]);
        }

    }
}
