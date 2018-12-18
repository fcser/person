package cn.java.personal.utils;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
*@author：zym
*@version：照片的保存路径和访问路径
*@time：2018年6月6日上午12:19:22
*/
public class PicPath {

	/**
	 * 
	 * @param s
	 * @return 图片的保存路径
	 */
	public static String savePath(ServletRequest s) {
		String path=s.getServletContext().getRealPath("/picture");
		File f=new File(path);
		if(f.exists()||!f.isDirectory()) {
			f.mkdir();
		}
		return path;
	}
	/**
	 * 
	 * @param file
	 * @return 图片名称
	 */
		public static String picName(MultipartFile file){
			//获取随机数
			String str="zxcvbnmasdfghjklqwertyuiopQWERTYUIOPLKJHGFDSAZXCVBNM1236987450";
			Random random=new Random();
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<2;i++) {
				int number=random.nextInt(62);
				sb.append(str.charAt(number));
			}
			//获取系统时间
			Date d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		    String time=sdf.format(d);
		    //获取图片后缀
		    String path=file.getOriginalFilename();
		    //System.out.println(path);
		    System.out.println(file.getName());
		    String end=path.substring(path.indexOf("."), path.length());
		    return sb.toString()+time+end;
		}
	/**
	 * 
	 * @param pic
	 * @return 返回图片url
	 * @throws UnknownHostException
	 */
	public static String getPath(String pic) throws UnknownHostException {
		String ip = InetAddress.getLocalHost().getHostAddress();
		//System.out.println("本地ip是：" + ip);
	    //String picture="http://"+ip+":8080/personal/picture/"+pic.substring(pic.lastIndexOf("\\")+1);
		String picture="picture/"+pic.substring(pic.lastIndexOf("\\")+1);
	    return picture;
	}
}
