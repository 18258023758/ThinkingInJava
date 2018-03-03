package chapter13;

/**
 * @author zhangbj
 * @version 1.0
 * @Type Regexs
 * @Desc
 * @data 2017/8/23
 */

public class Regexs {

    static String words = "Disconnected from the target VM, address: '127.0.0.1:57000', transport: 'socket'。";

    static String knights =
                             "Then, when you have found the shrubbery,"
                           + "you must cut down the mightiest tree in the forest... "
                            + "with... a herring";

    public static void main(String[] args) {
       /* System.out.println("1234".matches("-\\d+"));
        System.out.println("1234".matches("-?\\d+"));
        System.out.println("+1234".matches("-?\\d+"));
        System.out.println("+1234".matches("\\d+"));
        System.out.println("1234".matches("\\d+"));
        System.out.println("-1234".matches("-?\\d+"));*/
        String[] cut = words.split("the|VM");
        System.out.println(words.matches("[A-Z].*[1]$"));
        System.out.println(words.replaceAll("a|A|O|o","_"));
        System.out.println(words.replaceAll("[aoAO]","_"));


    }
}
