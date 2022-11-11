package com.huanglei.datastruct;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class stringcode {
    public static void main(String[] args) {
//        String englishString = "黄";
//        byte[] englishBytes = englishString.getBytes();
//        System.out.println(englishBytes.length);
//        String asciiEncondedEnglishString = new String(englishBytes, StandardCharsets.UTF_8);
//        System.out.println(asciiEncondedEnglishString.getBytes(StandardCharsets.UTF_8).length);
//        int a = 0x1234;
//        System.out.println((byte) a);
//        System.out.println((byte) a);
////        char c = new char(65535);
//        String str = "€";
//        System.out.println(str.length());
//        assertEquals(asciiEncondedEnglishString, englishString);
        String a = null;
        System.out.println("a"+a);
        char[] chs = Character.toChars(0x10437);
        System.out.printf("U+10437 高代理字符: %04x%n", (int) chs[0]);
        System.out.printf("U+10437 低代理字符: %04x%n", (int) chs[1]);
        String str = new String(chs);
        str.getBytes();
        str = "𠮷𠮷";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println("代码单元长度: " + str.length());
        System.out.println("bytes长度: " + bytes.length);
        System.out.println("代码点数量: " + str.codePointCount(0, str.length() - 2));

        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
// 存入字符串
        bb.asCharBuffer().put("abdcef");
        System.out.println(Arrays.toString(bb.array()));
// 反转缓冲区
        bb.rewind();
// 设置字节存储次序
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
// 反转缓冲区
        bb.rewind();
// 设置字节存储次序
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
    }
}
