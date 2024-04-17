package com.example.co_templates.quests.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.co_templates.daos.ShareDao;
import com.example.co_templates.utils.Commons;
import com.example.co_templates.utils.Paginations;

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
    public Object board_read(HashMap<String, Object> dataMap){
        String sqlMapId = "BoardCode.selectByUID";
        Object one = shareDao.getOne(sqlMapId, dataMap);
        return one;
    }
    public int board_insert(HashMap<String, Object> dataMap){
        String sqlMapId = "BoardCode.insert";
        String PK_BOARDS = commons.getUniqueSequence();
        dataMap.put("PK_BOARDS",PK_BOARDS);
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


    public Object list(Integer pageNumber, HashMap<String, String> dataMap){
        // ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
        String sqlMapId = "";
        if (dataMap.size() == 0) {
            sqlMapId = "BoardCode.selectBysearch";
        } else {
            sqlMapId = "BoardCode.selectByUID";
        }
        Object list = shareDao.getList(sqlMapId, dataMap);
        return list;
    }

    public Object selectMany(HashMap<String, Object> dataMap) {
        // 여러개 가져오기
        String sqlMapId = "BoardCode.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);
        return list;
    }

    public Object selectTotal(Map dataMap) {
        String sqlMapId = "BoardCode.selectTotal";

        Object result = shareDao.getOne(sqlMapId, dataMap);
        return result;
    }    

    public Map selectSearchWithPagination(Map dataMap) {
        // 페이지 형성 위한 계산
        int totalCount = (int) this.selectTotal(dataMap);
        
        int currentPage = 1;
        if(dataMap.get("currentPage") != null) {
            currentPage = Integer.parseInt((String)dataMap.get("currentPage"));    // from client in param
        }

        Paginations paginations = new Paginations(totalCount, currentPage);
        HashMap result = new HashMap<>();
        result.put("paginations", paginations); // 페이지에 대한 정보

        // page record 수
        String sqlMapId = "BoardCode.selectSearchWithPagination";
        dataMap.put("pageScale", paginations.getPageScale());
        dataMap.put("pageBegin", paginations.getPageBegin());
        
        result.put("resultList", shareDao.getList(sqlMapId, dataMap)); // 표현된 레코드 정보
        return result;
    }

    public Object deleteWithIn(Map dataMap){
        String sqlMapId = "BoardCode.deletewithin";
        Object count = shareDao.delete(sqlMapId, dataMap);
        return count;
    }

    public Map selectSearchWithPaginationAndDeletes(Map dataMap) {
        // delete
        if (dataMap.get("deleteIds") != null){
            Object count = this.deleteWithIn(dataMap);
        }

        // 페이지 형성 위한 계산
        int totalCount = (int) this.selectTotal(dataMap);
        
        int currentPage = 1;
        if(dataMap.get("currentPage") != null) {
            currentPage = Integer.parseInt((String)dataMap.get("currentPage"));    // from client in param
        }

        Paginations paginations = new Paginations(totalCount, currentPage);
        HashMap result = new HashMap<>();
        result.put("paginations", paginations); // 페이지에 대한 정보

        // page record 수
        String sqlMapId = "BoardCode.selectSearchWithPagination";
        dataMap.put("pageScale", paginations.getPageScale());
        dataMap.put("pageBegin", paginations.getPageBegin());
        
        result.put("resultList", shareDao.getList(sqlMapId, dataMap)); // 표현된 레코드 정보
        return result;
    }
}
