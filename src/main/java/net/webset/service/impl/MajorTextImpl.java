package net.webset.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.webset.entity.MajorText;
import net.webset.mapper.MajorTextMapper;
import net.webset.service.IMajorTextService;
import net.webset.wapper.MajorTextWapper;
import net.webset.wapper.api.vos.MajorScoreVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 专业数据文本类型ServiceImpl类
 * @author hby
 * create date: 2020-08-18
 */
@Service
public class MajorTextImpl extends ServiceImpl<MajorTextMapper, MajorText> implements IMajorTextService {

    @Resource
    private MajorTextMapper majorTextMapper;

    /**
     * 专业数据得分列表
     * @param page
     * @param majorTextWapper
     * @return
     */
    @Override
    public Page<MajorScoreVO> getMajorScoreList(Page page, MajorTextWapper majorTextWapper) {
        return this.majorTextMapper.getMajorScoreList(page,majorTextWapper);
    }
}
