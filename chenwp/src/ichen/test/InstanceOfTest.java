package ichen.test;

public class InstanceOfTest {
    public static void main(String[] args) {
        Person p1=new Person();
        Person p2=new Student();
//        Student s1=(Student) p1;
        Student s2=(Student) p2;
//        System.out.println("s1.name:"+s1.name);
//        s1.sayHello();
        System.out.println("s2.name:"+s2.name);
        System.out.println("p2.name:"+p2.name);
        s2.sayHello();
        p2.sayHello();
    }
}
class Person{
    String name="p";
    public void sayHello(){
        System.out.println("hello person");
    }
}
class Student extends Person{
    String name="s";
    public void sayHello(){
        System.out.println("hello student");
    }
}
