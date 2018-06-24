package com.tech.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxx_xx
 * @date 2018/6/21
 */
public class HeapOOM {

    static class OOMObject{

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
