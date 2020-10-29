package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.Generated;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicIntegerFieldUpdater示例
 *
 * @author yuanmomo
 * @create 2020-10-26 21:53
 */
@Slf4j
@ThreadSafe
public class AtomicIntegerFieldUpdaterExample {
    // AtomicIntegerFieldUpdater 原子性去更新一个类的实例
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterExample> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterExample.class, "count");

    @Getter
    public volatile int count = 100;

    //private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterExample example5 = new AtomicIntegerFieldUpdaterExample();

        if (updater.compareAndSet(example5, 100, 200)) {
            log.info("update success 1, {}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 200)) {
            log.info("update success 2 {}", example5.getCount());
        } else {
            log.info("update failed {}", example5.getCount());
        }
    }
}
