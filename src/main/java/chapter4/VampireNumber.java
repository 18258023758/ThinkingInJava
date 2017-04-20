package chapter4;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

/**
 * @author zhangbj
 * @version 1.0
 * @Type VampireNumber
 * @Desc 吸血鬼数字练习
 * @data 2017/4/17
 */

public class VampireNumber {

    public static void getVampire(Integer digit){
        int from ;
        int to;
        int count = 0;
        int multDigit = (int) Math.pow(10,digit / 2 - 1);
        int fromDigit = (int) Math.pow(10,digit -1);
        int toDigit1 = (int) Math.pow(10,digit);
        int toDigit2 = (int) Math.pow(10,digit / 2);

        for (int index = multDigit;index < 10 * multDigit;index ++){
            /*from = Math.max(1000 / i, i + 1);
            to = Math.min(10000 / i, 100);*/
            from = Math.max(fromDigit / index,index + 1);
            to = Math.min(toDigit1 / index,toDigit2);
            for (int jndex = from; jndex < to;jndex++){

                int max = index * jndex;

                if (max % 100 == 0)
                    continue;

                char[] charsMax = String.valueOf(max).toCharArray();
                char[] charsMult = ArrayUtils.addAll(String.valueOf(index).toCharArray(),String.valueOf(jndex).toCharArray());

                Arrays.sort(charsMax);
                Arrays.sort(charsMult);

                if (Arrays.equals(charsMax,charsMult)){
                    count++;
                    System.out.println("第" + count + "组吸血鬼数字为 ：" + index + " x " + jndex + " = " + max);
                }
            }
        }
    }

    public static void main(String[] args) {
        VampireNumber.getVampire(6);
    }
}
