package com.hihoall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Brightsunrise on 28.12.2016.
 */

@Controller
public class TheMainController {
    @GetMapping("/")
    public String showPage() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/films")
    public String films() {
        return "films";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/rating")
    public String rating() {
        return "forward:/movies/getOrderByRating";
    }

    @GetMapping("/show")
    public String show() {
        return "forward:/movies/getShow";
    }

    @GetMapping("/show2")
    public String show2() {
        return "show";
    }

    @PostMapping("/search")
    public String search(@RequestParam("search_field") String search_field) {
        return "forward:/movies/search";
    }
}
