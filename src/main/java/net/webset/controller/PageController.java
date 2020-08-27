package net.webset.controller;

import net.webset.config.SecurityConstants;
import net.webset.entity.*;
import net.webset.service.IMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("")
public class PageController {

	@Autowired
	private HttpSession session;

	@Autowired
	private IMenuService menuService;

	@GetMapping(value = {"/","/index"})
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("index/login.html");
		return mav;
	}

}