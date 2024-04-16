package com.example.co_templates.quests.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
public class QuestBoardRestController {

    @Autowired
    Commons commons;

    @Autowired QuestBoardService BoardService;
    @Autowired QuestVisitorsService QuestVisitorsService;

    public String pk_board_id = "news-011";
    public String pk_write_id = "author-6";

    @GetMapping({"/q/r/board/List/{pageNumber}", "/q/r/board/List"})
    public ResponseEntity<Object> callBoardList(@PathVariable(required = false) String pageNumber
            ,@RequestBody HashMap<String,Object> dataMap) {
        Object list =BoardService.board_list(dataMap);

        return ResponseEntity.ok().body(list);
    }
    // http://localhost:8080/q/r/board/List

    @GetMapping("/q/r/board/Insert")
    public int callBoardInsert(@RequestBody HashMap<String, Object> dataMap) {
        int InsertNum = BoardService.board_insert(dataMap);
        return InsertNum;
    }
    // URL : http://localhost:8080/q/r/board/Insert
    // Body : {"PK_BOARDS" : "news-011", "PK_VISITORS": "author-6", "TITLE" : "test_title", "CONTENTS" : "test_content", "PARENT_BOARDS" : "test"}

    @GetMapping("/q/r/board/Update")
    public int callBoardUpdate(@RequestBody HashMap<String, Object>  dataMap) {
        int updateNum = BoardService.board_update(dataMap);
        return updateNum;
    }
    // http://localhost:8080/q/r/board/Delete
    // Body : {"CONTENTS" : "수정합니다.","PK_BOARDS":  "news-011"}
    @GetMapping("/q/r/board/Delete")
    public int callBoardDelete(@RequestBody HashMap<String, Object>  dataMap) {
        int deleteNum = BoardService.board_delete(dataMap);
        return deleteNum;
    }
    // http://localhost:8080/q/r/board/Delete
    // Body : {"PK_BOARDS" : "news-011"}
}
