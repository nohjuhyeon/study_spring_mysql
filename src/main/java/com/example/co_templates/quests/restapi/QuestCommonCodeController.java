package com.example.co_templates.quests.restapi;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class QuestCommonCodeController {
    // /helloWorldResponseList/1/10/1
    @GetMapping("/q/r/list/{currentPage}")
    public ResponseEntity<Object> list(@PathVariable String currentPage) {
    // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null
    // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3
    ArrayList arrayList = new ArrayList<>();
    HashMap resultMap = new HashMap<>();
    resultMap.put("PK_ID", "PK_ID_01");
    resultMap.put("FK_ID", "FK_ID_01");
    resultMap.put("NAME", "노주현");
    arrayList.add(resultMap);
    
    return ResponseEntity.ok().body(arrayList);
    }

    @GetMapping("/q/r/view/{PK_ID}/{FK_ID}/{NAME}")
    public ResponseEntity<Object> view(@PathVariable String PK_ID, @PathVariable String FK_ID, @PathVariable String NAME) {

    HashMap resultMap = new HashMap<>();
    resultMap.put("PK_ID", "PK_ID_02");
    resultMap.put("FK_ID", "FK_ID_02");
    resultMap.put("NAME", "JuHyeon");

    return ResponseEntity.ok().body(resultMap);
    }
}