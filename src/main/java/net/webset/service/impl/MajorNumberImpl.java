package net.webset.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.webset.entity.MajorNumber;
import net.webset.mapper.MajorNumberMapper;
import net.webset.service.IMajorNumberService;
import net.webset.wapper.api.vos.MajorConclusionVO;
import net.webset.wapper.MajorConclusionVOWapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 专业数据数值类型ServiceImpl类
 * @author hby
 * create date: 2020-08-18
 */
@Service
public class MajorNumberImpl extends ServiceImpl<MajorNumberMapper, MajorNumber> implements IMajorNumberService {

    @Resource
    private MajorNumberMapper majorNumberMapper;


    /**
     * 专业数据厅展示列表
     * @param page
     * @param majorConclusionVOWapper
     * @return
     */
    @Override
    public Page<MajorConclusionVO> getConclusionList(Page page, MajorConclusionVOWapper majorConclusionVOWapper) {
        return this.majorNumberMapper.getConclusionList(page,majorConclusionVOWapper);
    }

}
