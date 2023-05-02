package fact.it.exercisecourse.controller;

import fact.it.exercisecourse.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {
    public String index() {
        return "index";
    }

    @RequestMapping("/register")
    public String registerCourse(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        int numberOfDays = Integer.parseInt(request.getParameter("numberOfDays"));
        String weekly = request.getParameter("weekly");
        String date = request.getParameter("startDate");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDatum = LocalDate.parse(date, formatter);

        Course course = new Course(name, numberOfDays);
        course.setLocation(location);
        course.setStartDate(startDatum);
        if (weekly != null) {
            course.setWeekly(true);
        }
        model.addAttribute("courseinfo", course);
        model.addAttribute("formatter", formatter);
        return "course";
    }
}

