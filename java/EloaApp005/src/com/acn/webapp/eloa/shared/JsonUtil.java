package com.acn.webapp.eloa.shared;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class JsonUtil {

	public static String toJson(Map<String, String> map) {
	    String json = "";
	    if (map != null && !map.isEmpty()) {
	        JSONObject jsonObj = new JSONObject();
	        for (Map.Entry<String, String> entry: map.entrySet()) {
	            jsonObj.put(entry.getKey(), new JSONString(entry.getValue()));
	        }
	        json = jsonObj.toString();
	    }
	    return json;
	}

	public static Map<String, String> toMap(String jsonStr) {
	    Map<String, String> map = new HashMap<String, String>();

	    JSONValue parsed = JSONParser.parseStrict(jsonStr);
	    JSONObject jsonObj = parsed.isObject();
	    if (jsonObj != null) {
	        for (String key : jsonObj.keySet()) {
	            map.put(key, jsonObj.get(key).toString());
	        }
	    }

	    return map;
	}
	public static Map<String, Object> toMapOfStringObject(String jsonStr) {
	    Map<String, Object> map = new HashMap<String, Object>();

	    JSONValue parsed = JSONParser.parseStrict(jsonStr);
	    JSONObject jsonObj = parsed.isObject();
	    if (jsonObj != null) {
	        for (String key : jsonObj.keySet()) {
	            map.put(key, (Object)jsonObj.get(key).toString());
	        }
	    }

	    return map;
	}
	public static String toJsonFromMapOfObject(Map<String, Object> map) {
	    String json = "";
	    if (map != null && !map.isEmpty()) {
	        JSONObject jsonObj = new JSONObject();
	        for (Map.Entry<String, Object> entry: map.entrySet()) {
	            jsonObj.put(entry.getKey(), new JSONString((String)entry.getValue()));
	        }
	        json = jsonObj.toString();
	    }
	    return json;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<String, String> mpData = new HashMap<String, String>();
		mpData.put("n1", "v1");
		mpData.put("n2", "v2");
		mpData.put("n3", "v3");
		
		String strObj = JsonUtil.toJson(mpData);
		Map mpData2 = JsonUtil.toMap(strObj);
		
		System.out.println("strObj:" + strObj);
		System.out.println("mpData2" + mpData2.toString());
	}

}
