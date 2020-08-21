package net.webset.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.webset.entity.MajorText;
import net.webset.wapper.MajorTextWapper;
import net.webset.wapper.api.vos.MajorScoreVO;

import java.util.List;

/**
 * 专业数据文本类型Mapper类
 * @author hby
 * create date: 2020-08-18
 */
public interface MajorTextMapper extends BaseMapper<MajorText> {

    Page<MajorScoreVO> getMajorScoreList(Page page, MajorTextWapper majorTextWapper);

}
