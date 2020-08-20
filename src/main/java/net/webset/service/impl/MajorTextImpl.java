package net.webset.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.webset.entity.MajorText;
import net.webset.mapper.MajorTextMapper;
import net.webset.service.IMajorTextService;
import org.springframework.stereotype.Service;

/**
 * 专业数据文本类型ServiceImpl类
 * @author hby
 * create date: 2020-08-18
 */
@Service
public class MajorTextImpl extends ServiceImpl<MajorTextMapper, MajorText> implements IMajorTextService {

}
