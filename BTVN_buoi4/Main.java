package BTVN_buoi4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Book[] bookList = new Book[5];
        bookList[0] = new Book(1, "Conan", "Aoyama", 1865, "Tham tu lung danh Conan", 18000);
        bookList[1] = new Book(2, "Doraemon", "Aoyama1", 1860, "Tham tu lung danh Doraemon", 14000);
        bookList[2] = new Book(3, "Conan1", "Aoyama2", 1845, "Tham tu lung danh Conan2", 17000);
        bookList[3] = new Book(4, "Conan2", "Aoyama3", 1835, "Tham tu lung danh Conan3", 16000);
        bookList[4] = new Book(5, "Conan3", "Aoyama4", 1825, "Tham tu lung danh Conan4", 19000);

        mainMenu(bookList);
    }

    public static void mainMenu(Book[] bookList) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("====== Menu ======");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Chỉnh sửa thông tin sách");
            System.out.println("3. In ra danh sách các cuốn sách có trong mảng");
            System.out.println("4. In ra cuốn sách lâu đời cổ kính nhất");
            System.out.println("5. In ra cuốn sách phù hợp với giá tiền người mua yêu cầu");
            System.out.println("6. Sắp xếp lại danh sách các cuốn sách (theo tên hoặc theo giá tiền)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook(bookList);
                    break;
                case 2:
                    editBook(bookList);
                    break;
                case 3:
                    printBooks(bookList);
                    break;
                case 4:
                    printOldestBook(bookList);
                    break;
                case 5:
                    findBookByPrice(bookList);
                    break;
                case 6:
                    sortBooks(bookList);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    public static void addBook(Book[] bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sách: ");
        int maSach = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên sách: ");
        String tenSach = scanner.nextLine();
        System.out.print("Nhập tác giả: ");
        String tenTacGia = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int namSanXuat = scanner.nextInt();
        System.out.print("Nhập tóm tắt nội dung: ");
        scanner.nextLine();
        String tomTatNoiDung = scanner.nextLine();
        System.out.print("Nhập giá tiền: ");
        double giaTien = scanner.nextDouble();

        Book newBook = new Book(maSach, tenSach, tenTacGia, namSanXuat, tomTatNoiDung, giaTien);
        bookList = Arrays.copyOf(bookList, bookList.length + 1);
        bookList[bookList.length - 1] = newBook;
        System.out.println("Thêm sách thành công!");
    }

    public static void editBook(Book[] bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sách cần chỉnh sửa: ");
        int maSach = scanner.nextInt();
        for (Book book : bookList) {
            if (book.getMaSach() == maSach) {
                scanner.nextLine();
                System.out.print("Nhập tên sách mới: ");
                book.setTenSach(scanner.nextLine());
                System.out.print("Nhập tác giả mới: ");
                book.setTenTacGia(scanner.nextLine());
                System.out.print("Nhập năm sản xuất mới: ");
                book.setNamSanXuat(scanner.nextInt());
                System.out.print("Nhập tóm tắt nội dung mới: ");
                scanner.nextLine();
                book.setTomTatNoiDung(scanner.nextLine());
                System.out.print("Nhập giá tiền mới: ");
                book.setGiaTien(scanner.nextDouble());
                System.out.println("Chỉnh sửa thông tin sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sách với mã đã nhập.");
    }

    public static void printBooks(Book[] bookList) {
        System.out.println("Danh sách sách:");
        for (Book book : bookList) {
            book.display();
        }
    }

    public static void printOldestBook(Book[] bookList) {
        Book oldestBook = bookList[0];
        for (Book book : bookList) {
            if (book.getNamSanXuat() < oldestBook.getNamSanXuat()) {
                oldestBook = book;
            }
        }
        System.out.println("Cuốn sách lâu đời nhất: ");
        oldestBook.display();
    }

    public static void findBookByPrice(Book[] bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá tiền tối đa: ");
        double maxPrice = scanner.nextDouble();
        boolean found = false;
        for (Book book : bookList) {
            if (book.getGiaTien() <= maxPrice) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có sách nào phù hợp với giá tiền yêu cầu.");
        }
    }

    public static void sortBooks(Book[] bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sắp xếp theo:");
        System.out.println("1. Tên sách");
        System.out.println("2. Giá tiền");
        int choice = scanner.nextInt();

        if (choice == 1) {
            Arrays.sort(bookList, Comparator.comparing(Book::getTenSach));
        } else if (choice == 2) {
            Arrays.sort(bookList, Comparator.comparingDouble(Book::getGiaTien));
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }
        System.out.println("Danh sách sách sau khi sắp xếp:");
        printBooks(bookList);
    }
}
