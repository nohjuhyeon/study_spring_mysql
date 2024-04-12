package com.example.co_templates.quests.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.co_templates.daos.ShareDao;
import com.example.co_templates.utils.Commons;

@Service
public class BoardService {

    @Autowired
    ShareDao shareDao;
    
    @Autowired
    Commons commons;

    public ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
    // public String pk_board_id = commons.getUniqueSequence();
    // public String pk_write_id = commons.getUniqueSequence();
    public String pk_board_id = "news-011";
    public String pk_write_id = "author-6";
    public String pk_user_id = "user11";
    public String pk_visitor = "visitor-111";
    public String sqlMapId = "BoardCode.selectBysearch";

    public HashMap<String, Object> dao_mixed(HashMap<String, Object> dataMap){

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("visitor_insert", this.visitors_insert(dataMap));
        resultMap.put("board_insert", this.board_insert(dataMap));
        resultMap.put("visitor_list", this.visitors_list(dataMap));
        resultMap.put("board_list", this.board_list(dataMap));
        resultMap.put("visitor_read", this.visitors_read(dataMap));
        resultMap.put("board_read", this.board_read(dataMap));
        resultMap.put("visitor_update", this.visitors_update(dataMap));
        resultMap.put("board_update", this.board_update(dataMap));
        resultMap.put("visitor_delete", this.visitors_delete(dataMap));
        resultMap.put("board_delete", this.board_delete(dataMap));
        return resultMap;
    }
    public Object board_list(HashMap<String, Object> dataMap){
        String sqlMapId = "BoardCode.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);
        return list;
    }
    public Object board_read(HashMap<String, Object> dataMap){
        String sqlMapId = "BoardCode.selectByUID";
        dataMap.put("PK_BOARDS", this.pk_board_id);
        Object one = shareDao.getOne(sqlMapId, dataMap);
        return one;
    }
    public int board_insert(HashMap<String, Object> dataMap){
        String sqlMapId = "BoardCode.insert";
        dataMap.put("PK_BOARDS",this.pk_board_id);
        dataMap.put("TITLE","test_title");
        dataMap.put("CONTENTS","test_content");
        dataMap.put("WRITER_ID",this.pk_write_id);
        dataMap.put("PARENT_BOARDS","test");
        Object insert = shareDao.insert(sqlMapId, dataMap);
        return dataMap.size();
    }

    public int board_delete(HashMap<String, Object> dataMap){
        String sqlMapId = "BoardCode.delete";
        dataMap.put("PK_BOARDS",this.pk_board_id);
        Object delete = shareDao.delete(sqlMapId, dataMap);
        return dataMap.size();
    }
    public int board_update(HashMap<String, Object> dataMap){
        String sqlMapId = "BoardCode.update";
        dataMap.put("CONTENTS","수정합니다.");
        dataMap.put("PK_BOARDS",this.pk_board_id);
        Object update = shareDao.update(sqlMapId, dataMap);
        return dataMap.size();
    }
    public Object visitors_list(HashMap<String, Object> dataMap){
        String sqlMapId = "VisitorCode.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);
        return list;
    }
    public Object visitors_read(HashMap<String, Object> dataMap){
        String sqlMapId = "VisitorCode.selectByUID";
        dataMap.put("PK_VISITORS", this.pk_visitor);
        Object one = shareDao.getOne(sqlMapId, dataMap);
        return one;
    }
    public int visitors_insert(HashMap<String, Object> dataMap){
        String sqlMapId = "VisitorCode.insert";
        dataMap.put("PK_VISITORS",this.pk_visitor);
        dataMap.put("WRITER_ID",this.pk_user_id);
        dataMap.put("PK_BOARDS",this.pk_board_id);
        Object insert = shareDao.insert(sqlMapId, dataMap);
        return dataMap.size();
    }

    public int visitors_delete(HashMap<String, Object> dataMap){
        String sqlMapId = "VisitorCode.delete";
        dataMap.put("PK_BOARDS",this.pk_board_id);
        Object delete = shareDao.delete(sqlMapId, dataMap);
        return dataMap.size();
    }
    public int visitors_update(HashMap<String, Object> dataMap){
        String sqlMapId = "VisitorCode.update";
        dataMap.put("WRITER_ID","user12");
        dataMap.put("PK_BOARDS",this.pk_board_id);
        Object update = shareDao.update(sqlMapId, dataMap);
        return dataMap.size();
    }
    public HashMap<String, Object> mixed(String pageNumber, String pkid){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", this.list(pageNumber));
        resultMap.put("view", this.view(pkid));
        resultMap.put("delete", this.delete(pkid));
        return resultMap;
    }
    public ArrayList<HashMap<String, Object>> insert(String title, String contents) { 
        HashMap<String, Object> item = new HashMap<>();
        int number = this.itemList.size()+1;
        String pk_id = "PK_ID_"+ number;
        item.put("PK_ID", pk_id);
        item.put("TITLE", title);
        item.put("CONTENTS", contents);
        this.itemList.add(item);

        return this.itemList;
    }
    public ArrayList<HashMap<String, Object>> list(String pageNumber){
        return this.itemList;
    }
    public HashMap<String, Object> view(String pk_id){
        HashMap<String,Object> itemDetails = new HashMap<>();
        for (int i = 0; i < this.itemList.size();i++){
            if (this.itemList.get(i).get("PK_ID").equals(pk_id)){
            itemDetails = this.itemList.get(i);
        }
    }
        
        return itemDetails;
    }
    public Integer delete(String pk_id){
        int delete_num = 0;
        for (int i = 0; i < this.itemList.size();i++){
            if (this.itemList.get(i).get("PK_ID").equals(pk_id)){
                this.itemList.remove(i);
                delete_num = delete_num + 1;
        }
    }
        return delete_num;
    }
}
