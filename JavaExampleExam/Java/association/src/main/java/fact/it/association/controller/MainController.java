package fact.it.association.controller;

import fact.it.association.model.*;
import fact.it.association.repository.ClubRepository;
import fact.it.association.repository.EventRepository;
import fact.it.association.repository.JoggerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class MainController {
    private final ClubRepository clubRepository;
    private final EventRepository eventRepository;
    private final JoggerRepository joggerRepository;

    public MainController(ClubRepository clubRepository,
                          EventRepository eventRepository,
                          JoggerRepository joggerRepository){
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
        this.joggerRepository = joggerRepository;
    }

    @PostConstruct
    public void fillDatabase(){
        Club club1 = new Club("RunningClub", "Bali", 200);
        Club club2 = new Club("SlowClub", "Hell", 100);
        clubRepository.save(club1);
        clubRepository.save(club2);

        Jogger jogger1 = new Jogger(1, 2001, "Michael Camerlynck", "The Beach", new Time(12, 12), Gender.MAN, club1);
        Jogger jogger2 = new Jogger(2, 2002, "Someone Else", "Geel", new Time(15, 12), Gender.WOMAN, club1);
        Jogger jogger3 = new Jogger(3, 2000, "Name", "Belgium", new Time(18, 12), Gender.X, club2);
        joggerRepository.save(jogger1);
        joggerRepository.save(jogger2);
        joggerRepository.save(jogger3);

        Event event1 = new Event("RunningEvent", "Sanur", 2022, club1);
        Event event2 = new Event("SlowEvent", "Hawai", 2023, club2);
        eventRepository.save(event1);
        eventRepository.save(event2);
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/view_joggers")
    public String viewJoggers(Model model){
        List<Jogger> joggers = joggerRepository.findAll();
        model.addAttribute("joggers", joggers);
        return "view_joggers";
    }
}
