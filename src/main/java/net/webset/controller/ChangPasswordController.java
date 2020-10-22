package net.webset.controller;

import com.sun.deploy.security.WSeedGenerator;
import net.webset.entity.User;
import net.webset.service.IMenuService;
import net.webset.service.IUserService;
import net.webset.wapper.page.PageUtilResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 修改用户密码
 * 2020-10-22
 */
@RestController
@RequestMapping("/userInfo")
public class ChangPasswordController {

	@Autowired
	private HttpSession session;

	@Resource
	private IUserService iUserService;


	@PostMapping(value = {"/confirmPassword"})
	public ResponseEntity<?> confirmPassword(@RequestBody String password) {
//		mav.setViewName("index/login.html");
		User user = (User) session.getAttribute("user");
		//判断输入的原密码和加密后的密码是否一致
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		boolean matches = bc.matches(password,user.getPassword());
		if(matches){
			return new ResponseEntity<>(true, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(false, HttpStatus.OK);
		}
	}

	@RequestMapping(value = {"/changPassword"},method = RequestMethod.POST)
	public ResponseEntity<?> changPassword(@RequestBody String password) {
		User user = (User) session.getAttribute("user");
		BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
		// 对注册用户的密码进行加密，这里使用BCryptPassword加密方式
		String pass = bcp.encode(password);
		user.setPassword(pass);
		Boolean flag = iUserService.updateById(user);
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}

}