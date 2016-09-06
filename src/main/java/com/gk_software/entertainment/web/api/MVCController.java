package com.gk_software.entertainment.web.api;

/**
 * Created by vgogilchyn on 06.09.16.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MVCController {

    @RequestMapping("/")
    public String greeting(Model model) {
        return "index";
    }

    @RequestMapping(value="/{teamName}/stats")
    public String stats(@PathVariable String teamName, Model model) {
        model.addAttribute("name", teamName);
        return "stats";
    }
}