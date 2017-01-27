package com.yangqi.springmvc.web;

import com.yangqi.springmvc.service.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yangqi on 25/01/2017.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository repo){
       this.spittleRepository=repo;
    }


    @RequestMapping(method= RequestMethod.GET)
    public String spittles(Model model, @RequestParam(value="max",defaultValue = "100") long max,@RequestParam(value="count",defaultValue = "8") int count) {
        model.addAttribute(
                spittleRepository.findSpittles(
                        Long.MAX_VALUE, 20));
        System.out.println("========YOU========"+max+"========"+count);
        return "spittles";
    }

    @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
    public String showSpittle(
            @PathVariable("spittleId") long spittleId,
            Model model, HttpServletRequest request) {
        String name=request.getParameter("name");
        System.out.println("========PATH VALUE========"+spittleId+"========name "+name);
        return "spittles";
    }

}
