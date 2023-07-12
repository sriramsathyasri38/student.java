import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class CRUDApplication {
    private List<Student> students;
    private int nextId;

    public CRUDApplication() {
        students = new ArrayList<>();
        nextId = 1;
    }

    public void createStudent(String name) {
        Student student = new Student(nextId++, name);
        students.add(student);
        System.out.println("Student created successfully.");
    }

    public void readStudents() {
        System.out.println("ID\tName");
        for (Student student : students) {
            System.out.println(student.getId() + "\t" + student.getName());
        }
    }

    public void updateStudent(int id, String newName) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(newName);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void main(String[] args) {
        CRUDApplication application = new CRUDApplication();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create student");
            System.out.println("2. Read students");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("0. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.println("Enter the student name:");
                    String name = scanner.nextLine();
                    application.createStudent(name);
                    break;
                case 2:
                    application.readStudents();
                    break;
                case 3:
                    System.out.println("Enter the student ID:");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println("Enter the new name:");
                    String newName = scanner.nextLine();
                    application.updateStudent(idToUpdate, newName);
                    break;
                case 4:
                    System.out.println("Enter the student ID:");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    application.deleteStudent(idToDelete);
                    break;
                case 0:
                    System.out.println("Exiting application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
