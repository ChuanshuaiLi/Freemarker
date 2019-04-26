package com.imooc.freemarker;
/**
 * 测试迭代
 */
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.imooc.freemarker.entity.Computer;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class FreemarkerSample2 {

	public static void main(String[] args) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		//1. 加载模板
		//创建核心配置对象
		Configuration config = new Configuration(Configuration.VERSION_2_3_28);
		//设置加载的目录
		config.setClassForTemplateLoading(FreemarkerSample2.class, "");
		//得到模板对象
		Template t = config.getTemplate("sample2.ftl");
		//2. 创建数据
		Map<String,Object> data = new HashMap<String,Object>();
		List<Computer> computers = new ArrayList();
		computers.add(new Computer("1234567" , "ThinkPad X1" , 2 , null , new Date() , 12999f , new HashMap() ));
		computers.add(new Computer("1234568" , "HP XXX" , 1 , "张三" , new Date() , 7500f , new HashMap() ));
		computers.add(new Computer("1234569" , "DELL XXX" , 3 , "李四" , new Date() , 8500f , new HashMap() ));
		computers.add(new Computer("1234570" , "ACER XXX" , 1 , "王五" , new Date() , 6300f , new HashMap() ));
		computers.add(new Computer("1234571" , "MSI XXX" , 1 , "赵六" , new Date() , 9300f , new HashMap() ));	
		data.put("computers",  computers);
		//LinkedHashMap可以保证数据按存放顺序进行提取
		Map computerMap = new LinkedHashMap();
		for(Computer c : computers) {
			computerMap.put(c.getSn(), c);
		}
		data.put("computer_map", computerMap);
		//3. 产生输出
		t.process(data, new OutputStreamWriter(System.out));
	}
}
