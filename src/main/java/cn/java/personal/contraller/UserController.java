package cn.java.personal.contraller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSONObject;

import cn.java.personal.pojo.User;
import cn.java.personal.service.UserService;
import cn.java.personal.utils.JSONHelper;
import cn.java.personal.utils.PicPath;
import cn.java.personal.utils.SMSdo;

/**
*@author：zym
*@version：
*@time：2018年6月12日下午1:40:52
*/
@Controller
public class UserController {

	@Autowired
	private UserService userService=null;
	/**
	 * 检查手机号是否存在
	 * @param phone
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/checkPhone")
	public void checkPhone(String phone,HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		//PrintWriter out=response.getWriter();
		System.out.println("phone="+phone);
		User user=userService.queryUser(phone);
		System.out.println(user);
		JSONObject js=new JSONObject();
		if(user==null) {
			//String msg=SMSdo.execute(phone, 60);
			String msg="123456";
			if(msg.equals("fail")) {
				js.put("key", "error");
				js.put("message", "网络请求繁忙");
				js.put("verification","");
			}else {
				js.put("key", "success");
				js.put("message", "短信已经发送");
				js.put("verification", msg);
			}
		}else {
			js.put("key", "error");
			js.put("message", "该手机号已被注册，请重新输入");
			js.put("verification","");
		}
		JSONHelper.sendJSON(js, response);
	}
	/**
	 * 用户注册
	 * @param user
	 * @param request
	 * @param response
	 * json返回：注册后用户id
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/registuser",method=RequestMethod.POST)
	public void registUser(String user,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		System.out.println("注册用户操作");
		User people = JSONObject.parseObject(user, User.class);
		String savePath = PicPath.savePath(request);
		System.out.println("SAVEPATH:"+savePath);
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		JSONObject json=new JSONObject();
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator<String> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String picName=PicPath.picName(file);
					String path = savePath + "\\" +picName;
					System.out.println(path);
					// 上传
					file.transferTo(new File(path));
					String picUrlPath=PicPath.getPath(path);//图片url路径
					System.out.println(picUrlPath);
					people.setPicture(picUrlPath);	
				}
				System.out.println(people.getPicture());
				int influence=userService.insertUser(people);
				//int influence=1;
				//people.setId(5);
				if(influence==0) {
					JSONHelper.getFailJson(json, "数据未成功插入数据库！");
					json.put("id", "");
				}else {
					JSONHelper.getSuccessJson(json, "注册成功");
					json.put("id", people.getId());
				}
			}
		}else {
			json.put("key", "error");
			json.put("message", "前台数据格式错误！");
			json.put("id", "");
		}
		JSONHelper.sendJSON(json, response);
	}
	@RequestMapping("/queryuser")
	public void queryUser(int id,HttpServletResponse response) throws IOException {
		System.out.println("用户基本信息查询");
		JSONObject json=new JSONObject();
		User user=userService.queryUserbyId(id);
		if(user.getPhone()==null)
		{
			JSONHelper.getFailJson(json, "该用户不存在");
		}else {
			JSONObject js=new JSONObject();
			js.put("id",user.getId());
			js.put("education",user.getEducation());
			js.put("name", user.getName());
			js.put("introduce", user.getIntroduce());
			js.put("mail", user.getMail());
			js.put("nation", user.getNation());
			js.put("phone", user.getPhone());
			js.put("sex", user.getSex());
			js.put("picture", user.getPicture());
			JSONHelper.getSuccessJson(json, "用户信息查询成功");
			json.put("user", js.toString());
		}
		JSONHelper.sendJSON(json, response);
	}
	@RequestMapping("/updateuser")
	public void updateUser(String user,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		System.out.println("注册用户操作");
		User people = JSONObject.parseObject(user, User.class);
		String savePath = PicPath.savePath(request);
		System.out.println("SAVEPATH:"+savePath);
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		JSONObject json=new JSONObject();
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator<String> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String picName=PicPath.picName(file);
					String path = savePath + "\\" +picName;
					System.out.println(path);
					// 上传
					file.transferTo(new File(path));
					String picUrlPath=PicPath.getPath(path);//图片url路径
					System.out.println(picUrlPath);
					people.setPicture(picUrlPath);	
				}
				System.out.println(people.getPicture());
				int influence=userService.updateUser(people);
				if(influence==0) {
					JSONHelper.getFailJson(json, "用户信息修改失败");
					json.put("id", "");
				}else {
					JSONHelper.getSuccessJson(json, "修改成功");
					json.put("id", people.getId());
				}
			}
		}else {
			json.put("key", "error");
			json.put("message", "前台数据格式错误！");
			json.put("id", "");
		}
		JSONHelper.sendJSON(json, response);
	}
	
}
