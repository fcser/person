package cn.java.personal.contraller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.java.personal.pojo.Project;
import cn.java.personal.service.ProjectService;
import cn.java.personal.utils.JSONHelper;

/**
*@author：zym
*@version：
*@time：2018年6月26日下午11:26:40
*/
@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService=null;
	
	@RequestMapping("/registproject")
	public void registProject(String project,HttpServletResponse response) throws IOException {
		Project p=JSONObject.parseObject(project, Project.class);
		JSONObject json=new JSONObject();
		if(p.getUserId()==0) {
			JSONHelper.getFailJson(json, "未找到用户id，或许未登陆");
			JSONHelper.sendJSON(json, response);
			return;
		}
		int influence=projectService.insertProject(p);
		if(influence==0) {
			JSONHelper.getFailJson(json, "插入数据库失败");
		}else {
			JSONHelper.getSuccessJson(json, "操作成功！");
		}
		JSONHelper.sendJSON(json, response);
	}
}
