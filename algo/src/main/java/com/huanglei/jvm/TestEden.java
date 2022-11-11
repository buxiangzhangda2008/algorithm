package com.huanglei.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

import static java.lang.Thread.sleep;

public class TestEden {
    public static void main(String[] args) throws InterruptedException {
//        System.gc();
//        byte[] allocation = new byte[3500*1024];
//        byte[] allocation2 = new byte[10000*1024];
//        byte[] allocation3 = new byte[10000*1024];
//        byte[] allocation4 = new byte[10000*1024];
//        byte[] allocation5 = new byte[1000*1024];
//        byte[] allocation2 = new byte[3000*1024];
//        byte[] allocation3 = new byte[1500*1024];
//        System.gc();
        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        System.out.println(heapMemoryUsage);
        while(true){
            sleep(2000);
        }
    }
}
