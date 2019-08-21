package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping
 * Method 단독 매핑
*/

@Controller
public class BoardController {

	@ResponseBody
	@RequestMapping("/board/write")
	public String write(@RequestParam(value = "n", required = false, defaultValue = "1111") String name,
			@RequestParam(value = "a", required = false, defaultValue = "30") int age) {
		System.out.println("----" + name + "----");
		System.out.println("----" + age + "----");
		return "BoardController:write()";
	}

	@ResponseBody
	@RequestMapping("/board/view/{no}")
	public String view(@PathVariable(value = "no") long no) {
		return "BoardController:view(" + no + ")";
	}

	@ResponseBody
	@RequestMapping("/board/update")
	public String update(
//			String name,
//			@RequestParam String name,
			// 추천
			@RequestParam("name") String name) {
		System.out.println("----" + name + "----");
		return "BoardController:update()";
	}
}
