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
    public int visitors_insert(HashMap<String, Object> dataMap){
        String sqlMapId = "VisitorCode.insert";
        Object insert = shareDao.insert(sqlMapId, dataMap);
        return dataMap.size();
    }

    public int visitors_delete(HashMap<String, Object> dataMap){
        String sqlMapId = "VisitorCode.delete";
        Object delete = shareDao.delete(sqlMapId, dataMap);
        return dataMap.size();
    }
    public int visitors_update(HashMap<String, Object> dataMap){
        String sqlMapId = "VisitorCode.update";
        Object update = shareDao.update(sqlMapId, dataMap);
        return dataMap.size();
    }
}