package com.ant.auto.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.ant.auto.aimetest.vo.TerminalResLocCntnVO;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sekift
 */
public class JsonUtil {

    /**
     * 获取json数据
     * @param jsonName json名称
     * @return
     */
    public static Map<String, List<JSONObject>> getJsonByName(String jsonName){
        Map<String, List<JSONObject>> map = new HashMap<>(4);
        try {
            String path = JsonUtil.class.getClassLoader().getResource("config/" + jsonName + ".json").getPath();
            String str = FileUtils.readFileToString(new File(path), Charset.defaultCharset());
            map = (Map<String, List<JSONObject>>)JSON.parse(str, Feature.OrderedField);
        }catch(Exception e){
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String, List<JSONObject>> json = JsonUtil.getJsonByName("adtest");
        System.out.println(json);
        for(List<JSONObject> list : json.values()){
            for(JSONObject object : list){
                TerminalResLocCntnVO vo = JSON.parseObject(object.toJSONString(), TerminalResLocCntnVO.class);;
            }
        }
    }

}
