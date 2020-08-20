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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.webset.entity.IaIeSsSr;
import net.webset.entity.SchoolData;
import net.webset.entity.SpRpSdM;
import net.webset.entity.SrBm;
import net.webset.entity.TsTr;
import net.webset.entity.User;
import net.webset.service.IIaIeSsSrService;
import net.webset.service.ISchoolDataService;
import net.webset.service.ISpRpSdMService;
import net.webset.service.ISrBmService;
import net.webset.service.ITsTrService;
import net.webset.util.ResultInfo;
import net.webset.util.options.Add;
import net.webset.util.options.Update;
import net.webset.wapper.IaIeSsSrWapper;
import net.webset.wapper.SchoolDataWapper;
import net.webset.wapper.SpRpSdMWapper;
import net.webset.wapper.SrBmWapper;
import net.webset.wapper.TsTrWapper;

@RequestMapping("/schooldata/")
@RestController
public class SchoolInfoController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ISchoolDataService iSchoolInfoService;
	
	@Autowired
	private ITsTrService iTsTrService;
	
	@Autowired
	private ISpRpSdMService iSpRpSdMService;
	
	@Autowired
	private IIaIeSsSrService iIaIeSsSrService;
	
	@Autowired
	private ISrBmService iSrBmService;

	@GetMapping("schoolFill.html")
	public ModelAndView schoolFill(ModelAndView mav) {
		User user = (User) session.getAttribute("user");
		//获取学校基础信息
		SchoolDataWapper wapper = new SchoolDataWapper();
		wapper.setCreateId(user.getId());
		Optional<SchoolData> d = Optional.ofNullable(iSchoolInfoService.getOne(wapper));
		//获取师资队伍和教学资源
		TsTrWapper ts = new TsTrWapper();
		ts.setCreateId(user.getId());
		Optional<TsTr> t = Optional.ofNullable(iTsTrService.getOne(ts));
		//获取支撑平台*科研项目*学生发展*专业
		SpRpSdMWapper ss = new SpRpSdMWapper();
		ss.setCreateId(user.getId());
		Optional<SpRpSdM> s = Optional.ofNullable(iSpRpSdMService.getOne(ss));
		//获取创新成果*国际交流*社会服务*办学声誉
		IaIeSsSrWapper ff = new IaIeSsSrWapper();
		ff.setCreateId(user.getId());
		Optional<IaIeSsSr> f = Optional.ofNullable(iIaIeSsSrService.getOne(ff));
		//获取办学经费*基础调解
		SrBmWapper xx = new SrBmWapper();
		xx.setCreateId(user.getId());
		Optional<SrBm> x = Optional.ofNullable(iSrBmService.getOne(xx));
		
		
		mav.addObject("d", d.isPresent() ? d.get() : new SchoolData());
		mav.addObject("t", t.isPresent() ? t.get() : new TsTr());
		mav.addObject("s", s.isPresent() ? s.get() : new SpRpSdM());
		mav.addObject("f", f.isPresent() ? f.get() : new IaIeSsSr());
		mav.addObject("x", x.isPresent() ? x.get() : new SrBm());
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
	
	@PostMapping("schoolFillTTSave.json")
	public ResultInfo<List<String>> schoolFillTTSave(@Validated(Add.class) TsTr sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			User user = (User) session.getAttribute("user");
			TsTrWapper wapper = new TsTrWapper();
			wapper.setCreateId(user.getId());
			Optional<TsTr> d = Optional.ofNullable(iTsTrService.getOne(wapper));
			if(d.isPresent()) {
				return new ResultInfo<List<String>>(400,"数据已存在。无法保存",null);
			}
			sc.setCreateId(user.getId());
			boolean isSuccess = iTsTrService.save(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "保存成功" : "保存失败",null);
		} 
	}
	
	@PostMapping("schoolFillTTUpdate.json")
	public ResultInfo<List<String>> schoolFillTTUpdate(@Validated(Update.class) TsTr sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			boolean isSuccess = iTsTrService.updateById(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "更新成功" : "更新失败",null);
		} 
	}
	
	@PostMapping("schoolFillSRSMSave.json")
	public ResultInfo<List<String>> schoolFillSRSMSave(@Validated(Add.class) SpRpSdM sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			User user = (User) session.getAttribute("user");
			SpRpSdMWapper wapper = new SpRpSdMWapper();
			wapper.setCreateId(user.getId());
			Optional<SpRpSdM> d = Optional.ofNullable(iSpRpSdMService.getOne(wapper));
			if(d.isPresent()) {
				return new ResultInfo<List<String>>(400,"数据已存在。无法保存",null);
			}
			sc.setCreateId(user.getId());
			boolean isSuccess = iSpRpSdMService.save(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "保存成功" : "保存失败",null);
		} 
	}
	
	@PostMapping("schoolFillSRSMUpdate.json")
	public ResultInfo<List<String>> schoolFillSRSMUpdate(@Validated(Update.class) SpRpSdM sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			boolean isSuccess = iSpRpSdMService.updateById(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "更新成功" : "更新失败",null);
		} 
	}
	
	@PostMapping("schoolFillIISSSave.json")
	public ResultInfo<List<String>> schoolFillIISSSave(@Validated(Add.class) IaIeSsSr sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			User user = (User) session.getAttribute("user");
			IaIeSsSrWapper wapper = new IaIeSsSrWapper();
			wapper.setCreateId(user.getId());
			Optional<IaIeSsSr> d = Optional.ofNullable(iIaIeSsSrService.getOne(wapper));
			if(d.isPresent()) {
				return new ResultInfo<List<String>>(400,"数据已存在。无法保存",null);
			}
			sc.setCreateId(user.getId());
			boolean isSuccess = iIaIeSsSrService.save(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "保存成功" : "保存失败",null);
		} 
	}
	
	@PostMapping("schoolFillIISSUpdate.json")
	public ResultInfo<List<String>> schoolFillIISSUpdate(@Validated(Update.class) IaIeSsSr sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			boolean isSuccess = iIaIeSsSrService.updateById(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "更新成功" : "更新失败",null);
		} 
	}
	
	@PostMapping("schoolFillSBSave.json")
	public ResultInfo<List<String>> schoolFillSBSave(@Validated(Add.class) SrBm sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			User user = (User) session.getAttribute("user");
			SrBmWapper wapper = new SrBmWapper();
			wapper.setCreateId(user.getId());
			Optional<SrBm> d = Optional.ofNullable(iSrBmService.getOne(wapper));
			if(d.isPresent()) {
				return new ResultInfo<List<String>>(400,"数据已存在。无法保存",null);
			}
			sc.setCreateId(user.getId());
			boolean isSuccess = iSrBmService.save(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "保存成功" : "保存失败",null);
		} 
	}
	
	@PostMapping("schoolFillSBUpdate.json")
	public ResultInfo<List<String>> schoolFillSBUpdate(@Validated(Update.class) SrBm sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			boolean isSuccess = iSrBmService.updateById(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "更新成功" : "更新失败",null);
		} 
	}
}
