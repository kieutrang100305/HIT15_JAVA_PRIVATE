package Buoi4;

public class Person {
    private String id;
    private String name;
    private int age;

    // constructor: ham khoi tao
    // khoi tao gia tri mac dinh cho doi tuong
    // public + class

    public Person() {

    }

    public Person(String id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }


    // pham vi truy cap: access modifiers
    // public, protected, default, private

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void display(){
        System.out.println(toString());
    }
}


