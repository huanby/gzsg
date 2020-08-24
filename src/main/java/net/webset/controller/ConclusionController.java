package net.webset.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import net.webset.entity.IaIeSsSr;
import net.webset.entity.LaOn;
import net.webset.entity.SchoolData;
import net.webset.entity.Score;
import net.webset.entity.SpRpSdM;
import net.webset.entity.SrBm;
import net.webset.entity.TsTr;
import net.webset.service.IIaIeSsSrService;
import net.webset.service.ILaOnService;
import net.webset.service.ISchoolDataService;
import net.webset.service.ISpRpSdMService;
import net.webset.service.ISrBmService;
import net.webset.service.ITsTrService;
import net.webset.wapper.IaIeSsSrWapper;
import net.webset.wapper.LaOnWapper;
import net.webset.wapper.SchoolDataWapper;
import net.webset.wapper.SpRpSdMWapper;
import net.webset.wapper.SrBmWapper;
import net.webset.wapper.TsTrWapper;
import net.webset.wapper.page.PageUtilResult;
import net.webset.wapper.page.PageUtilWapper;

@RestController
@RequestMapping("/conclusion/")
public class ConclusionController {
	
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
	private ILaOnService iLaOnService;
	
	@GetMapping("conclusionShow.html")
	public ModelAndView conclusionShow(ModelAndView mav) {
		mav.setViewName("conclusion/conclusionList");
		return mav;
	}
	
	@GetMapping("conclusionList.json")
	public PageUtilResult<LaOn> conclusionList(LaOnWapper data,PageUtilWapper pwapper){
		IPage<LaOn> page = iLaOnService.page(
				new Page<LaOn>(pwapper.getOffset(), pwapper.getLimit()), data);
		
		PageUtilResult<LaOn> result = new PageUtilResult<>();
		result.setTotal(page.getTotal());
		result.setRows(page.getRecords());
		return result;
	}
	
	@GetMapping("conclusionSchoolDataShow.html")
	public ModelAndView conclusionSchoolDataShow(ModelAndView mav,Integer id) {
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
				Optional<LaOn> g = Optional.ofNullable(iLaOnService.getOne(gg));

				mav.addObject("d", d.isPresent() ? d.get() : new SchoolData());
				mav.addObject("t", t.isPresent() ? t.get() : new TsTr());
				mav.addObject("s", s.isPresent() ? s.get() : new SpRpSdM());
				mav.addObject("f", f.isPresent() ? f.get() : new IaIeSsSr());
				mav.addObject("x", x.isPresent() ? x.get() : new SrBm());
				mav.addObject("g", g.isPresent() ? g.get() : new LaOn());
				mav.addObject("a", new Score());
				mav.addObject("isExamine", true);
				mav.addObject("createId", id);
				mav.addObject("isView",true);
				mav.setViewName("school/fill");
				return mav;
	}
}
