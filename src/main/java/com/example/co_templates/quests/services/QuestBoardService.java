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
    public int board_insert(HashMap<String, Object> dataMap){
        String sqlMapId = "BoardCode.insert";
        Object insert = shareDao.insert(sqlMapId, dataMap);
        return dataMap.size();
    }

    public int board_delete(HashMap<String, Object> dataMap){
        String sqlMapId = "BoardCode.delete";
        Object delete = shareDao.delete(sqlMapId, dataMap);
        return dataMap.size();
    }
    public int board_update(HashMap<String, Object> dataMap){
        String sqlMapId = "BoardCode.update";
        Object update = shareDao.update(sqlMapId, dataMap);
        return dataMap.size();
    }
    public Object list(Integer pageNumber, HashMap<String, Object> dataMap){
        // ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();

        String sqlMapId = "BoardCode.selectByUID";
        Object list = shareDao.getList(sqlMapId, dataMap);
        return list;

    }
}
