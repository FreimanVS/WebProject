package com.hihoall.controller;

import com.hihoall.entity.Comments2;
import com.hihoall.service.TheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author Brightsunrise
 * @version 1.0
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TheService<Comments2> comments2TheService;

    @RequestMapping("/")
    public String admin() {
        return "admin/admin";
    }

    @RequestMapping("/listComments2")
    public String listComments2(Model model) {
        List<Comments2> listComents =  comments2TheService.getList();

        model.addAttribute("comments2", listComents);

        return "admin/listComments2";
    }

    @GetMapping("/deleteComments2")
    public String deleteComments2(@RequestParam("id") int id) {

        comments2TheService.delete(id);

        return "redirect:/admin/listComments2";
    }

    @GetMapping("/updateComments2")
    public String updateComments2(@RequestParam("id") int id,
                                    Model theModel) {

        Comments2 comments2 = comments2TheService.get(id);

        theModel.addAttribute("comments2", comments2);

        return "admin/form";
    }

    @PostMapping("/saveComments2")
    public String saveComments2(@ModelAttribute("comments2") Comments2 comments2) {

        Calendar calendar = Calendar.getInstance();
        Long date = calendar.getTimeInMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String timecomment = dateFormat.format(date);

        comments2.setTimecomment(timecomment);

        comments2TheService.add(comments2);

        return "redirect:/admin/listComments2";
    }

    @GetMapping("/addComments2")
    public String showFormForAdd(Model theModel) {

        Comments2 comments2 = new Comments2();

        theModel.addAttribute("comments2", comments2);

        return "admin/form";
    }

    @PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                  Model theModel) {
        List<Comments2> comments2 = comments2TheService.search(theSearchName);

        theModel.addAttribute("comments2", comments2);

        return "admin/listComments2";
    }
}
