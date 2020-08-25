package net.webset.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import net.webset.entity.MajorText;
import net.webset.wapper.MajorTextWapper;
import net.webset.wapper.api.vos.MajorConclusionVO;
import net.webset.wapper.api.vos.MajorScoreVO;

import java.util.List;


/**
 * 专业数据文本类型Service接口类
 * @author hby
 * create date: 2020-08-18
 */
public interface IMajorTextService extends IService<MajorText> {

    //专业数据得分列表
    Page<MajorScoreVO> getMajorScoreList(Page page, MajorTextWapper majorTextWapper);




}
