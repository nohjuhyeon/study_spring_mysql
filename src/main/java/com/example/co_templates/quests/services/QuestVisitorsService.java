package com.example.co_templates.quests.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.co_templates.daos.ShareDao;
import com.example.co_templates.utils.Commons;

@Service
public class QuestVisitorsService {

    @Autowired
    ShareDao shareDao;
    
    public Object visitors_list(HashMap<String, Object> dataMap){
        String sqlMapId = "VisitorCode.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);
        return list;
    }
    public Object visitors_read(HashMap<String, Object> dataMap, String pk_visitor){
        String sqlMapId = "VisitorCode.selectByUID";
        dataMap.put("PK_VISITORS", pk_visitor);
        Object one = shareDao.getOne(sqlMapId, dataMap);
        return one;
    }
    public int visitors_insert(HashMap<String, Object> dataMap, String pk_visitor, String pk_user_id, String pk_board_id){
        String sqlMapId = "VisitorCode.insert";
        dataMap.put("PK_VISITORS",pk_visitor);
        dataMap.put("WRITER_ID",pk_user_id);
        dataMap.put("PK_BOARDS",pk_board_id);
        Object insert = shareDao.insert(sqlMapId, dataMap);
        return dataMap.size();
    }

    public int visitors_delete(HashMap<String, Object> dataMap, String pk_board_id){
        String sqlMapId = "VisitorCode.delete";
        dataMap.put("PK_BOARDS",pk_board_id);
        Object delete = shareDao.delete(sqlMapId, dataMap);
        return dataMap.size();
    }
    public int visitors_update(HashMap<String, Object> dataMap, String pk_board_id){
        String sqlMapId = "VisitorCode.update";
        dataMap.put("WRITER_ID","user12");
        dataMap.put("PK_BOARDS",pk_board_id);
        Object update = shareDao.update(sqlMapId, dataMap);
        return dataMap.size();
    }
}