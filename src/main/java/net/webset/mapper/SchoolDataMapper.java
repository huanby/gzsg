package net.webset.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import net.webset.entity.SchoolData;

public interface SchoolDataMapper extends BaseMapper<SchoolData> {
	
	public SchoolData selectByCreateId(Integer id);

}
