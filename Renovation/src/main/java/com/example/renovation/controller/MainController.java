package com.example.renovation.controller;

import com.example.renovation.model.RenovationProject;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/calculate")
    public String calculatePaint(HttpServletRequest request, Model model) {

        String name = request.getParameter("name");

        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));
        double height = Double.parseDouble(request.getParameter("height"));
        boolean ceiling = (request.getParameter("ceiling") != null);
        Integer layers = Integer.parseInt(request.getParameter("layer"));
        RenovationProject project = new RenovationProject(length, height, width);
        project.setCeilingIncluded(ceiling);
        project.setNumberOfLayers(layers);
        double total = project.getAmountOfPaintInLitres();

        model.addAttribute("name",name);
        model.addAttribute("total",total);

        return "paint";
    }
}
