package net.webset.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import net.webset.entity.MajorNumber;
import net.webset.entity.MajorScore;
import net.webset.wapper.api.vos.MajorConclusionVO;
import net.webset.wapper.MajorConclusionVOWapper;


/**
 * 专业数据数值类型Service接口类
 * @author hby
 * create date: 2020-08-18
 */
public interface IMajorNumberService extends IService<MajorNumber> {

    //专业数据厅展示列表
    Page<MajorConclusionVO> getConclusionList(Page page, MajorConclusionVOWapper MajorConclusionVOWapper);

    //同步评分总数
    boolean syncScoreAndMajorNumber(MajorScore ms);
}
