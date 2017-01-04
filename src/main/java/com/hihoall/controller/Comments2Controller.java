package com.hihoall.controller;

import com.hihoall.entity.Comments2;
import com.hihoall.service.TheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by Brightsunrise on 14.12.2016.
 */

@Controller
@RequestMapping("/comments2")
public class Comments2Controller {
    @Autowired
    private TheService<Comments2> comments2TheService;

    @PostMapping("/getComments")
    public String getComments(Model model,
                              @RequestParam("idmovie") int idmovie) {
        List<Comments2> comments = comments2TheService.getList(idmovie);

        //a shallow copy
        List<Comments2> shallowCopy = comments.subList(0, comments.size());
        //a reversed shallow copy
        Collections.reverse(shallowCopy);

        model.addAttribute("comments", shallowCopy);

        return "commentsblock-newdb";
    }

    @PostMapping("/add")
    public String add(@RequestParam("idmovie") int idmovie,
                      @RequestParam("namemovie") String namemovie,
                      @RequestParam("content") String content,
                      @RequestParam("nick") String nick) {

        Calendar calendar = Calendar.getInstance();
        Long date = calendar.getTimeInMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String timecomment = dateFormat.format(date);

        Comments2 theComments = new Comments2(idmovie, namemovie, timecomment, content, nick);

        comments2TheService.add(theComments);
        return "forward:/comments2/getComments";
    }
}
