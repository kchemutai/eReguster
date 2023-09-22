package edu.mum.cs.cs425.eRegistrar.controller;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import edu.mum.cs.cs425.eRegistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/eregister/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ModelAndView listStudents() {
        List<Student> students = studentService.listStudents();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("student/students-list");
        return modelAndView;
    }

    @GetMapping("/new")
    public String displayAddNewStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "student/new";
    }

    @GetMapping("/edit/{id}")
    public String displayEditStudentForm(@PathVariable Long id, Model model){
        Student student = studentService.getStudent(id);
        if(student!=null){
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "redirect:/eregister/students/list";
    }

    @PostMapping("/new")
    public String registerStudent(
            @Validated
            @ModelAttribute("student") Student student,
            BindingResult bindingResult,
            Model model
    ){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        student = studentService.registerStudent(student);
        return "redirect:/eregister/students/list";
    }

    @PostMapping("/edit")
    public String updateStudent(
            @Validated
            @ModelAttribute("student") Student student,
            BindingResult bindingResult,
            Model model
    ){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.registerStudent(student);
        return "redirect:/eregister/students/list";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/eregister/students/list";
    }

    @GetMapping("/search")
    public String searchForStudent(@RequestBody String id, Model model){
        System.out.println(id);
       Student student = studentService.getStudent(1);
       model.addAttribute("student", student);
       return "student/student";
    }
}
