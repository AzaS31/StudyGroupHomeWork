package controller;

import java.util.List;

import model.Student;
import model.StudyGroup;
import model.Teacher;
import model.Type;
import model.User;
import service.DataService;
import service.StudyGroupService;
import view.StudentView;
import view.StudyGroupView;
import view.TeacherView;


public class Controller {
    private StudentView studentView = new StudentView();
    private TeacherView teacherView = new TeacherView();
    private StudyGroupView studyGroupView = new StudyGroupView();
    private DataService dataService = new DataService();
    private StudyGroupService studyGroupService = new StudyGroupService();
    
    public void createStudent (String firstName, String secondName, String lastName) {
        dataService.create(firstName, secondName, lastName, Type.Student);
        syncUserLists();
    }
    
    public void createTeacher (String firstName, String secondName, String lastName) {
        dataService.create(firstName, secondName, lastName, Type.Teacher);
        syncUserLists();
    }

    public void printStudents () {
        for (User iterable : dataService.getAllStudents()) {
            studentView.printOnConsole((Student)iterable);
        }
    }

    public void printTeachers () {
        for (User iterable : dataService.getAllTeachers()) {
            teacherView.printOnConsole((Teacher)iterable);
        }
    }

    public void createStudyGroup(int teacherId, List<Integer> studentIds) {
        studyGroupService.createStudyGroup(teacherId, studentIds);
    }

    public void printStudyGroups() {
        for (StudyGroup studyGroup : studyGroupService.getStudyGroupList()) {
            studyGroupView.printStudyGroup(studyGroup); 
        }
    }

    private void syncUserLists() {
        studyGroupService.getUserList().clear();
        studyGroupService.getUserList().addAll(dataService.getUserList());
    }

}
