package net.webset.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.webset.entity.MajorNumber;
import net.webset.wapper.MajorTextWapper;
import net.webset.wapper.api.vos.MajorConclusionVO;

/**
 * 专业数据数值类型Mapper类
 * @author hby
 * create date: 2020-08-18
 */
public interface MajorNumberMapper extends BaseMapper<MajorNumber> {

    //专业数据厅展示列表
    Page<MajorConclusionVO> getConclusionList(Page page, MajorTextWapper majorTextWapper);

}
