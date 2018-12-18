package cn.java.personal.utils;

import java.net.URLEncoder;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.alibaba.fastjson.JSONObject;
import com.miaodiyun.httpApiDemo.common.Config;
import com.miaodiyun.httpApiDemo.common.HttpUtil;

/**
*@author：zym
*@version：短信调用接口
*@time：2018年6月6日下午4:50:46
*/
public class SMSdo {
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;

	/*
	 * 产生验证码
	 */
	private static String verification() {
		String str="1234567890";
		Random rd=ThreadLocalRandom.current();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<6;i++) {
			int index=rd.nextInt(10);
			sb.append(str.charAt(index));
		}
		return sb.toString();
		
	}
	
	/**
	 * 产生短信内容
	 */
	private static String message(String verification,int time) {
		return "【阳光科技】您的验证码为"+verification+"，请于"+time+"分钟内正确输入，如非本人操作，请忽略此短信。";
	}
	/**
	 * 
	 * @param phone
	 * @return 验证码
	 */
	public static String execute(String phone,int time)
	{
		String verification=SMSdo.verification();
		String smsContent=SMSdo.message(verification,time);
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + phone + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	    if(!result.isEmpty()) {
	    	JSONObject js=JSONObject.parseObject(result);
		    String isOk=js.getString("respDesc");
		    if(isOk.equals("请求成功。"))
		    	return verification;
	    }
	    return "fail";//消息未成功发送
	}
	//{"respCode":"00000","respDesc":"请求成功。","failCount":"0","failList":[],"smsId":"d25f5f7ef17943848cc56f47951a64e6"}
	public static void main(String[] args){
		//System.out.println("验证码:");
		System.out.println("验证码:"+SMSdo.execute("15857354568",1));
    }
}
