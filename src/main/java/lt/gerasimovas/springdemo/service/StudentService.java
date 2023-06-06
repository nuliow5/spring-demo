package lt.gerasimovas.springdemo.service;

import lombok.Getter;
import lt.gerasimovas.springdemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Getter
public class StudentService {
    private List<Student> students = new ArrayList<>();
    private Map<Long, Student> studentsMap = new HashMap<>();
    Long index = 1L;

    public List<Student> createStudents(Student student) {
        student.setId(index);
        students.add(student);

        studentsMap.put(index, student);
        index++;

        return students;
    }


    public List<Student> removeStudent(long id) {
        studentsMap.remove(id);
        List<Student> students = new ArrayList<>(studentsMap.values());
        return students;
    }

    public List<Student> removeStudent2(long id) {
        List<Student> stud = students;
        for (int i = 0; i < stud.size(); i++) {
            if (stud.get(i).getId() == id) {
                stud.remove(i);
            }
        }

        return stud;
    }

    public List<Student> removeStudentWithStreams(long id) {
        students.removeIf(student -> student.getId() == id);
        return students;
    }


    public Student getStudentById(long id) {
       Student studentToGet =
                students.stream()
                        .filter(stud -> stud.getId().equals(id))
                        .findFirst().orElseThrow();
        return studentToGet;
    }


    public List<Student> updateStudentById(long id, Student student) {
        Student updateStudent = getStudentById(id);
        updateStudent.setName(student.getName());
        updateStudent.setSurName(student.getSurName());
        updateStudent.setCourse(student.getCourse());

        return students;
    }
}
