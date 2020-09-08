package net.webset.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import net.webset.mapper.ExpertSchoolMapper;
import net.webset.service.IExpertSchoolService;
import net.webset.view.ExpertSchool;

@Service
public class ExpertSchoolServiceImpl extends ServiceImpl<ExpertSchoolMapper, ExpertSchool> implements IExpertSchoolService {

	@Autowired
	private ExpertSchoolMapper expertSchoolMapper;
	
	public IPage<ExpertSchool> expertSchool(Page<ExpertSchool> page,QueryWrapper<ExpertSchool> wrapper,Integer examId) {
	    return expertSchoolMapper.pageExpertSchool(page,wrapper,examId);
	}
}
