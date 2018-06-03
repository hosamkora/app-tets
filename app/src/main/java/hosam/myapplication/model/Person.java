package hosam.myapplication.model;

import java.util.ArrayList;
import java.util.Random;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static ArrayList<Person> getListOfPerson() {
        ArrayList<Person> people = new ArrayList<Person>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            people.add(new Person("Hosam", rand.nextInt(50)));
        }
        return people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
