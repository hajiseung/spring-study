package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping
 * type + method
*/

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/join", method = RequestMethod.GET)
//	@GetMapping("/join") 완전 동일
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value = { "/join", "/j" }, method = RequestMethod.POST)
//	@PostMapping({ "/join", "/j" }) 완전 동일
	public String join(@ModelAttribute UserVo vo) {
		System.out.println(vo);
		if(valid(vo)==false) {
			return "/WEB-INF/views/join.jsp";
		}
		return "redirect:/hello";
	}

	private boolean valid(UserVo userVo) {
		return true;
	}
}
