package com.hihoall.controller;

import com.hihoall.entity.Movies;
import com.hihoall.service.TheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Brightsunrise on 17.12.2016.
 */

@Controller
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private TheService<Movies> moviesTheService;

    @GetMapping("/get")
    public String get(Model model) {
        List<Movies> movies = moviesTheService.getList();
        model.addAttribute("movies", movies);
        return "films-get";
    }

    @GetMapping("/getBestFour")
    public String getLastFour(Model model) {
        List<Movies> tempList = moviesTheService.getListOrderBy("rating", "DESC");
        List<Movies> movies = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            Movies tempMovie = tempList.get(i);
            movies.add(tempMovie);
        }
        model.addAttribute("movies", movies);
        return "movies-get-best-four";
    }

    @GetMapping("/getBestFourSidebar")
    public String getBestFourSidebar(Model model) {
        List<Movies> tempList = moviesTheService.getListOrderBy("rating", "DESC");
        List<Movies> movies = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            Movies tempMovie = tempList.get(i);
            movies.add(tempMovie);
        }
        model.addAttribute("movies", movies);
        return "movies-get-best-four-sidebar";
    }

    @GetMapping("/getOrderByRating")
    public String getOrderByRating(Model model) {
        List<Movies> movies = moviesTheService.getListOrderBy("rating", "DESC");
        model.addAttribute("movies", movies);
        return "rating";
    }

    @GetMapping("/getShow")
    public String getShow(Model model,
                          @RequestParam("idmovie") int idmovie) {
        //getList movie by id
        Movies movie = moviesTheService.get(idmovie);

        model.addAttribute("movie", movie);
        return "forward:/show2";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search_field") String search_field,
                         Model model) {
        List<Movies> movies = moviesTheService.search(search_field);
        model.addAttribute("movies", movies);
        return "search";
    }

    @GetMapping("/update")
    public String update(@RequestParam("idmovie") int idmovie,
                         @RequestParam("nick") String nick,
                         @RequestAttribute("diffGrade") int diffGrade,
                         @RequestAttribute("firstVote") boolean firstVote) {
        Movies theMovie = moviesTheService.get(idmovie);
        Float theRating = theMovie.getRating();
        int theAmountOfVoters = theMovie.getAmountofvoters();

        Float newRating;
        int newAmountOfVoters;
        if(firstVote) {
            newAmountOfVoters = theAmountOfVoters + 1;
            newRating = (theRating * theAmountOfVoters + diffGrade) / (newAmountOfVoters);
        } else {
            newAmountOfVoters = theAmountOfVoters;
            newRating = (theRating * theAmountOfVoters + diffGrade) / (newAmountOfVoters);
        }

        Float newRatingRounded = roundedFloat(newRating, 1);

        moviesTheService.update("amountofvoters", newAmountOfVoters, idmovie);

        moviesTheService.update("rating", newRatingRounded, idmovie);

        return "redirect:/show?idmovie=" + idmovie;
    }

    private static final MathContext myMathContext = new MathContext(15, RoundingMode.HALF_UP);

    private static Float roundedFloat(Float obj, int numbersAfterPoint) {
        BigDecimal bd = new BigDecimal(obj, myMathContext);
        BigDecimal bdRounded = bd.setScale(numbersAfterPoint, RoundingMode.HALF_UP);
        return bdRounded.floatValue();
    }
}
