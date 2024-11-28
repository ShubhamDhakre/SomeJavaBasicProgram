import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String studentID;
    private float percentage;

    public Student(String name, int age, String studentID, float percentage) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentID() {
        return studentID;
    }

    public float getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "\n Student ID:" + studentID + "\n Name:  " + name + "\n  Age:  " + age + "\n Percentage:" + percentage;
    }

   
    public String toCSV() {
        return studentID + "\n " + name + "\n " + age + "\n " + percentage;
    }


    public static Student fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new Student(parts[1], Integer.parseInt(parts[2]), parts[0], Float.parseFloat(parts[3]));
    }
}

public class StudentManagement {
    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

    
        loadFromFile(students);

        int option;
        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students Information");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
             
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter student percentage: ");
                    float percentage = scanner.nextFloat();

                    Student student = new Student(name, age, studentID, percentage);
                    students.add(student);

                
                    saveToFile(students);
                    System.out.println("Student information has been stored!");
                    break;

                case 2:
             
                    if (students.isEmpty()) {
                        System.out.println("No student data available.");
                    } else {
                        System.out.println("\nList of Students:");
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (option != 3);

        scanner.close();
    }


    private static void loadFromFile(ArrayList<Student> students) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(Student.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("No existing data found. Starting fresh...");
        }
    }


    private static void saveToFile(ArrayList<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.println(s.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
