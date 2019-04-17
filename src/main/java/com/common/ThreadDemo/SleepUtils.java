package com.common.ThreadDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Author mcg
 * @Date 2019/4/11 18:56
 **/

public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
