package chapter20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/3/2
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0;i<5;i++){
            service.execute(new LiftOff());

        }
        service.shutdown();

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10);
        for (int i = 0;i<5;i++){
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();

    }
}
