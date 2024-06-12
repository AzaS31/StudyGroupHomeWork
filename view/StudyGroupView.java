package view;

import model.Student;
import model.StudyGroup;

public class StudyGroupView {
    public void printStudyGroup(StudyGroup studyGroup) {
        System.out.println("Study group:");
        System.out.println("Teacher: " + studyGroup.getTeacher());
        System.out.print("Students: ");
        for (Student student : studyGroup.getStudents()) {
            System.out.println(student);
        }
        System.out.println();
    }
}