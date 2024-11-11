package com.office.library.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// 오늘 배운 곳까지 활용해서 기말 프로젝트 14일에 제출
@Controller
@RequestMapping("/admin")
public class AdminHomecontroller {
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String home() {
		System.out.println("[AdminHomecontroller] home()");
		
		String nextPage = "admin/home";
		
		return nextPage;
	}
}
