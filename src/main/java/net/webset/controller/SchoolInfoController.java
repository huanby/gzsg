package net.webset.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.webset.config.SecurityProperties;
import net.webset.entity.IaIeSsSr;
import net.webset.entity.Images;
import net.webset.entity.LaOn;
import net.webset.entity.SchoolData;
import net.webset.entity.Score;
import net.webset.entity.SpRpSdM;
import net.webset.entity.SrBm;
import net.webset.entity.TsTr;
import net.webset.entity.User;
import net.webset.service.IIaIeSsSrService;
import net.webset.service.IImagesService;
import net.webset.service.ILaOnService;
import net.webset.service.ISchoolDataService;
import net.webset.service.ISpRpSdMService;
import net.webset.service.ISrBmService;
import net.webset.service.ITsTrService;
import net.webset.util.ResultInfo;
import net.webset.util.options.Add;
import net.webset.util.options.Update;
import net.webset.wapper.IaIeSsSrWapper;
import net.webset.wapper.ImagesWapper;
import net.webset.wapper.LaOnWapper;
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
	
	@Autowired
	private ILaOnService iLaonService;
	
	@Autowired 
	private IImagesService iImagesService;
	
	@Autowired
	private SecurityProperties securityProperties;

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
		//获取标志性成果*其它国家级成果
		LaOnWapper gg = new LaOnWapper();
		gg.setCreateId(user.getId());
		Optional<LaOn> g = Optional.ofNullable(iLaonService.getOne(gg));
		
		
		mav.addObject("d", d.isPresent() ? d.get() : new SchoolData());
		mav.addObject("t", t.isPresent() ? t.get() : new TsTr());
		mav.addObject("s", s.isPresent() ? s.get() : new SpRpSdM());
		mav.addObject("f", f.isPresent() ? f.get() : new IaIeSsSr());
		mav.addObject("x", x.isPresent() ? x.get() : new SrBm());
		mav.addObject("g", g.isPresent() ? g.get() : new LaOn());
		mav.addObject("a", new Score());
		mav.addObject("isExamine", false);
		mav.addObject("createId", "");
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
	
	@PostMapping("schoolFillLAONSave.json")
	public ResultInfo<List<String>> schoolFillLAONSave(@Validated(Add.class) LaOn sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			User user = (User) session.getAttribute("user");
			LaOnWapper wapper = new LaOnWapper();
			wapper.setCreateId(user.getId());
			Optional<LaOn> d = Optional.ofNullable(iLaonService.getOne(wapper));
			if(d.isPresent()) {
				return new ResultInfo<List<String>>(400,"数据已存在。无法保存",null);
			}
			sc.setCreateId(user.getId());
			boolean isSuccess = iLaonService.save(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "保存成功" : "保存失败",null);
		} 
	}
	
	@PostMapping("schoolFillLAONUpdate.json")
	public ResultInfo<List<String>> schoolFillLAONUpdate(@Validated(Update.class) LaOn sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			boolean isSuccess = iLaonService.updateById(sc);
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "更新成功" : "更新失败",null);
		} 
	}
	
	@PostMapping("schoolFillgetImagesById.json")
	public List<Images> schoolFillgetImagesById(){
		User user = (User) session.getAttribute("user");
		ImagesWapper wapper = new ImagesWapper();
		wapper.setCreateId(user.getId());
		
		return iImagesService.list(wapper);
	}
	
	@PostMapping("schoolFillUploadPDF.json")
	public Images toUploadImage(@RequestParam("file")MultipartFile file, 
			HttpServletRequest request){
		
		Images b = new Images();
		User user = (User) session.getAttribute("user");
		if (!file.isEmpty()) {
			try { // 转存文件
				// 文件原名称包括后缀名 file.getOriginalFilename();
				String end = file.getOriginalFilename().split("\\.")[file.getName().split("\\.").length];
				String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + end;
				File nf = new File(securityProperties.getOther().getPath() + fileName);
				file.transferTo(nf);
				b.setSourceName(file.getOriginalFilename());
				b.setName(fileName);
				b.setSize(file.getSize());
				b.setCreateId(user.getId());
				b.setType(end);
				iImagesService.save(b);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return b;
		
	}
	
	/**
     * 通过url请求返回图像的字节流
     */
    @GetMapping("/schoolFillshowFile.json")
    public void showImage(@RequestParam("name") String cateogry,HttpServletRequest request,
    		HttpServletResponse response) throws IOException {

        if(StringUtils.isEmpty(cateogry)) {
            cateogry = "";
        }

        String fileName = securityProperties.getOther().getPath() + cateogry;
        File file = new File(fileName);

        FileInputStream inputStream = new FileInputStream(file);
        byte[] data = new byte[(int)file.length()];
        inputStream.read(data);
        inputStream.close();
        response.setContentType("application/pdf");;
        OutputStream stream = response.getOutputStream();
        stream.write(data);
        stream.flush();
        stream.close();
    }
    
    @PostMapping("/schoolFilldeleteFile.json")
    @ResponseBody
    public Map<String, Object> deleteImage(String key){
    	iImagesService.removeById(key);
    	Map<String,Object> result = new HashMap<String, Object>();
    	result.put("success", true);
    	result.put("info", "删除成功");
    	return result;
    }
}
