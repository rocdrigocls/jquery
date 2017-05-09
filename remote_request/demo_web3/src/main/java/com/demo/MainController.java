package com.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private TreeMap<String, PersonBean> mapPersonBean;
	
	@PostConstruct
	public void init(){
		mapPersonBean = new TreeMap<>();
		
		PersonBean person1 = new PersonBean();
		
		person1.setId("1");
		person1.setName("Rocdrigo");
		person1.setEdad(38);
		List<String> listPhones = new LinkedList<>();
		listPhones.add("3314665014");
		person1.setListTelefonos(listPhones);	
	
		PersonBean person2 = new PersonBean();
		person2.setId("2");
		person2.setName("John");
		person2.setEdad(32);
		listPhones = new LinkedList<>();
		listPhones.add("65873465");
		person2.setListTelefonos(listPhones);
		
		mapPersonBean.put(person1.getId(), person1);
		mapPersonBean.put(person2.getId(), person2);
	}
	
	@RequestMapping("/methodWithoutCORS")
	@ResponseBody
	public PersonBean methodWithoutCORS(String id){
		PersonBean p = mapPersonBean.get(id);
		logger.info("id=>" + id + ", " + p + "");
		return p;
	}
	
	@CrossOrigin(origins="http://localhost:81")
	@RequestMapping("/methodWithCORS")
	@ResponseBody
	public PersonBean methodWithCORS(String id){
		PersonBean p = mapPersonBean.get(id);
		logger.info("id=>" + id + ", " + p + "");
		return p;
	}
	
}
