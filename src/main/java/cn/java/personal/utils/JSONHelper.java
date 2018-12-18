package cn.java.personal.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.*;
/**
 * 用于json发送
 * @author zym
 *
 */
public class JSONHelper {

	public static void sendJSONBoolean(boolean b, HttpServletResponse response) throws IOException {
		sendJSON(Boolean.toString(b), response);
	}

	public static void sendJSON(JSONObject json, HttpServletResponse response) throws IOException {
		sendJSON(json.toJSONString(), response);
	}
	public static void sendJSONArray(JSONArray json, HttpServletResponse response) throws IOException {
		sendJSON(json.toJSONString(), response);
	}

	public static void sendJSON(String json, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	public static void getSuccessJson(JSONObject json,String message) {
		json.put("key", "success");
		json.put("message", message);
	}
	public static void getFailJson(JSONObject json,String message) {
		//JSONObject json=new JSONObject();
		json.put("key", "error");
		json.put("message", message);
		//return json;
	}
	
	//public static JSONObject changeToJson()
}
