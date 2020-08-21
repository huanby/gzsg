package net.webset.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.webset.config.SecurityProperties;
import net.webset.entity.MajorNumber;
import net.webset.entity.MajorScore;
import net.webset.entity.MajorText;
import net.webset.entity.User;
import net.webset.service.IMajorNumberService;
import net.webset.service.IMajorScoreService;
import net.webset.service.IMajorTextService;
import net.webset.wapper.MajorTextWapper;
import net.webset.wapper.api.vos.MajorScoreVO;
import net.webset.wapper.page.PageUtilResult;
import net.webset.wapper.page.PageUtilWapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 专业数据评分Controller类
 * @author hby
 * create date: 2020-08-21
 */

@RequestMapping("/score/")
@RestController
public class MajorScoreController {

    @Resource
    private HttpSession session;

    @Resource
    private IMajorNumberService iMajorNumberService;

    @Resource
    private IMajorTextService iMajorTextService;

    @Resource
    private IMajorScoreService iMajorScoreService;

    @Resource
    private SecurityProperties securityProperties;



    /**
     * 专业数据列表
     * @param mav
     * @return
     */
    @GetMapping("scoreManjor.html")
    public ModelAndView scoreManjor(ModelAndView mav) {
        //清空专业ID - majorId
        session.removeAttribute("majorId");
        //专业列表页面
        mav.setViewName("scoreMajor/majorList");
//        mav.addObject("roleType","score_major");
        return mav;
    }


    /**
     * 专业数据列表查询
     * @param majorTextWapper
     * @param pwapper
     * @return
     */
    @GetMapping("majorList.json")
    public ResponseEntity<?> majorList(MajorTextWapper majorTextWapper, PageUtilWapper pwapper) {
        User user = (User) session.getAttribute("user");
        // 初始化查询条件   majorTextWapper-查询条件
        majorTextWapper.setCreateId(user.getId());
        majorTextWapper.orderByDesc("updatetime");
        PageUtilResult<MajorScoreVO> result = new PageUtilResult<>();
        IPage<MajorScoreVO> page = this.iMajorTextService.getMajorScoreList(new Page(pwapper.getOffset(), pwapper.getLimit()), majorTextWapper);
        result.setTotal(page.getTotal());
        result.setRows(page.getRecords());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 跳转专业数据评分编辑页面
     * @param mav
     * @param majorText
     * @return
     */
    @GetMapping("majorScoreUpdatePage.html")
    public ModelAndView majorUpdatePage(ModelAndView mav, MajorText majorText) {
        User user = (User) session.getAttribute("user");
        //获取专业数据id
        Integer majorId = majorText.getMajorid();
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
        mav.addObject("mt", mt);
        mav.addObject("mn", mn);
        mav.addObject("ms", ms);
        //跳转页面
        mav.setViewName("scoreMajor/fill.html");
        return mav;
    }




}
