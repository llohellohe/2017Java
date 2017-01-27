package com.yangqi.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * Created by yangqi on 25/01/2017.
 */
@Controller
public class HomeController {
    @RequestMapping(value="/", method=GET)
    public String home() {
        return "home";
    }
}
