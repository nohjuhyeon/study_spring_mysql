package com.example.co_templates.quests.restapi;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Service;;

@Service
public class BoardService {
    public ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();

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
