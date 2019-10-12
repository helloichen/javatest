package zzy.test.thread;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        ArrayList list=new ArrayList<>();
        list.add(2);
        ArrayList<String> sList=list;
        System.out.println(sList.getClass());

        Person person=new Student();
        Student s=(Student) person;

//        TestA testA=(TestA) person;

        Student s1=new Student();

//        Man man=(Man) s1;

    }

}
class Person{}
class Student extends Person{}
class Man extends Person{}
class TestA{}