package fact.it.lambda.controller;


import fact.it.lambda.primecalculator.PrimeCalculator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PrimeController {
    @RequestMapping("/prime")
    public String calculatePrime (HttpServletRequest request, Model model){
        int number = Integer.parseInt(request.getParameter("value"));

        PrimeCalculator calculator = new PrimeCalculator();

        List<Integer> primelist = calculator.getAllPrimesUntil(number);

        model.addAttribute("primelist", primelist);

        return "/prime";
    }
}
