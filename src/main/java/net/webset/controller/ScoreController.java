package net.webset.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

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
import net.webset.service.IScoreService;
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
import net.webset.wapper.ScoreWapper;
import net.webset.wapper.SpRpSdMWapper;
import net.webset.wapper.SrBmWapper;
import net.webset.wapper.TsTrWapper;
import net.webset.wapper.page.PageUtilResult;
import net.webset.wapper.page.PageUtilWapper;

@RestController
@RequestMapping("/score/")
public class ScoreController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ISchoolDataService iSchoolDataService;
	
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
	
	@Autowired
	private IScoreService iScoreService;

	@GetMapping("scoreSchool.html")
	public ModelAndView scoreSchool(ModelAndView mav) {
		mav.setViewName("score/scoreList");
		return mav;
	}

	@GetMapping("scoreSchoolList.json")
	public PageUtilResult<SchoolData> scoreSchoolList(SchoolDataWapper data,PageUtilWapper pwapper){
		IPage<SchoolData> page = iSchoolDataService.page(
				new Page<SchoolData>(pwapper.getOffset(), pwapper.getLimit()), data);
		
		
		if(!page.getRecords().isEmpty()) {
			User user = (User) session.getAttribute("user");
			List<SchoolData> sds = page.getRecords();
			for(int i=0;i<sds.size();i++) {
				ScoreWapper wap = new ScoreWapper();
				wap.setUserId(sds.get(i).getCreateId());
				wap.setExamId(user.getId());
				sds.get(i).setScore(iScoreService.getOne(wap));
			}
			page.setRecords(sds);
		}
		PageUtilResult<SchoolData> result = new PageUtilResult<>();
		result.setTotal(page.getTotal());
		result.setRows(page.getRecords());
		return result;
	}
	
	@GetMapping("scoreSchoolShow.html")
	public ModelAndView scoreSchoolShow(ModelAndView mav,Integer id) {
		//获取学校基础信息
		SchoolDataWapper wapper = new SchoolDataWapper();
		wapper.setCreateId(id);
		Optional<SchoolData> d = Optional.ofNullable(iSchoolDataService.getOne(wapper));
		//获取师资队伍和教学资源
		TsTrWapper ts = new TsTrWapper();
		ts.setCreateId(id);
		Optional<TsTr> t = Optional.ofNullable(iTsTrService.getOne(ts));
		//获取支撑平台*科研项目*学生发展*专业
		SpRpSdMWapper ss = new SpRpSdMWapper();
		ss.setCreateId(id);
		Optional<SpRpSdM> s = Optional.ofNullable(iSpRpSdMService.getOne(ss));
		//获取创新成果*国际交流*社会服务*办学声誉
		IaIeSsSrWapper ff = new IaIeSsSrWapper();
		ff.setCreateId(id);
		Optional<IaIeSsSr> f = Optional.ofNullable(iIaIeSsSrService.getOne(ff));
		//获取办学经费*基础调解
		SrBmWapper xx = new SrBmWapper();
		xx.setCreateId(id);
		Optional<SrBm> x = Optional.ofNullable(iSrBmService.getOne(xx));
		//获取标志性成果*其它国家级成果
		LaOnWapper gg = new LaOnWapper();
		gg.setCreateId(id);
		Optional<LaOn> g = Optional.ofNullable(iLaonService.getOne(gg));
		//获取评价信息
		User user = (User) session.getAttribute("user");
		ScoreWapper aa = new ScoreWapper();
		aa.setExamId(user.getId());
		aa.setUserId(id);
		Optional<Score> a = Optional.ofNullable(iScoreService.getOne(aa));
		
		mav.addObject("d", d.isPresent() ? d.get() : new SchoolData());
		mav.addObject("t", t.isPresent() ? t.get() : new TsTr());
		mav.addObject("s", s.isPresent() ? s.get() : new SpRpSdM());
		mav.addObject("f", f.isPresent() ? f.get() : new IaIeSsSr());
		mav.addObject("x", x.isPresent() ? x.get() : new SrBm());
		mav.addObject("g", g.isPresent() ? g.get() : new LaOn());
		mav.addObject("a", a.isPresent() ? a.get() : new Score());
		mav.addObject("isExamine", true);
		mav.addObject("createId", id);
		mav.setViewName("school/fill");
		return mav;
	}
	
	
	@PostMapping("schoolFillgetImagesById.json")
	public List<Images> schoolFillgetImagesById(Integer id){
		
		ImagesWapper wapper = new ImagesWapper();
		wapper.setCreateId(id);
		
		return iImagesService.list(wapper);
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
    
    @PostMapping("scoreSave.json")
	public ResultInfo<List<String>> scoreSave(@Validated(Add.class) Score sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			User user = (User) session.getAttribute("user");
			ScoreWapper wapper = new ScoreWapper();
			wapper.setExamId(user.getId());
			wapper.setUserId(sc.getUserId());
			Optional<Score> d = Optional.ofNullable(iScoreService.getOne(wapper));
			if(d.isPresent()) {
				return new ResultInfo<List<String>>(400,"数据已存在。无法保存",null);
			}
			sc.setExamId(user.getId());
			boolean isSuccess = iScoreService.save(sc);
			isSuccess = iLaonService.syncScoreAndLaOn(sc);
			
			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "保存成功,"+sc.getId() : "保存失败",null);
		} 
	}
	
	@PostMapping("scoreUpdate.json")
	public ResultInfo<List<String>> scoreUpdate(@Validated(Update.class) Score sc, 
			BindingResult result){
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
		    List<String> collect = fieldErrors.stream()
		            .map(o -> o.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResultInfo<List<String>>(400,"请求参数错误",collect);
		}else {
			boolean isSuccess = iScoreService.updateById(sc);
			isSuccess = iLaonService.syncScoreAndLaOn(sc);

			return new ResultInfo<List<String>>(isSuccess ? 200 : 400,
					isSuccess ? "更新成功" : "更新失败",null);
		} 
	}

}
