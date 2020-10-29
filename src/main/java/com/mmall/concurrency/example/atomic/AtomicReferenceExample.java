package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference示例
 *
 * @author yuanmomo
 * @create 2020-10-26 21:53
 */
@Slf4j
@ThreadSafe
public class AtomicReferenceExample {
   private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2); // 执行结果时2
        count.compareAndSet(0,1); // 不执行
        count.compareAndSet(1,3); // 不执行
        count.compareAndSet(2,4); // 执行，结果是4
        count.compareAndSet(3,5); // 不执行
        log.info("count:{}" , count.get());
    }
}
