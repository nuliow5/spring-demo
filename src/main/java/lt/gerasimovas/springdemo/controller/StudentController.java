package lt.gerasimovas.springdemo.controller;

import lt.gerasimovas.springdemo.model.Student;
import lt.gerasimovas.springdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
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

    @GetMapping("/update/{id}")
    public String editStudent(@PathVariable("id") long id, Model model){
       Student student = studentService.getStudentById(id);

        model.addAttribute("student", student);

        return "edit-student";
    }

    @PostMapping("/update/{id}")
    public String editStudent(@PathVariable("id") long id, @ModelAttribute Student student, Model model){
        List<Student> students = studentService.updateStudentById(id, student);

        model.addAttribute("students", students);

        return "students_list_form";
    }






}
