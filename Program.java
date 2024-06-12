import java.util.Arrays;

import controller.Controller;

public class Program {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createTeacher("Сергей", "Сергеевич", "Сергеев");
        controller.createTeacher("Александр", "Александрович", "Александров");
        controller.createStudent("Олег", "Попович", "Попов");
        controller.createStudent("Иван", "Иванович", "Иванов");
        controller.createStudent("Михаил", "Михайлович", "Михайлов");
        controller.createStudent("Марат", "Маратович", "Маратов");
        controller.printTeachers();
        controller.printStudents();
        controller.createStudyGroup(1, Arrays.asList(1, 2));
        controller.createStudyGroup(2, Arrays.asList(3,4));
        controller.printStudyGroups();
    }
}
