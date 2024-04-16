package com.example.co_templates.quests.controller;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.co_templates.quests.services.QuestBoardService;
import com.example.co_templates.services.CommonCodeService;
@Controller
public class QuestBoardController {
    
    @Autowired 
    QuestBoardService BoardService;

@GetMapping("q/board/list")
    public ModelAndView list(ModelAndView modelAndView
                            , @RequestParam HashMap<String, String>  dataMap) {
       Object itemList = new ArrayList<HashMap<String, Object>>();
        // Call Service with Pure Java
        // CommonCodeService commonCodeService = new CommonCodeService();
        itemList = BoardService.list(1,dataMap);

        String viewPath = "/WEB-INF/views/boards/list.jsp";
        modelAndView.setViewName(viewPath);
        modelAndView.addObject("itemList", itemList);
        modelAndView.addObject("dataMap",dataMap);

        return modelAndView;
    }
}