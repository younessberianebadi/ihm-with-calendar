package io.digiwise.ihmmt.controllers;

import io.digiwise.ihmmt.dto.ObjectifDTO;
import io.digiwise.ihmmt.model.Entity;
import io.digiwise.ihmmt.model.Event;
import io.digiwise.ihmmt.model.Objectif;
import io.digiwise.ihmmt.model.User;
import io.digiwise.ihmmt.repository.EntityRepository;
import io.digiwise.ihmmt.repository.EventRepository;
import io.digiwise.ihmmt.repository.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Controller
public class MainController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ObjectifRepository objectifRepository;

    @Autowired
    private EntityRepository entityRepository;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/addobj")
    public String addobjectif(Model model){
        List<Entity> entities = (List<Entity>) entityRepository.findAll();
        model.addAttribute("entities", entities);
        User user = new User(5, "username", "fname", "lname", "example@mail.com", "00-0000-0000", "DVGP", "DVGP");
        model.addAttribute("user", user);
        ObjectifDTO objectifDTO = new ObjectifDTO();
        model.addAttribute("objectifDTO", objectifDTO);
        Objectif objectif = new Objectif();
        model.addAttribute("objectif", objectif);
        return "addobjectif";
    }

    @PostMapping("/saveobjectif")
    public String submitForm(@ModelAttribute("objectif") Objectif objectif, @ModelAttribute("objectifs") ObjectifDTO objectifDTO) {
        objectifRepository.insert(objectif);
        for (int i = 0; i < objectifDTO.getObjectifs().size(); i++) {
            objectifRepository.insert(objectifDTO.getObjectifs().get(i));
        }
        return "objectiflist";
    }

    @GetMapping("/addagence")
    public String addagence(){
        return "addag";
    }

    @GetMapping("/listagence")
    public String listagence(){
        return "aglist2";
    }

    @GetMapping("/updateagence")
    public String updateagence(){
        return "editagence";
    }

    @GetMapping("/calendar")
    public String maincalendar(Model model){
        List<Event> events = (List<Event>) eventRepository.findAll();
        model.addAttribute("events", events);
        return "maincalendar";
    }

    @GetMapping("/eventlist")
    public String eventlist(Model model){
        List<Event> events = (List<Event>) eventRepository.findAll();
        model.addAttribute("events", events);
        return "eventlist";
    }

    @GetMapping("/objectiflist")
    public String objectiflist(Model model){
        List<Objectif> objectifs = (List<Objectif>) objectifRepository.findAll();
        model.addAttribute("objectifs", objectifs);
        return "objectiflist";
    }

    @GetMapping("/addevent")
    public String addevent(Model model){
        model.addAttribute("event", new Event());
        return "addevent";
    }

    @RequestMapping(value = "saveevent", method = RequestMethod.POST)
    public String saveevent(Event event){
//        EventRepository.
        return "redirect:/calendar";
    }
}
