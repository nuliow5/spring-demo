package lt.gerasimovas.springdemo.service;

import lombok.Getter;
import lt.gerasimovas.springdemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter
public class StudentService {
    List<Student> students = new ArrayList<>();
    Long index = 1L;

    public List<Student> createStudents(Student student){
        student.setId(index);
        index++;
        students.add(student);

        System.out.println(student);


        return students;
    }

    public Map<Long, Student> toHashMap(){
        Map<Long, Student> maps = new HashMap<>();
        for (int i = 0; i < students.size(); i++) {
            maps.put(students.get(i).getId(), students.get(i));
        }

        return maps;
    }

    public List<Student> removeStudent(long id){
        Map<Long, Student> studentMap = toHashMap();

        studentMap.remove(id);

        Collection<Student> values = studentMap.values();

        List<Student> newStudentList = new ArrayList<>((Collection) studentMap);

        return newStudentList;

    }

    public ArrayList<Student> removeStudent2(long id){
        List<Student> stud = students;
        for (int i = 0; i < stud.size(); i++) {
            if (stud.get(i).getId() == id){
                stud.remove(i);
            }
        }

        return (ArrayList<Student>) stud;
    }


}
