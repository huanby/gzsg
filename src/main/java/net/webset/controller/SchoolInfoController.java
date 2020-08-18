package net.webset.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.webset.entity.SchoolData;
import net.webset.entity.User;
import net.webset.service.ISchoolDataService;
import net.webset.util.ResultInfo;
import net.webset.util.options.Add;
import net.webset.util.options.Update;
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
	
	@PostMapping("schoolFillBaseSave.json")
	public ResultInfo<List<String>> schoolFillBaseSave(@Validated(Add.class) SchoolData sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			User user = (User) session.getAttribute("user");
			SchoolDataWapper wapper = new SchoolDataWapper();
			wapper.setCreateId(user.getId());
			Optional<SchoolData> d = Optional.ofNullable(iSchoolInfoService.getOne(wapper));
			if(d.isPresent()) {
				return new ResultInfo<List<String>>(400,"数据已存在。无法保存",null);
			}
			sc.setCreateId(user.getId());
			boolean isSuccess = iSchoolInfoService.save(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "保存成功" : "保存失败",null);
		} 
	}
	
	@PostMapping("schoolFillBaseUpdate.json")
	public ResultInfo<List<String>> schoolFillBaseUpdate(@Validated(Update.class) SchoolData sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			boolean isSuccess = iSchoolInfoService.updateById(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "更新成功" : "更新失败",null);
		} 
	}
}
