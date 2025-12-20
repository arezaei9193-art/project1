import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import src.NationalCodeValidator;

public class Main {

    public static void main(String[] args) {

        Map<String, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Student Management System (JDK 25) ---");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Search by National Code");
            System.out.println("3. Delete Student");
            System.out.println("4. Edit Student Name");
            System.out.println("5. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> {  // افزودن دانشجو
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter National Code: ");
                    String code = scanner.nextLine();

                    if (!NationalCodeValidator.isValid(code)) {
                        System.out.println("❌ Invalid National Code!");
                        break;
                    }

                    studentMap.put(code, name);
                    System.out.println("✅ Student added successfully!");
                }

                case "2" -> {  // جستجو
                    System.out.print("Enter National Code to search: ");
                    String code = scanner.nextLine();

                    if (studentMap.containsKey(code)) {
                        System.out.println("✅ Student Name: " + studentMap.get(code));
                    } else {
                        System.out.println("❌ Student not found.");
                    }
                }

                case "3" -> {  // حذف
                    System.out.print("Enter National Code to delete: ");
                    String code = scanner.nextLine();

                    if (studentMap.containsKey(code)) {
                        studentMap.remove(code);
                        System.out.println("✅ Student removed successfully!");
                    } else {
                        System.out.println("❌ Student not found.");
                    }
                }

                case "4" -> {  // ویرایش
                    System.out.print("Enter National Code to edit: ");
                    String code = scanner.nextLine();

                    if (studentMap.containsKey(code)) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        studentMap.put(code, newName);
                        System.out.println("✅ Student name updated!");
                    } else {
                        System.out.println("❌ Student not found.");
                    }
                }

                case "5" -> {  // خروج
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("❌ Invalid option.");
            }
        }
    }
}
