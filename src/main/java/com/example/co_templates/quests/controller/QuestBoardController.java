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

    @GetMapping("q/board/list_pagination")
    public ModelAndView listPagination(ModelAndView modelAndView
                    , @RequestParam HashMap<String, Object> dataMap
                    , @RequestParam(name = "deleteIds", required = false) ArrayList<String> deleteIds) {
        if ( dataMap.containsKey("btn_type")){
        if (dataMap.get("btn_type").equals("delete")){
        dataMap.put("deleteIds", deleteIds);
        }else if (dataMap.get("btn_type").equals("insert")){
            BoardService.board_insert(dataMap);
            }
    }
        Object result = BoardService.selectSearchWithPaginationAndDeletes(dataMap);

        String viewPath = "/WEB-INF/views/boards/list_pagination.jsp";
        modelAndView.setViewName(viewPath);
        modelAndView.addObject("result", result);
        modelAndView.addObject("dataMap", dataMap);

        return modelAndView;
    }    
    @GetMapping("q/board/read")
    public ModelAndView readBoard(ModelAndView modelAndView
                    , @RequestParam HashMap<String, Object> dataMap) {
        if ( dataMap.containsKey("btn_type")){
            if (dataMap.get("btn_type").equals("UPDATE")){
                BoardService.board_update(dataMap); 
            }
        }
        Object result = BoardService.board_read(dataMap);
        String viewPath = "/WEB-INF/views/boards/reads.jsp";
        modelAndView.setViewName(viewPath);
        modelAndView.addObject("result", result);
        modelAndView.addObject("dataMap", dataMap);

        return modelAndView;
    }    
    @GetMapping("q/board/insert")
    public ModelAndView insertBoard(ModelAndView modelAndView
                    , @RequestParam HashMap<String, Object> dataMap) {
        Object result = BoardService.board_read(dataMap);

        String viewPath = "/WEB-INF/views/boards/inserts.jsp";
        modelAndView.setViewName(viewPath);
        modelAndView.addObject("result", result);
        modelAndView.addObject("dataMap", dataMap);

        return modelAndView;
    }    
    @GetMapping("q/board/update")
    public ModelAndView updateBoard(ModelAndView modelAndView
                    , @RequestParam HashMap<String, Object> dataMap) {
        Object result = BoardService.board_read(dataMap);

        String viewPath = "/WEB-INF/views/boards/update.jsp";
        modelAndView.setViewName(viewPath);
        modelAndView.addObject("result", result);
        modelAndView.addObject("dataMap", dataMap);

        return modelAndView;
                    }
}