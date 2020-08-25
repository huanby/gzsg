package net.webset.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import net.webset.entity.MajorNumber;
import net.webset.wapper.MajorTextWapper;
import net.webset.wapper.api.vos.MajorConclusionVO;


/**
 * 专业数据数值类型Service接口类
 * @author hby
 * create date: 2020-08-18
 */
public interface IMajorNumberService extends IService<MajorNumber> {

    //专业数据厅展示列表
    Page<MajorConclusionVO> getConclusionList(Page page, MajorTextWapper majorTextWapper);

}
