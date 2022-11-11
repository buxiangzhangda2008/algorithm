package com.huanglei.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ReadObject implements Serializable {
    public static void main(String[] args) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))){
            Person p = (Person) ois.readObject();
            System.out.println(p);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}