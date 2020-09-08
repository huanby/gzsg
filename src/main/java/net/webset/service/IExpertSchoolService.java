package net.webset.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import net.webset.view.ExpertSchool;

public interface IExpertSchoolService extends IService<ExpertSchool> {
	
	public IPage<ExpertSchool> expertSchool(Page<ExpertSchool> page,QueryWrapper<ExpertSchool> wrapper,Integer examId) ;

}
