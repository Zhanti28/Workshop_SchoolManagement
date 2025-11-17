package se.lexicon;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- School Management System ---");
            System.out.println("1. Create new student");
            System.out.println("2. Create new course");
            System.out.println("3. Register student to course");
            System.out.println("4. Remove student from course");
            System.out.println("5. Search student by name or email");
            System.out.println("6. Search course by name");
            System.out.println("7. Edit student");
            System.out.println("8. Edit course");
            System.out.println("9. Show all students");
            System.out.println("10. Show all courses");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    int id = studentDao.findAll().size() + 1;
                    studentDao.saveStudent(new Student(id, name, email, address));
                    System.out.println("Student created!");
                }

                case 2 -> {
                    System.out.print("Enter course name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter duration in weeks: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    LocalDate startDate = LocalDate.now();
                    int id = courseDao.findAll().size() + 1;
                    courseDao.saveCourse(new Course(id, name, startDate, duration));
                    System.out.println("✅ Course created!");
                }

                case 3 -> {
                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();
                    Student student = studentDao.findByEmail(email);
                    System.out.print("Enter course name: ");
                    String cname = scanner.nextLine();
                    Course course = courseDao.findByName(cname).stream().findFirst().orElse(null);

                    if (student != null && course != null) {
                        course.addStudent(student);
                        System.out.println("✅ Student registered to course!");
                    } else System.out.println("⚠️ Student or course not found.");
                }

                case 4 -> {
                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();
                    Student student = studentDao.findByEmail(email);
                    System.out.print("Enter course name: ");
                    String cname = scanner.nextLine();
                    Course course = courseDao.findByName(cname).stream().findFirst().orElse(null);

                    if (student != null && course != null) {
                        course.removeStudent(student);
                        System.out.println("✅ Student removed from course!");
                    } else System.out.println("⚠️ Student or course not found.");
                }

                case 5 -> {
                    System.out.print("Search by name or email: ");
                    String search = scanner.nextLine();
                    List<Student> found = studentDao.findByName(search);
                    if (found.isEmpty()) {
                        Student s = studentDao.findByEmail(search);
                        if (s != null) found.add(s);
                    }
                    System.out.println(found.isEmpty() ? "No student found." : found);
                }

                case 6 -> {
                    System.out.print("Enter course name: ");
                    String search = scanner.nextLine();
                    List<Course> found = courseDao.findByName(search);
                    System.out.println(found.isEmpty() ? "No course found." : found);
                }

                case 7 -> {
                    System.out.print("Enter student email to edit: ");
                    String email = scanner.nextLine();
                    Student s = studentDao.findByEmail(email);
                    if (s != null) {
                        System.out.print("New name (leave blank to keep same): ");
                        String name = scanner.nextLine();
                        if (!name.isEmpty()) s.setName(name);

                        System.out.print("New address (leave blank to keep same): ");
                        String address = scanner.nextLine();
                        if (!address.isEmpty()) s.setAddress(address);

                        System.out.println("Student updated!");
                    } else System.out.println("Student not found.");
                }

                case 8 -> {
                    System.out.print("Enter course name to edit: ");
                    String cname = scanner.nextLine();
                    Course c = courseDao.findByName(cname).stream().findFirst().orElse(null);
                    if (c != null) {
                        System.out.print("New name (leave blank to keep same): ");
                        String name = scanner.nextLine();
                        if (!name.isEmpty()) c.setCourseName(name);

                        System.out.print("New duration (0 to keep same): ");
                        int duration = scanner.nextInt();
                        scanner.nextLine();
                        if (duration > 0) c.setWeekDuration(duration);

                        System.out.println("Course updated!");
                    } else System.out.println("Course not found.");
                }

                case 9 -> {
                    System.out.println("All Students:");
                    for (Student s : studentDao.findAll()) System.out.println(s);
                }

                case 10 -> {
                    System.out.println("All Courses:");
                    for (Course c : courseDao.findAll()) System.out.println(c);
                }

                case 0 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}