package com.common.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *  OOM 代码
 */
public class HeapOom {

    static class OOMObject {}

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }

    }

}
