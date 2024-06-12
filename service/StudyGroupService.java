package service;

import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.StudyGroup;
import model.Teacher;
import model.User;

public class StudyGroupService {
    private List<User> userList = new ArrayList<>();
    private List<StudyGroup> studyGroupList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public List<StudyGroup> getStudyGroupList() {
        return studyGroupList;
    }

    public void createStudyGroup(int teacherId, List<Integer> studentIds) {
        Teacher teacher = null;
        List<Student> students = new ArrayList<>();

        for (User user : userList) {
            if (user instanceof Teacher && ((Teacher) user).getTeacherId() == teacherId) {
                teacher = (Teacher) user;
            }
            if (user instanceof Student && studentIds.contains(((Student) user).getStudentId())) {
                students.add((Student) user);
            }
        }

        if (teacher != null && !students.isEmpty()) {
            StudyGroup studyGroup = new StudyGroup(teacher, students);
            studyGroupList.add(studyGroup);
        }
    }
}
