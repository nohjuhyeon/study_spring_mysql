package com.example.co_templates.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemplateJSP {
    @GetMapping("/templateWithJSP")
    public ModelAndView templateWithJSP(){
        String viewPath = "src/webapp/WEB-INF/views/template.jsp";
        ModelAndView ModelAndView = new ModelAndView();
        ModelAndView.setViewName(viewPath);
        return ModelAndView;
    }
    
}
