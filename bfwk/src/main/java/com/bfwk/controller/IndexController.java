package com.bfwk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class IndexController {
	@RequestMapping("/to{module}")
	public String toModule(@PathVariable String module) {
		return module;
	}
}
