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
public class QuestVisitorController {

    @Autowired
    Commons commons;

    @Autowired QuestVisitorsService QuestVisitorsService;

    @GetMapping({"/q/r/visitor/List/{pageNumber}", "/q/r/visitor/List"})
    public ResponseEntity<Object> callBoardList(@PathVariable(required = false) String pageNumber
            ,@RequestBody HashMap<String,Object> dataMap) {
        Object list = QuestVisitorsService.visitors_list(dataMap);
        return ResponseEntity.ok().body(list);
    }
    // URL : http://localhost:8080/q/r/visitor/List

    @GetMapping("/q/r/visitor/Insert")
    public int callBoardInsert(@RequestBody HashMap<String, Object> dataMap) {
        int InsertNum = QuestVisitorsService.visitors_insert(dataMap);
        return InsertNum;
    }
    // URL : http://localhost:8080/q/r/visitor/Insert
    //Body :  {"PK_VISITORS" : "visitor-111", "WRITER_ID" : "user-11", "PK_BOARDS" : news-011)}

    @GetMapping("/q/r/visitor/Update")
    public int callBoardUpdate(@RequestBody HashMap<String, Object>  dataMap) {
        int updateNum = QuestVisitorsService.visitors_update(dataMap);
        return updateNum;
    }
    // URL : http://localhost:8080/q/r/visitor/Update
    // Body : {"WRITER_ID" : "user12", "PK_BOARDS": "news-011"}

    @GetMapping("/q/r/visitor/Delete")
    public int callBoardDelete(@RequestBody HashMap<String, Object>  dataMap) {
        int deleteNum = QuestVisitorsService.visitors_delete(dataMap);
        return deleteNum;
    }
    // URL : http://localhost:8080/q/r/visitor/Delete
    // Body : {"PK_BOARDS" : "news-011"}
}
