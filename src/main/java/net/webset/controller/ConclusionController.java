package net.webset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import net.webset.entity.LaOn;
import net.webset.service.ILaOnService;
import net.webset.wapper.LaOnWapper;
import net.webset.wapper.page.PageUtilResult;
import net.webset.wapper.page.PageUtilWapper;

@RestController
@RequestMapping("/conclusion/")
public class ConclusionController {
	
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
}
