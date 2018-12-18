package cn.java.personal.contraller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.java.personal.pojo.Skill;
import cn.java.personal.service.SkillService;
import cn.java.personal.utils.JSONHelper;

/**
*@author：zym
*@version：
*@time：2018年6月26日下午9:34:53
*/
@Controller
public class SkillController {

	@Autowired
	private SkillService skillService=null;
	@RequestMapping("/registskill")
	public void registSkill(String skill,HttpServletResponse response) throws IOException {
		System.out.println(skill);
		Skill sk=JSONObject.parseObject(skill,Skill.class);	
		JSONObject json=new JSONObject();
		if(sk.getUserId()==0) {
			JSONHelper.getFailJson(json, "未找到用户id，或许未登陆");
			JSONHelper.sendJSON(json, response);
			return;
		}
		int influence=skillService.insertSkill(sk);
		if(influence==0) {
			JSONHelper.getFailJson(json, "插入数据库失败");
		}else {
			JSONHelper.getSuccessJson(json, "操作成功！");
		}
		JSONHelper.sendJSON(json, response);
	}
}
