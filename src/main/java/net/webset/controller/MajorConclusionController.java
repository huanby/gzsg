package net.webset.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.webset.entity.*;
import net.webset.service.ILaOnService;
import net.webset.service.IMajorNumberService;
import net.webset.service.IMajorScoreService;
import net.webset.service.IMajorTextService;
import net.webset.wapper.api.vos.MajorConclusionVO;
import net.webset.wapper.MajorConclusionVOWapper;
import net.webset.wapper.page.PageUtilResult;
import net.webset.wapper.page.PageUtilWapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 专业数据厅展示Controller类
 * @author hby
 * create date: 2020-08-24
 */
@RestController
@RequestMapping("/conclusion/")
public class MajorConclusionController {

	@Resource
	private HttpSession session;

	@Resource
	private IMajorNumberService iMajorNumberService;

	@Resource
	private IMajorTextService iMajorTextService;

	@Resource
	private IMajorScoreService iMajorScoreService;
	
	@Autowired
	private ILaOnService iLaOnService;

	//跳转厅展示页面
	@GetMapping("majorConclusionShow.html")
	public ModelAndView conclusionShow(ModelAndView mav) {
		mav.setViewName("conclusionMajor/conclusionMajorList");
		return mav;
	}


	//查询厅展示列表数据
	@GetMapping("majorConclusionList.json")
	public ResponseEntity<?> majorConclusionList(MajorConclusionVOWapper majorConclusionVOWapper, PageUtilWapper pwapper){
		User user = (User) session.getAttribute("user");
		// 初始化查询条件   majorTextWapper-查询条件
//		majorTextWapper.setCreateId(user.getId());
		majorConclusionVOWapper.orderByDesc("updatetime");
		PageUtilResult<MajorConclusionVO> result = new PageUtilResult<>();
		IPage<MajorConclusionVO> page = this.iMajorNumberService.getConclusionList(new Page(pwapper.getOffset(), pwapper.getLimit()), majorConclusionVOWapper);
//		IPage<MajorConclusionVO> page = this.iMajorNumberService.page(new Page<MajorConclusionVO>(pwapper.getOffset(), pwapper.getLimit()), majorConclusionVOWapper);
		result.setTotal(page.getTotal());
		result.setRows(page.getRecords());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}


	@GetMapping("conclusionMajorShow.html")
	public ModelAndView conclusionMajorShow(ModelAndView mav,MajorText majorText, @RequestParam(value = "majorId") Integer majorId) {
		User user = (User) session.getAttribute("user");
		//获取专业数据id
//        Integer majorId = majorText.getMajorid();
		//存入majorId到session
		session.setAttribute("majorId",majorId);
		QueryWrapper<MajorText> majorTextQueryWrapper = new QueryWrapper<>();
		QueryWrapper<MajorNumber> majorNumberQueryWrapper = new QueryWrapper<>();
		QueryWrapper<MajorScore> majorScoreQueryWrapper = new QueryWrapper<>();
		majorTextQueryWrapper.eq("majorid",majorId);
		majorNumberQueryWrapper.eq("majorid",majorId);
		majorScoreQueryWrapper.eq("majorid",majorId);
		majorScoreQueryWrapper.eq("create_id",user.getId());
		//获取专业数据及得分
		MajorText mt = iMajorTextService.getOne(majorTextQueryWrapper);
		MajorNumber mn = iMajorNumberService.getOne(majorNumberQueryWrapper);
		MajorScore ms = iMajorScoreService.getOne(majorScoreQueryWrapper);
		mav.addObject("majorId",majorId);
		mav.addObject("createId",user.getId());
		mav.addObject("mt", mt);
		mav.addObject("mn", mn);
		mav.addObject("ms", ms);
		mav.addObject("isExamine", true);
		mav.addObject("isView", true);
		//跳转页面
		mav.setViewName("conclusionMajor/fill");
		return mav;
	}








}
