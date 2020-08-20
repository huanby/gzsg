package net.webset.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.webset.entity.MajorNumber;
import net.webset.mapper.MajorNumberMapper;
import net.webset.service.IMajorNumberService;
import org.springframework.stereotype.Service;

/**
 * 专业数据数值类型ServiceImpl类
 * @author hby
 * create date: 2020-08-18
 */
@Service
public class MajorNumberImpl extends ServiceImpl<MajorNumberMapper, MajorNumber> implements IMajorNumberService {

}
