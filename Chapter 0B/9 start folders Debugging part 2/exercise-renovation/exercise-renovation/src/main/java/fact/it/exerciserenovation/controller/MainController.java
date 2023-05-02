package fact.it.exerciserenovation.controller;

import fact.it.exerciserenovation.model.Renovationproject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MainController {
    @RequestMapping("")
    public String index() {
        return "/";
    }

    @RequestMapping("/calculatepaint")
    public String calculatePaint(Model model, HttpServletRequest request) {
        String name = (String) request.getAttribute("name");
        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));
        double height = Double.parseDouble(request.getParameter("height"));
        int numberOfLayers = Integer.parseInt(request.getParameter("numberOfLayers"));
        Renovationproject renovationproject = new Renovationproject(length, width, height);
        renovationproject.setNumberOfLayers(numberOfLayers);

        if (request.getParameter("ceiling") != null) {
            renovationproject.setCeilingIncluded(true);
        }
        model.addAttribute("name", name);
        model.addAttribute("renovationproject", renovationproject);
        return "paint";
    }
}
