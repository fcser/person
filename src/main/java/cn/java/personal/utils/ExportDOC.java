package cn.java.personal.utils;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.io.Writer;  
import java.util.HashMap;  
import java.util.Map;  
  
import freemarker.template.Configuration;  
import freemarker.template.Template;  
/**
*@author：zym
*@version：
*@time：2018年6月8日上午1:02:44
*/
public class ExportDOC {
	 private static Configuration configuration = null;  
	    private static Map<String, Template> allTemplates = null;  
	      
	    static {  
	        configuration = new Configuration();  
	        configuration.setDefaultEncoding("utf-8");  
	        configuration.setClassForTemplateLoading(ExportDOC.class, "/com/lovo/ftl");  
	        allTemplates = new HashMap<>();   // Java 7 钻石语法  
	        try {  
	            allTemplates.put("resume", configuration.getTemplate("resume.ftl"));  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	            throw new RuntimeException(e);  
	        }  
	    }  
	  
	    private ExportDOC() {  
	        throw new AssertionError();  
	    }  
	  
	    public static File createDoc(Map<?, ?> dataMap, String type) {  
	        String name = "temp" + (int) (Math.random() * 100000) + ".doc";  
	        File f = new File(name);  
	        Template t = allTemplates.get(type);  
	        try {  
	            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开  
	            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");  
	            t.process(dataMap, w);  
	            w.close();  
	        } catch (Exception ex) {  
	            ex.printStackTrace();  
	            throw new RuntimeException(ex);  
	        }  
	        return f;  
	    }  
	  
}
