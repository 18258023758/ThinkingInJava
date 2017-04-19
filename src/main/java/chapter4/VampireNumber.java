package chapter4;

/**
 * @author zhangbj
 * @version 1.0
 * @Type VampireNumber
 * @Desc 吸血鬼数字练习
 * @data 2017/4/17
 */

public class VampireNumber {

    public void getVampire(Integer digit){
        int from ;
        int to;
        int multDigit = (int) Math.pow(10,digit / 2 - 1);
        for (int index = multDigit;index < 10 * multDigit;index ++){
            from = Math.max(10 * multDigit / index,index + 1);
            to = Math.min(100 * multDigit / index,10 * multDigit);
            for (int jndex = from; jndex < to;jndex++){

                int max = index * jndex;

                if (max % 100 == 0)
                    continue;

                String[] StringMax = String.valueOf(max).split("");
                String[] StringMult =  String.valueOf(index).split("") + String.valueOf(jndex).split("");



            }
        }
    }
}
