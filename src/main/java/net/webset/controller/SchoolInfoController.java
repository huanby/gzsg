package net.webset.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.webset.entity.SchoolData;
import net.webset.entity.User;
import net.webset.service.ISchoolDataService;
import net.webset.wapper.SchoolDataWapper;

@RequestMapping("/schooldata/")
@RestController
public class SchoolInfoController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ISchoolDataService iSchoolInfoService;

	@GetMapping("schoolFill.html")
	public ModelAndView schoolFill(ModelAndView mav) {
		User user = (User) session.getAttribute("user");
		SchoolDataWapper wapper = new SchoolDataWapper();
		wapper.setCreateId(user.getId());
		Optional<SchoolData> d = Optional.ofNullable(iSchoolInfoService.getOne(wapper));
		mav.addObject("success", d.isPresent());
		mav.addObject("d", d.isPresent() ? d.get() : null);
		mav.setViewName("school/fill");
		return mav;
	}
}
