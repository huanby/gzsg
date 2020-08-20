package net.webset.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.webset.entity.MajorNumber;
import net.webset.entity.MajorText;
import net.webset.util.ResultInfo;
import org.springframework.validation.BindingResult;

import java.util.List;


/**
 * 专业数据Service接口类
 * @author hby
 * create date: 2020-08-19
 */
public interface IMajorInfoService{

    //保存基础信息
    ResultInfo<List<String>> majorFillbasicInfoSave(MajorNumber mn, MajorText mt, BindingResult result);
}
