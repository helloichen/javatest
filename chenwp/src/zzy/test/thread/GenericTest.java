package zzy.test.thread;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        ArrayList list=new ArrayList<>();
        list.add(2);
        ArrayList<String> sList=list;
        for (String s:sList) {
            System.out.println(s);
        }
        System.out.println(sList.getClass());

        Person person=new Student();
        Student s=(Student) person;



        Student s1=new Student();

//        Teacher teacher=(Teacher) s1;

    }

}
class Person{}
class Student extends Person{}
class Teacher extends Person{}
