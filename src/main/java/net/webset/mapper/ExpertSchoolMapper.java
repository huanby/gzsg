package net.webset.mapper;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import net.webset.view.ExpertSchool;

public interface ExpertSchoolMapper extends BaseMapper<ExpertSchool> {
	
	IPage<ExpertSchool> pageExpertSchool(IPage<ExpertSchool> page,@Param(Constants.WRAPPER) QueryWrapper<ExpertSchool> wrapper,@Param("examId") Integer examId);

}
