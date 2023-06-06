package lt.gerasimovas.springdemo.controller;

import lt.gerasimovas.springdemo.model.Student;
import lt.gerasimovas.springdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/create")
    public String showCreateStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "create-student";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student") Student student, Model model){
        List<Student> students = studentService.createStudents(student);

        model.addAttribute("students", students);

        return "students_list_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model){
//        List<Student> students = studentService.removeStudent(id);
        List<Student> students = studentService.removeStudentWithStreams(id);

        model.addAttribute("students", students);
        return "students_list_form";

    }

}
