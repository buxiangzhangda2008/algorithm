package com.huanglei.serialization;

import java.io.*;

public class WriteObject implements Serializable {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"))){
            Person p = new Person("hl",22);
            oos.writeObject(p);
            System.out.println(p);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}