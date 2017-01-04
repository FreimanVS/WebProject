package com.hihoall.controller;

import com.hihoall.entity.Grades;
import com.hihoall.service.TheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Brightsunrise on 25.12.2016.
 */

@Controller
@RequestMapping("/grades")
public class GradesController {
    @Autowired
    private TheService<Grades> gradesTheService;

    @GetMapping("/update")
    public String update(@RequestParam("idmovie") int idmovie,
                         @RequestParam("grade") int grade,
                         @RequestParam("nick") String nick,
                         Model model) {

        List<Grades> listGrades = gradesTheService.getList("idmovie", idmovie, "nick", nick);

        if(grade != 0) {
            if (listGrades.size() != 0) {
                Grades theGrade = listGrades.get(0);

                int getGrade = theGrade.getGrade();
                int diffGrade = grade - getGrade;

                if (diffGrade != 0) {
                    int getId = theGrade.getId();
                    gradesTheService.update("grade", grade, getId);

                    model.addAttribute("diffGrade", diffGrade);
                    model.addAttribute("firstVote", false);

                    return "forward:/movies/update";
                } else {
                    return "redirect:/show?idmovie=" + idmovie;
                }
            } else {

                Grades newGrade = new Grades(idmovie, nick, grade);
                gradesTheService.add(newGrade);
                model.addAttribute("diffGrade", grade);
                model.addAttribute("firstVote", true);

                return "forward:/movies/update";
            }
        } else {
            return "redirect:/show?idmovie=" + idmovie;
        }
    }
}
