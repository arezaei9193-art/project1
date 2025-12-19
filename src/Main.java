package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("Select an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Search by National Code");
            System.out.println("3. Delete Student");
            System.out.println("4. Edit Student Name");
            System.out.println("5. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter National Code: ");
                    String code = scanner.nextLine();

                    if (!NationalCodeValidator.isValid(code)) {
                        System.out.println("❌ کد ملی نامعتبر است!");
                    } else {
                        students.add(new Student(name, code));
                        System.out.println("✅ دانشجو با موفقیت ثبت شد!");
                    }
                }

                case "2" -> {
                    System.out.print("Enter National Code to search: ");
                    String code = scanner.nextLine();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getNationalCode().equals(code)) {
                            System.out.println("✅ Found Student: " + s.getName());
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("❌ دانشجویی با این کد ملی پیدا نشد!");
                    }
                }

                case "3" -> {
                    System.out.print("Enter National Code to delete: ");
                    String code = scanner.nextLine();
                    boolean removed = students.removeIf(s -> s.getNationalCode().equals(code));
                    if (removed) System.out.println("✅ دانشجو حذف شد!");
                    else System.out.println("❌ دانشجویی با این کد ملی پیدا نشد!");
                }

                case "4" -> {
                    System.out.print("Enter National Code to edit: ");
                    String code = scanner.nextLine();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getNationalCode().equals(code)) {
                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();
                            s.setName(newName);
                            System.out.println("✅ نام دانشجو به روز شد!");
                            found = true;
                        }
                    }
                    if (!found) System.out.println("❌ دانشجویی با این کد ملی پیدا نشد!");
                }

                case "5" -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("❌ گزینه نامعتبر است!");
            }
        }
    }
}
