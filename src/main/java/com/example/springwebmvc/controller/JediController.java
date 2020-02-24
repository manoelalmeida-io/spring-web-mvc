package com.example.springwebmvc.controller;

import com.example.springwebmvc.model.Jedi;
import com.example.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class JediController {

    @Autowired
    private JediRepository repository;

    @GetMapping("/jedi")
    public ModelAndView jedi () {
        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("jedi");
        modelAndView.addObject("allJedi", repository.findAll());

        return modelAndView;
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "new-jedi";
        }

        repository.save(jedi);
        redirectAttributes.addFlashAttribute("message", "Jedi successfully saved.");

        return "redirect:jedi";
    }

    @GetMapping("/jedi/{id}/delete")
    public String deleteJedi (@PathVariable("id") final Long id, RedirectAttributes redirect) {
        final Optional<Jedi> jedi = repository.findById(id);
        repository.delete(jedi.get());

        redirect.addFlashAttribute("message", "Jedi successfully deleted.");

        return "redirect:/jedi";
    }

    @GetMapping("/jedi/{id}/update")
    public String updateJedi (@PathVariable("id") final Long id, Model model) {
        final Optional<Jedi> jedi = repository.findById(id);

        model.addAttribute("jedi", jedi.get());

        return "edit-jedi";
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi () {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");
        modelAndView.addObject("jedi", new Jedi());
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView jediSearch (@RequestParam(value = "name") final String name) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        modelAndView.addObject("allJedi", repository.findByNameContainingIgnoreCase(name));

        return modelAndView;
    }
}
