package com.example.lambda2.controller;

import com.example.lambda2.model.Course;
import com.example.lambda2.model.School;
import com.example.lambda2.model.Student;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    private School school;

    @PostConstruct
    public void init() {
        school = new School();
    }


    @RequestMapping("/")
    public String passinfo(Model model) {
        List<Course> courses = school.getCourseList();

        model.addAttribute("courses", courses);

        return "index";
    }

    @RequestMapping("/filterstudents")
    public String studentfiltering (HttpServletRequest request, Model model) {

        String ageinput = request.getParameter("age");
        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        int age = -1;
        if (ageinput != null  && !ageinput.isEmpty()) {
            age = Integer.parseInt(ageinput);
        }

        String courseinput = request.getParameter("coursenumber");
        int coursenumber = -1;
        if (courseinput !=null && !courseinput.isEmpty()) {
            coursenumber = Integer.parseInt(courseinput);
        }

        String course = request.getParameter("course");

        List<Student> listofstudents = school.getFilteredList(lastname,firstname,age,coursenumber,course);

        model.addAttribute("listofstudents", listofstudents);

        return "studentlist";

    }



}
