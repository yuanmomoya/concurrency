package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.Generated;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yuanmomo
 * @create 2020-10-26 21:53
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {
    // AtomicIntegerFieldUpdater 原子性去更新一个类的实例
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    //private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();

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
