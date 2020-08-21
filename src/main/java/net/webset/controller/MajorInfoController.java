package net.webset.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.webset.config.SecurityProperties;
import net.webset.entity.*;
import net.webset.service.IImagesMajorService;
import net.webset.service.IMajorInfoService;
import net.webset.service.IMajorNumberService;
import net.webset.service.IMajorTextService;
import net.webset.util.ResultInfo;
import net.webset.util.options.Delete;
import net.webset.wapper.*;
import net.webset.wapper.page.PageUtilResult;
import net.webset.wapper.page.PageUtilWapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

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
	private IImagesMajorService iImagesMajorService;

	@Resource
	private IMajorInfoService iMajorInfoService;

	@Resource
	private SecurityProperties securityProperties;


	/**
	 * 专业数据填报列表
	 * @param mav
	 * @return
	 */
	@GetMapping("majorFill.html")
	public ModelAndView majorFill(ModelAndView mav) {
		//清空专业ID - majorId
		session.removeAttribute("majorId");
		//专业列表页面
		mav.setViewName("major/majorList.html");
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
		IPage<MajorText> page = iMajorTextService.page(new Page<MajorText>(pwapper.getOffset(), pwapper.getLimit()), majorTextWapper);
		PageUtilResult<MajorText> result = new PageUtilResult<>();
		List<MajorText> majorTexts = page.getRecords();
		result.setTotal(page.getTotal());
		result.setRows(page.getRecords());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * 跳转到专业数据填报页面
	 * @param mav
	 * @return
	 */
	@GetMapping("majorAddPage.html")
	public ModelAndView majorAddPage(ModelAndView mav) {
		//清空专业ID - majorId
		session.removeAttribute("majorId");
		MajorText mt = new MajorText();
		MajorNumber mn = new MajorNumber();
		mav.addObject("mt", mt);
		mav.addObject("mn", mn);
		mav.setViewName("major/fill.html");
		return mav;
	}

	/**
	 * 删除专业数据文档
	 * @param majorText
	 * @param result
	 * @param mav
	 * @return
	 */
	@GetMapping("majorDel.html")
	public ModelAndView majorDel(@Validated(Delete.class) MajorText majorText, BindingResult result, ModelAndView mav) {
		Integer majorId = majorText.getMajorid();
		Boolean isDel = this.iMajorInfoService.majorDel(majorId);
		mav.addObject("info", isDel ? "删除成功" : "删除失败");
		mav.setViewName("major/majorList.html");
		return mav;
	}


	/**
	 * 跳转专业数据编辑页面
	 * @param mav
	 * @param majorText
	 * @return
	 */
	@GetMapping("majorUpdatePage.html")
	public ModelAndView majorUpdatePage(ModelAndView mav, MajorText majorText) {
		Integer majorId = majorText.getMajorid();
		session.setAttribute("majorId",majorId);
		QueryWrapper<MajorText> majorTextQueryWrapper = new QueryWrapper<>();
		QueryWrapper<MajorNumber> majorNumberQueryWrapper = new QueryWrapper<>();
		majorTextQueryWrapper.eq("majorid",majorId);
		majorNumberQueryWrapper.eq("majorid",majorId);
		MajorText mt = iMajorTextService.getOne(majorTextQueryWrapper);
		MajorNumber mn = iMajorNumberService.getOne(majorNumberQueryWrapper);
		mav.addObject("majorId",majorId);
		mav.addObject("mt", mt);
		mav.addObject("mn", mn);
		mav.setViewName("major/fill.html");
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


	/**
	 * 通过Majorid获取所属附件
	 * @return
	 */
	@PostMapping("majorFillgetImagesById.json")
	public List<ImagesMajor> majorFillgetImagesById(){
		User user = (User) session.getAttribute("user");
		List<ImagesMajor> imagesMajorList = new ArrayList<>();
		ImagesMajorWapper wapper = new ImagesMajorWapper();
		//获取session中专业文档id
		Integer sessionMajorId = (Integer) session.getAttribute("majorId");
		//判断专业文档Id是否为null
		if(sessionMajorId == null || "".equals(sessionMajorId)){
			return null;
		}
//		if(majorId != null && sessionMajorId.equals(majorId)){
			wapper.setCreateId(user.getId());
			wapper.setMajorId(sessionMajorId);
			imagesMajorList = this.iImagesMajorService.list(wapper);
//		}
		//返回结果
		return imagesMajorList;
	}


	/**
	 * 通过url请求返回图像的字节流
	 */
	@GetMapping("/majorFillshowFile.json")
	public void showImage(@RequestParam("name") String cateogry, HttpServletRequest request,
						  HttpServletResponse response) throws IOException {

		if(StringUtils.isEmpty(cateogry)) {
			cateogry = "";
		}

		//文件名
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

	/**
	 * 删除附件
	 * @param key
	 * @return
	 */
	@PostMapping("/majorFilldeleteFile.json")
	@ResponseBody
	public Map<String, Object> deleteImage(String key){
		iImagesMajorService.removeById(key);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("info", "删除成功");
		return result;
	}


	/**
	 * 上传附件
	 * @param file
	 * @param request
	 * @return
	 */
	@PostMapping("majorFillUploadPDF.json")
	public ImagesMajor toUploadImage(@RequestParam("file") MultipartFile file,
								HttpServletRequest request){
		ImagesMajor b = new ImagesMajor();
		User user = (User) session.getAttribute("user");
		Integer sessionMajorId = (Integer) session.getAttribute("majorId");
		if (!file.isEmpty() && sessionMajorId != null) {
			try { // 转存文件
				// 文件原名称包括后缀名 file.getOriginalFilename();
				String end = file.getOriginalFilename().split("\\.")[file.getName().split("\\.").length];
				String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + end;
				File nf = new File(securityProperties.getOther().getPath() + fileName);
				//如果文件不存在
				if (!nf.exists()){
					try {
						nf.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				file.transferTo(nf);
				b.setSourceName(file.getOriginalFilename());
				b.setName(fileName);
				b.setSize(file.getSize());
				b.setCreateId(user.getId());
				b.setType(end);
				b.setMajorId(sessionMajorId);
				iImagesMajorService.save(b);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return b;

	}




}
