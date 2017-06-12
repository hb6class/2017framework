package com.hb.day03.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
 * 레스트풀
 * **********************************
 * 목록		/list		get
 * 상세		/guest/{1}	get
 * 입력폼	/guest		get
 * 입력		/guest		post
 * 수정		/guest/{1}	put
 * 삭제		/guest/{1}	delete
 * **********************************
 */

import com.hb.day03.model.dao.GuestDao;

@Controller
public class SelectController {
	@Autowired
	private GuestDao guestDao;

	@RequestMapping("/list")
	public ModelAndView selectAll(ModelAndView mav){
		try {
			mav.addObject("alist", guestDao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping("/guest/{idx}")
	public String selectOne(@PathVariable int idx,Model model){
		try {
			model.addAttribute("bean", guestDao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "detail";
	}
	
}













