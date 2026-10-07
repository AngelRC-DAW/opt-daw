package com.actividad3.actividad3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Actividad3Controller {

    @GetMapping("/elegir")
    public String elegirIdioma(@RequestParam(name = "idioma", required = false) String idioma) {
        if (idioma == null) {
            return "redirect:/english.html";
        }

        switch (idioma.toLowerCase()) {
            case "spanish.html":
                return "redirect:/spanish.html";
            case "german.html":
                return "redirect:/german.html";
            case "french.html":
                return "redirect:/french.html";
            default:
                return "redirect:/english.html";
        }
    }
}
