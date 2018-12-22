package test;// Please, do not use internet or any other sources of information during the test
// tast shouldn’t take more than 30 minutes
// There are 3 classes: Student, Subject and Mark
// - Fill the data according to the following conditions (use lists)
// 1. It is known that there are such students in the group: Valery Popov, Semyon Korzhev, Peter Ivanov, Maria Semenova and Kolya Nesterenko
// 2. Mathematics, Physics, Astronomy, History and Ethics are learned by this group and all subjects are mandatory excluding Ethics. It is optional.
// 3. Fill the data about marks if it is known that students have mark 3 for mandatory subjects and Maria has mark 5 for History and Ethics.
// 4. Please print results in a such way:
//   Popova Valeria Mathematics-1 Physics-2 Astronomy-0 History-1 Ethics-3 (do not display the subject info if there is no data about it)

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // 1
        List<Student> students = new ArrayList<>();
        students.add(new Student("Valery", "Popov"));
        students.add(new Student("Semyon", "Korzhev"));
        students.add(new Student("Maria", "Semenova"));
        students.add(new Student("Kolya", "Nesterenko"));
        // 2
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Mathematics", true));
        subjects.add(new Subject("Physics", true));
        subjects.add(new Subject("Astronomy", true));
        subjects.add(new Subject("History", true));
        subjects.add(new Subject("Ethics", false));
        // 3
        List<Mark> marks = new ArrayList<>();
        for (Student student : students){
            for (Subject subject : subjects){
                if (subject.isMandatory()){
                    if (student.getFirstName().equals("Maria") && subject.getName().equals("History"))
                        marks.add(new Mark(student, subject, 5));
                    else
                        marks.add(new Mark(student, subject, 3));
                } else {
                    if (student.getFirstName().equals("Maria"))
                        marks.add(new Mark(student, subject, 5));
                }

            }
        }
        // 4
        for (Student student : students){
            System.out.print(student.getLastName() + " " + student.getFirstName());
            for (Mark mark : marks){
                if (mark.getStudent().equals(student)){
                    System.out.print(" " + mark.getSubject().getName() + "-" + mark.getRank());
                }
            }
            System.out.println();
        }
    }
}
