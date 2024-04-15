package com.example.co_templates.restapis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.co_templates.services.BoardRestService;


@RestController
public class BoardRestController {

    @Autowired 
    BoardRestService BoardService;

    @GetMapping("/r/board/callBoardList")
    public void callBoardList(HashMap<String,Object> dataMap) {
        BoardService.list(dataMap);
        return;
    }

    @GetMapping("/r/board/callBoardInsert")
    public void callBoardInsert(HashMap dataMap) {
        BoardService.insert(dataMap);
        return;
    }

    @GetMapping("/r/board/callBoardUpdate")
    public void callBoardUpdate(HashMap dataMap) {
        BoardService.update(dataMap);
        return;
    }

    @GetMapping("/r/board/callBoardDelete")
    public void callBoardDelete(HashMap dataMap) {
        BoardService.delete(dataMap);
        return;
    }

    
}