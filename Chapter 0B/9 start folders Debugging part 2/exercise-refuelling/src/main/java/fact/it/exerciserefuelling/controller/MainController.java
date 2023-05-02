package fact.it.exerciserefuelling.controller;

import fact.it.exerciserefuelling.model.Refuelling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {


    @RequestMapping("/calculate-refuelling")
    public String calculate(Model model, HttpServletRequest request){

        int previous = Integer.parseInt(request.getParameter("previous"));
        int current = Integer.parseInt(request.getParameter("current"));
        double litre = Double.parseDouble(request.getParameter("litre"));
        Refuelling refuelling = new Refuelling(previous, current, litre);

        model.addAttribute("refuellingoutput", refuelling);
        return "refuelling";
    }
}
