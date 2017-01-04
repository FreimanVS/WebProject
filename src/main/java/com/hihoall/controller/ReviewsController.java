package com.hihoall.controller;

import com.hihoall.entity.Reviews;
import com.hihoall.service.TheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Brightsunrise on 30.12.2016.
 */

@Controller
@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired
    private TheService<Reviews> reviewsTheService;

    @PostMapping("/add")
    public String add(@RequestParam("review_name") String review_name,
                      @RequestParam("review_email") String review_email,
                      @RequestParam("review_text") String review_text) {
        Reviews theMovie = new Reviews(review_name, review_email, review_text);
        reviewsTheService.add(theMovie);
        return "redirect:/reviews/success";
    }

    @GetMapping("/success")
    public String success() {
        return "contact-success";
    }
}
