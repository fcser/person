package cn.java.personal.contraller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.java.personal.pojo.Award;
import cn.java.personal.service.AwardService;
import cn.java.personal.utils.JSONHelper;

/**
*@author：zym
*@version：
*@time：2018年6月26日下午11:25:18
*/
@Controller
public class AwardController {
	@Autowired
	private AwardService awardService=null;
	
	@RequestMapping("/registaward")
	public void registAward(String award,HttpServletResponse response) throws IOException {
		System.out.println("注册奖项");
		Award awards=JSONObject.parseObject(award,Award.class);
		JSONObject json=new JSONObject();
		if(awards.getUserId()==0) {
			JSONHelper.getFailJson(json, "未找到用户id，或许未登陆");
			JSONHelper.sendJSON(json, response);
			return;
		}
		int influence=awardService.insertAward(awards);
		if(influence==0) {
			JSONHelper.getFailJson(json, "插入数据库失败");
		}else {
			JSONHelper.getSuccessJson(json, "操作成功！");
		}
		JSONHelper.sendJSON(json, response);
	}

}
