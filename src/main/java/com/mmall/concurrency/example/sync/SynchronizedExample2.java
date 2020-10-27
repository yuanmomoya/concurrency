package com.mmall.concurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yuanmomo
 * @create 2020-10-27 18:00
 */
@Slf4j
public class SynchronizedExample2 {

  // 修饰一个类
  public static void test1(int num) {
    synchronized (SynchronizedExample2.class) {
      for (int i = 0; i < 10; i++) {
        log.info("test {} - {}",num, i);
      }
    }
  }

  // 修饰一个静态方法
  public static synchronized void test2(int num) {
      for (int i = 0; i < 10; i++) {
        log.info("test {} - {}", num, i);
      }
  }

  public static void main(String[] args) {
    SynchronizedExample2 example1 = new SynchronizedExample2();
    SynchronizedExample2 example2 = new SynchronizedExample2();
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(() -> {
      //example1.test1();
      //example1.test2();
      //example1.test1(1);
      example1.test2(1);
    });
    executorService.execute(() -> {
      //example1.test1();
      //example1.test2();
      //example2.test1(2);
      example2.test2(2);
    });
  }
}
