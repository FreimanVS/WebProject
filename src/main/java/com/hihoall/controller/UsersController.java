package com.hihoall.controller;

import com.hihoall.entity.User;
import com.hihoall.service.SecurityService;
import com.hihoall.service.TheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by Brightsunrise on 14.12.2016.
 */

@Controller
@RequestMapping("/users")
public class UsersController {

    //to fix the problem with whitespaces from form data
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @Autowired
    private TheService<User> userTheService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(HttpSession session, Locale locale, Model model) {

        model.addAttribute("user", new User());
        System.out.println("locale.getDisplayLanguage() - " + locale.getDisplayLanguage());
        System.out.println("locale - " + locale);
        System.out.println("locale.getDisplayName() - " + locale.getDisplayName());
        System.out.println("locale.getDisplayName(locale) - " + locale.getDisplayName(locale));
        System.out.println("new String[] { locale.getDisplayName(locale) } - "
                + new String[] { locale.getDisplayName(locale) });
        System.out.println(messageSource.getMessage("locale", new String[] { locale.getDisplayName(locale) }, locale));
        return "registration-newdb";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Locale locale,
                      @Valid @ModelAttribute("user") User user,
                      BindingResult bindingResult,
                      Model model,
                      ModelMap modelMap) {

        modelMap.addAttribute("locale", messageSource
                .getMessage("locale", new String[] {locale.getDisplayName(locale)}, locale));

        if (bindingResult.hasErrors()) {
            return "registration-newdb";
        }

        User dbUser = userTheService.get("username", user.getUsername());
        if (dbUser != null) {
            model.addAttribute("isAlreadyExist", "such user already exist");
            return "registration-newdb";
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            model.addAttribute("doesntMatch", "the password and the confirm password have to match");
            return "registration-newdb";
        }

        userTheService.add(user);

        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());
        return "redirect:/index";
    }

}
