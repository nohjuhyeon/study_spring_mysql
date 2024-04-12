package com.example.co_templates.quests.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.co_templates.quests.services.QuestBoardService;
import com.example.co_templates.quests.services.QuestVisitorsService;
import com.example.co_templates.utils.Commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class QuestBoardController {
    @Autowired
    Commons commons;

    @Autowired QuestBoardService BoardService;
    @Autowired QuestVisitorsService QuestVisitorsService;

    @GetMapping("q/r/board/callDao")
    public ResponseEntity<Object> callDao(HashMap<String, Object> dataMap){
        String pk_board_id = commons.getUniqueSequence();
        String pk_write_id = commons.getUniqueSequence();
        String pk_user_id = commons.getUniqueSequence();
        String pk_visitor = commons.getUniqueSequence();
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("visitor_insert", QuestVisitorsService.visitors_insert(dataMap, pk_visitor, pk_user_id, pk_board_id));
        resultMap.put("board_insert", BoardService.board_insert(dataMap, pk_board_id, pk_write_id));
        resultMap.put("visitor_list", QuestVisitorsService.visitors_list(dataMap));
        resultMap.put("board_list", BoardService.board_list(dataMap));
        resultMap.put("visitor_read", QuestVisitorsService.visitors_read(dataMap, pk_visitor));
        resultMap.put("board_read", BoardService.board_read(dataMap, pk_board_id));
        resultMap.put("visitor_update", QuestVisitorsService.visitors_update(dataMap, pk_board_id));
        resultMap.put("board_update", BoardService.board_update(dataMap, pk_board_id));
        resultMap.put("visitor_delete", QuestVisitorsService.visitors_delete(dataMap, pk_board_id));
        resultMap.put("board_delete", BoardService.board_delete(dataMap, pk_board_id));
        return ResponseEntity.ok().body(resultMap);
    }
}
