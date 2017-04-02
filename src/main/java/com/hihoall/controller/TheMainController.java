package com.hihoall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Brightsunrise on 28.12.2016.
 */

@Controller
public class TheMainController {
    @RequestMapping("/")
    public String showPage() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
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

    @GetMapping("/search")
    public String search(@RequestParam("search_field") String search_field) {
        return "forward:/movies/search";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

    @GetMapping("/admin")
    public String admin() {
        return "redirect:/admin/";
    }
}
