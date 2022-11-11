package com.huanglei.instructiontime;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.RandomAccess;

public class InstructionsTime {
    public static void main(String[] args)throws IOException {
        File f = new File("./testfile1");
        int read = 0;
        byte[] buffer = new byte[1*1024*1024];
//        FileOutputStream fos = new FileOutputStream(f);
//        Arrays.fill(buffer, (byte) 1);
//        fos.write(buffer);
//        fos.flush();
//        fos.close();
//        byte[] buffer = new byte[1*1024*1024];
        FileInputStream inputStream = new FileInputStream(f);
        byte a = 100;
        long time = System.nanoTime();
//        int read = inputStream.read(buffer);
//        byte[] buffer2 = new byte[1*1024*1024];
//        long time = System.nanoTime();
////        long delta = System.nanoTime()-time;
////        System.out.println("read +"+read +" bytes, cost time "+delta);
//        System.arraycopy(buffer, 0, buffer2, 0, buffer2.length);
        byte b = a;
       long  delta = System.nanoTime()-time;
//        inputStream.close();

        System.out.println("read +"+read +" bytes, cost time "+delta);

    }
}
