package fact.it.startproject.controller;


import fact.it.startproject.model.Training;
import fact.it.startproject.model.TrainingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class TrainingController {

    TrainingRepository repository;

    public TrainingController(TrainingRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/add")
    public String addPage () {
        return "newtraining";
    }

    @RequestMapping("/edit")
    public String edit (HttpServletRequest request, Model model) {
        Long trainingid = Long.valueOf(request.getParameter("id"));
        Optional<Training> found = repository.findById(trainingid);
        if (found.isPresent()) {
            Training training = found.get();
            model.addAttribute("training", training);
        }

        return "edittraining";
    }


    @RequestMapping("/gettrainings")
    public String getList(Model model) {
        List<Training> traininglist = repository.findAll();
        model.addAttribute("traininglist", traininglist);

        return "listoftrainings";
    }

    @RequestMapping("/deletetraining")
    public String deleteTraining(HttpServletRequest request, Model model) {
        Long trainingid = Long.valueOf(request.getParameter("id"));
        repository.deleteById(trainingid);

        List<Training> trainingList = repository.findAll();
        model.addAttribute("traininglist", trainingList);

        return "listoftrainings";
    }

    @RequestMapping("/gettraining")
    public String getOneTraining(HttpServletRequest request, Model model) {
        Long trainingid = Long.valueOf(request.getParameter("id"));
        Optional<Training> found = repository.findById(trainingid);
        if (found.isPresent()) {
            Training training = found.get();
            model.addAttribute("training", training);
        }

        return "trainingdetails";
    }

    @RequestMapping("/addtraining")
    public String addTraining(HttpServletRequest request, Model model) {
        String code = request.getParameter("code");
        String title = request.getParameter("title");
        String theme = request.getParameter("theme");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int max = Integer.parseInt(request.getParameter("max"));

        Training training = new Training();

        training.setCode(code);
        training.setTitle(title);
        training.setTheme(theme);
        training.setDuration(duration);
        training.setMax(max);

        repository.save(training);

        List<Training> trainingList = repository.findAll();
        model.addAttribute("traininglist", trainingList);

        return "listoftrainings";
    }

    @RequestMapping("/edittraining")
    public String editTraining(HttpServletRequest request, Model model) {
        String code = request.getParameter("code");
        String title = request.getParameter("title");
        String theme = request.getParameter("theme");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int max = Integer.parseInt(request.getParameter("max"));

        Long trainingid = Long.valueOf(request.getParameter("id"));

        Optional<Training> found = repository.findById(trainingid);
        if (found.isPresent()) {
            Training training = found.get();
            training.setCode(code);
            training.setTitle(title);
            training.setTheme(theme);
            training.setDuration(duration);
            training.setMax(max);
            repository.save(training);
            model.addAttribute("training", training);
        }

        return "listoftrainings";
    }

    @RequestMapping("/gettrainingsbytheme")
    public String getTrainingsByTheme(Model model) {

        List<Training> traininglist = repository.findAllByOrderByThemeAsc();
        model.addAttribute("traininglist", traininglist);

        return "listoftrainings";
    }
}
