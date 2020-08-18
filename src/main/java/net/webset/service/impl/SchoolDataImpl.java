package net.webset.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import net.webset.entity.SchoolData;
import net.webset.mapper.SchoolDataMapper;
import net.webset.service.ISchoolDataService;

@Service
public class SchoolDataImpl extends ServiceImpl<SchoolDataMapper, SchoolData> implements ISchoolDataService {

}
