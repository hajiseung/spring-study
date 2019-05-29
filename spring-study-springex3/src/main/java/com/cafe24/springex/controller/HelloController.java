package com.cafe24.springex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
//		return "/WEB-INF/views/hello.jsp";
		return "hello";
	}

	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("email", "hajiseung@email");
		mav.setViewName("/WEB-INF/views/hello.jsp");

		return mav;
	}

	@RequestMapping("/hello3")
	public String hello3(Model model) {
		model.addAttribute("email", "gkwltmd@email");

		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello4")
	public String hello4(Model model, @RequestParam("a") String email,
			@RequestParam String name/* 어노테이션에 value 생략시 변수이름으로 값을 찾는다. */) {
		model.addAttribute("email", email);
		model.addAttribute("name", name);

		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello5")
	public String hello4(Model model, HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "/WEB-INF/views/hello.jsp";
	}
}
