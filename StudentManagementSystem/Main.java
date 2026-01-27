import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student Course");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    dao.addStudent(new Student(name, email, course));
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();

                    dao.updateStudent(id, newCourse);
                    break;

                case 4:
                    System.out.print("Student ID: ");
                    int deleteId = sc.nextInt();
                    dao.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}