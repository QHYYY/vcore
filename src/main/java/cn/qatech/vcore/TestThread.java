package cn.qatech.vcore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:TODO
 * @Author:qihaoyuan
 * @Date:Create：in2020/11/20　11:05
 * @ClassName:TestThread
 */
public class TestThread {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                                        public void run() {
                                            try {
                                                System.out.println(index);
                                                Thread.sleep(2);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
            );
        }
        fixedThreadPool.shutdown();
    }
}
