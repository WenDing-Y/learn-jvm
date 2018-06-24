package com.tech.jvm;

import java.util.UUID;

/**
 * @author xxx_xx
 * @date 2018/6/24
 */
public class TestIntern {

    public static void main(String args[]) {
        for (int i = 0; i < 10000000; i++) {
            uuid();
        }
    }

    public static void uuid() {
        UUID.randomUUID().toString().intern();
    }
}
