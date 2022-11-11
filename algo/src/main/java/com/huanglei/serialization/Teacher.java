package com.huanglei.serialization;

import java.io.*;

public class Teacher implements Serializable {
    private String name;
    private Person person;

    public Teacher(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }

    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"))){
            Person person1 = new Person("hl",22);
            oos.writeObject(person1);
//            Person person2 = new Person("hl2",23);
            person1.setName("hl3");
            oos.writeObject(person1);

            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();
            System.out.println(p1);
            System.out.println(p2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}