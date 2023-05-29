package fact.it.course.controller;

import jakarta.servlet.http.HttpServletRequest;
import model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {
    @RequestMapping("/submitcourse")
    public String submitCourse(HttpServletRequest request, Model model) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        String courseName = request.getParameter("courseName");
        String location = request.getParameter("location");
        String date = request.getParameter("startDate");
        LocalDate startDate = LocalDate.parse(date, formatter);
        Integer nmOfDays = Integer.parseInt(request.getParameter("nmOfDays"));
        boolean weekly = (request.getParameter("weekly") !=null);

        Course course = new Course(courseName);
        course.setLocation(location);
        course.setNumberOfDays(nmOfDays);
        course.setStartDate(startDate);
        course.setWeekly(weekly);

        model.addAttribute("courseName",courseName);
        model.addAttribute("location",location);
        model.addAttribute("nmOfDays",nmOfDays);
        model.addAttribute("startDate",startDate);
        model.addAttribute("weekly",weekly);

        return "courseinfo";
    }
}
