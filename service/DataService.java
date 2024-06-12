package service;

import java.util.ArrayList;
import java.util.List;

import model.User;
import model.Student;
import model.Teacher;
import model.Type;

public class DataService {
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }
    
    public void create(String firstName, String secondName, String lastName, Type type) {
        int id = getId(type);
        if(Type.Student == type) {
            Student student = new Student(id, firstName, secondName, lastName);
            userList.add(student);
        }
        if(Type.Teacher == type) {
            Teacher teacher = new Teacher(id, firstName, secondName, lastName);
            userList.add(teacher);
        }
    }

    private int getId (Type type) {
        int id = 0;
        for (User user : userList) {
            if(user instanceof Teacher && Type.Teacher == type) {
                id = ((Teacher) user).getTeacherId();
            }
            if(user instanceof Student && Type.Student == type) {
                id = ((Student) user).getStudentId();
            }
        }
        return ++id;
    }
    
    public List<User> getAllStudents () {
        List<User> studentList = new ArrayList<>();
        for (User user : userList) {
            if(user instanceof Student) {
                studentList.add(user);
            }
        }
        return studentList;
    }

    public List<User> getAllTeachers () {
        List<User> teacherList = new ArrayList<>();
        for (User user : userList) {
            if(user instanceof Teacher) {
                teacherList.add(user);
            }
        }
        return teacherList;
    }
}
