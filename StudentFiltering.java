import java.util.*;
import java.util.stream.*;

public class StudentFiltering {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 70));
        students.add(new Student("Charlie", 90));
        students.add(new Student("David", 65));
        students.add(new Student("Eve", 80));

        System.out.println("Students scoring above 75% sorted by marks:");

        students.stream()
                .filter(student -> student.getMarks() > 75)
                .sorted(Comparator.comparingInt(Student::getMarks))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}
