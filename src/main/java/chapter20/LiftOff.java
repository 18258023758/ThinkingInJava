package chapter20;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/3/2
 */
public class LiftOff implements Runnable{

    private int countDown = 10;

    private int taskCount = 0;

    private final int id = taskCount++;

    @Override
    public void run() {

        while (taskCount<countDown){
            System.out.print("#"+id+"("+taskCount+")");
            taskCount++;
        }
    }


    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        for (int i = 0;i<10;i++){
            new Thread(new LiftOff()).start();
            liftOff.run();
        }

    }
}
