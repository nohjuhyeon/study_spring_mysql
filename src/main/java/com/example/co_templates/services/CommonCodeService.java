package com.example.co_templates.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.co_templates.daos.ShareDao;
import com.example.co_templates.utils.Commons;

@Service
public class CommonCodeService {
    @Autowired
    ShareDao shareDao;

    @Autowired
    Commons commons;
    public void callDao(HashMap<String, Object> dataMap){
        // 여러개 가져오기 
        String sqlMapId = "CommonCode.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);
        
        sqlMapId = "CommonCode.selectByUID";
        dataMap.put("PK_UNIQUE", "CC002");
        Object one = shareDao.getOne(sqlMapId, dataMap);
        
        sqlMapId = "CommonCode.insert";
		// INSERT INTO `COMMON_CODE` 
		// (`PK_UNIQUE`, `CODE_NAME`, `DESCRIPTION`, `PARENT_UNIQUE`) 
		// VALUES ('CC017', 'test_insert', 'test insert', '');
        String pk_unique_id = commons.getUniqueSequence();
        dataMap.put("PK_UNIQUE",pk_unique_id);
        dataMap.put("CODE_NAME","test_insert");
        dataMap.put("DESCRIPTION","test insert");
        dataMap.put("PARENT_UNIQUE","");
        Object insert = shareDao.insert(sqlMapId, dataMap);

        sqlMapId = "CommonCode.update";
        dataMap.put("PK_UNIQUE",pk_unique_id);
        dataMap.put("CODE_NAME","test_ROOT");
        Object update = shareDao.update(sqlMapId, dataMap);

        sqlMapId = "CommonCode.delete";
        dataMap.put("PK_UNIQUE",pk_unique_id);
        Object delete = shareDao.delete(sqlMapId, dataMap);

        return;
    }

    public HashMap<String, Object> mixed(Integer pageNumber, Integer pkid){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", this.list(pageNumber));
        resultMap.put("view", this.view(pkid));
        return resultMap;
    }

    public ArrayList<HashMap<String, Object>> list(Integer pageNumber){
        ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
 
        HashMap<String, Object> item = new HashMap<>();
        item.put("PK_ID", 1);
        item.put("FK_ID", 10);
        item.put("NAME", "Excalibur");
        itemList.add(item);
    
        item = new HashMap<>();
        item.put("PK_ID", 2);
        item.put("FK_ID", 20);
        item.put("NAME", "Dragon Sword");
        itemList.add(item);

        return itemList;
    }

    public HashMap<String, Object> view(Integer pkId){
        HashMap<String, Object> itemDetails = new HashMap<>();

        String fkId = "FK_0382";
        String name = "Commons";
        itemDetails.put("PK_ID", pkId);
        itemDetails.put("FK_ID", fkId);
        itemDetails.put("NAME", name);

        return itemDetails;
    }
}
