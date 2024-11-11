package Buoi4;

public class Student {
    private String id;
    private String name;
    private int date;

    public Student(){

    }

    public Student(String id, String name, int date){
        this.id=id;
        this.name=name;
        this.date=date;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getDate(){
        return date;
    }

    public void setDate(int date){
        this.date=date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public void display(){
        System.out.println(toString());
    }
}
