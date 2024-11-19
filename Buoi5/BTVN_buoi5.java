import java.util.ArrayList;
import java.util.Scanner;


class Address {
    private String commune;
    private String district;
    private String city;

    public Address(String commune, String district, String city) {
        this.commune = commune;
        this.district = district;
        this.city = city;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return commune + ", " + district + ", " + city;
    }
}

class Person {
    protected String name;
    protected int age;
    protected Address address;

    // Constructor, getter và setter
    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void input(Scanner sc) {
        System.out.print("Nhập tên: ");
        this.name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập địa chỉ (xã, huyện, tỉnh): ");
        String commune = sc.nextLine();
        String district = sc.nextLine();
        String city = sc.nextLine();
        this.address = new Address(commune, district, city);
    }

    public void output() {
        System.out.println("Tên: " + name + ", Tuổi: " + age + ", Địa chỉ: " + address);
    }
}


class Student extends Person {
    private String id;
    private String nameClass;
    private float gpa;
    private final float criteria = 2.0f;

    public Student(String id, String name, int age, Address address, String nameClass, float gpa) {
        super(name, age, address);
        this.id = id;
        this.nameClass = nameClass;
        this.gpa = gpa;
    }

    public Student() {
        super("", 0, new Address("", "", ""));
    }

    public boolean checkFall() {
        return this.gpa < criteria;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Nhập mã sinh viên: ");
        this.id = sc.nextLine();
        System.out.print("Nhập tên lớp: ");
        this.nameClass = sc.nextLine();
        System.out.print("Nhập điểm GPA: ");
        this.gpa = Float.parseFloat(sc.nextLine());
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Mã sinh viên: " + id + ", Lớp: " + nameClass + ", GPA: " + gpa);
    }

    public String getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }
}

class ClassRoom {
    private static ArrayList<Student> studentList = new ArrayList<>();

    public void inputList(Scanner sc) {
        while (true) {
            Student student = new Student();
            student.input(sc);
            if (student.getId().equals("555")) {
                break;
            }
            studentList.add(student);
        }
    }

    public void outputList() {
        for (Student student : studentList) {
            student.output();
        }
    }

    public void sortByGpa() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = i + 1; j < studentList.size(); j++) {
                if (studentList.get(i).getGpa() > studentList.get(j).getGpa()) {
                    Student temp = studentList.get(i);
                    studentList.set(i, studentList.get(j));
                    studentList.set(j, temp);
                }
            }
        }
    }

    public boolean removeById(String id) {
        return studentList.removeIf(student -> student.getId().equals(id));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClassRoom classRoom = new ClassRoom();
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Nhập thông tin các sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Sắp xếp danh sách theo GPA");
            System.out.println("4. Xóa sinh viên theo ID");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    classRoom.inputList(sc);
                    break;
                case 2:
                    classRoom.outputList();
                    break;
                case 3:
                    classRoom.sortByGpa();
                    System.out.println("Danh sách đã được sắp xếp theo GPA.");
                    break;
                case 4:
                    System.out.print("Nhập ID sinh viên cần xóa: ");
                    String id = sc.nextLine();
                    if (classRoom.removeById(id)) {
                        System.out.println("Xóa thành công.");
                    } else {
                        System.out.println("Không tìm thấy sinh viên với ID này.");
                    }
                    break;
                case 5:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);

        sc.close();
    }
}

