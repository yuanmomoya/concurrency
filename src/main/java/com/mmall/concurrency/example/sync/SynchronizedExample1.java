package com.mmall.concurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yuanmomo
 * @create 2020-10-27 18:00
 */
@Slf4j
public class SynchronizedExample1 {
  // 如果有一个类继承了SynchronizedExample1，SynchronizedExample1为父类，
  // 当子类去调用SynchronizedExample1父类的
  // test2方式时，是不包含synchronized的（synchronized不属于方法声明的一部分）

  // 修饰一个代码块
  // 如果实例两个SynchronizedExample1去调用test1，输出结果将要交叉执行
  public void test1(int num) {
    synchronized (this) {
      for (int i = 0; i < 10; i++) {
        log.info("test {} - {}",num, i);
      }
    }
  }

  // 修饰一个方法
  // 如果实例两个SynchronizedExample1去调用test2，输出结果将要交叉执行
  // synchronized修饰一个代码和修饰一个类包裹的代码效果是一样的
  public synchronized void test2(int num) {
      for (int i = 0; i < 10; i++) {
        log.info("test {} - {}", num, i);
      }
  }

  public static void main(String[] args) {
    SynchronizedExample1 example1 = new SynchronizedExample1();
    SynchronizedExample1 example2 = new SynchronizedExample1();
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
