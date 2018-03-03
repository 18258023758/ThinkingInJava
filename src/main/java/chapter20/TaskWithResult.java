package chapter20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/3/2
 */
public class TaskWithResult implements Callable<String>{

    private int id =1;


    @Override
    public String call() throws Exception {
        return "result="+id++;
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(10);
        List<Future<String>> list = new ArrayList();
        for (int index = 0;index<10;index++){
            list.add(service.submit(new TaskWithResult()));
        }
        service.shutdown();
        list.forEach(future->{
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
