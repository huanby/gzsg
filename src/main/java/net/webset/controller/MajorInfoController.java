package net.webset.controller;

import net.webset.entity.MajorNumber;
import net.webset.entity.MajorText;
import net.webset.entity.User;
import net.webset.service.IMajorInfoService;
import net.webset.service.IMajorNumberService;
import net.webset.service.IMajorTextService;
import net.webset.util.ResultInfo;
import net.webset.wapper.MajorNumberWapper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 专业数据管理Controller类
 * @author hby
 * create date: 2020-08-18
 */

@RequestMapping("/majordata")
@RestController
public class MajorInfoController {

	@Resource
	private HttpSession session;

	@Resource
	private IMajorNumberService iMajorNumberService;

	@Resource
	private IMajorTextService iMajorTextService;


	@Resource
	private IMajorInfoService iMajorInfoService;

	/**
	 * 专业数据填报
	 * @param mav
	 * @return
	 */
	@GetMapping("/majorFill.html")
	public ModelAndView majorFill(ModelAndView mav) {
		User user = (User) session.getAttribute("user");
		MajorNumberWapper wapper = new MajorNumberWapper();
		wapper.setCreateId(user.getId());
		//清空专业ID - majorId
		session.removeAttribute("majorId");
//		Optional<MajorNumber> d = Optional.ofNullable(iMajorNumberService.getOne(wapper));
//		System.out.println(d);
//		mav.addObject("d", d.isPresent() ? d.get() : null);
//		mav.addObject("success", d.isPresent());
		mav.setViewName("major/fill");
		return mav;
	}


    /**
     * 保存专业填报数据信息
     * @param mn
     * @param mt
     * @param result
     * @return
     */
	@PostMapping("majorFillbasicInfoSave.json")
    public ResultInfo<List<String>> majorFillbasicInfoSave(MajorNumber mn, MajorText mt, BindingResult result) {
		ResultInfo<List<String>> resultInfo = null;
		try{
			resultInfo = this.iMajorInfoService.majorFillbasicInfoSave(mn,mt,result);
		}catch (Exception e){
			System.out.println(e);
			resultInfo = new ResultInfo<List<String>>(400,"保存失败",null);
		}
		//返回结果
		return resultInfo;
    }
}
