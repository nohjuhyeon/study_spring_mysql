package com.example.co_templates.quests.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.co_templates.daos.ShareDao;
import com.example.co_templates.utils.Commons;

@Service
public class QuestBoardService {

    @Autowired
    ShareDao shareDao;
    
    @Autowired
    Commons commons;

    public String sqlMapId = "BoardCode.selectBysearch";

    public Object board_list(HashMap<String, Object> dataMap){
        String sqlMapId = "BoardCode.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);
        return list;
    }
    public Object board_read(HashMap<String, Object> dataMap, String pk_board_id){
        String sqlMapId = "BoardCode.selectByUID";
        dataMap.put("PK_BOARDS", pk_board_id);
        Object one = shareDao.getOne(sqlMapId, dataMap);
        return one;
    }
    public int board_insert(HashMap<String, Object> dataMap, String pk_board_id, String pk_write_id){
        String sqlMapId = "BoardCode.insert";
        dataMap.put("PK_BOARDS",pk_board_id);
        dataMap.put("TITLE","test_title");
        dataMap.put("CONTENTS","test_content");
        dataMap.put("WRITER_ID",pk_write_id);
        dataMap.put("PARENT_BOARDS","test");
        Object insert = shareDao.insert(sqlMapId, dataMap);
        return dataMap.size();
    }

    public int board_delete(HashMap<String, Object> dataMap, String pk_board_id){
        String sqlMapId = "BoardCode.delete";
        dataMap.put("PK_BOARDS",pk_board_id);
        Object delete = shareDao.delete(sqlMapId, dataMap);
        return dataMap.size();
    }
    public int board_update(HashMap<String, Object> dataMap, String pk_board_id){
        String sqlMapId = "BoardCode.update";
        dataMap.put("CONTENTS","수정합니다.");
        dataMap.put("PK_BOARDS",pk_board_id);
        Object update = shareDao.update(sqlMapId, dataMap);
        return dataMap.size();
    }
}
