package net.webset.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import net.webset.entity.MajorNumber;
import net.webset.entity.MajorText;
import net.webset.entity.User;
import net.webset.service.IMajorInfoService;
import net.webset.service.IMajorNumberService;
import net.webset.service.IMajorTextService;
import net.webset.util.ResultInfo;
import net.webset.util.UUIDUtils;
import net.webset.wapper.MajorNumberWapper;
import net.webset.wapper.MajorTextWapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * 专业数据ServiceImpl类
 * @author hby
 * create date: 2020-08-19
 */
@Service
public class MajorInfoImpl implements IMajorInfoService {


    @Resource
    private HttpSession session;

    @Resource
    private IMajorNumberService iMajorNumberService;

    @Resource
    private IMajorTextService iMajorTextService;

    /**
     * 保存基础信息-专业（群）基本情况
     * @param mn
     * @param mt
     * @param result
     * @return
     */
    @Override
    public ResultInfo<List<String>> majorFillbasicInfoSave(MajorNumber mn, MajorText mt, BindingResult result) {
            User user = (User) session.getAttribute("user");
            //获取session中专业文档id
            Integer sessionMajorId = (Integer) session.getAttribute("majorId");
            //判断专业文档Id是否为null
            if(sessionMajorId == null || "".equals(sessionMajorId)){
                Integer majorId = UUIDUtils.getUUIDId();
                session.setAttribute("majorId",majorId);
                //添加专业文档id - 文档id为唯一值
                mn.setMajorid(majorId);
                mt.setMajorid(majorId);
                //添加创建人id
                mn.setCreateId(user.getId());
                mt.setCreateId(user.getId());
                //判断是否成功
                boolean isSuccess1 = iMajorNumberService.save(mn);
                boolean isSuccess2 = iMajorTextService.save(mt);
                //保存成功
                return new ResultInfo<List<String>>((isSuccess1 && isSuccess2) ? 200 : 400, (isSuccess1 && isSuccess2) ? "保存成功" : "保存失败", null);
            }else {
                //获取专业文档id
                Integer majorId = sessionMajorId;
                //添加更新条件
                UpdateWrapper<MajorNumber> majorNumberUpdateWrapper = new UpdateWrapper();
                UpdateWrapper<MajorText> majorTextUpdateWrapper = new UpdateWrapper();
                //添加创建人id
                mn.setCreateId(user.getId());
                mt.setCreateId(user.getId());
                //更新条件 - 通过专业文档id更新
//                majorNumberUpdateWrapper.set("majorId",majorId);
                majorNumberUpdateWrapper.eq("majorId",majorId);
//                majorTextUpdateWrapper.set("majorId",majorId);
                majorTextUpdateWrapper.eq("majorId",majorId);
                //修改专业数据   判断更新是否成功
                boolean isSuccess1 = iMajorNumberService.update(mn,majorNumberUpdateWrapper);
                boolean isSuccess2 = iMajorTextService.update(mt,majorTextUpdateWrapper);
                //保存成功
                return new ResultInfo<List<String>>((isSuccess1 && isSuccess2) ? 200 : 400, (isSuccess1 && isSuccess2) ? "保存成功" : "保存失败", null);
            }
//            MajorNumberWapper majorNumberWapper = new MajorNumberWapper();
//            MajorTextWapper majorTextWapper = new MajorTextWapper();
//            majorNumberWapper.setCreateId(user.getId());
//            majorTextWapper.setCreateId(user.getId());
//            Optional<MajorNumber> d1 = Optional.ofNullable(iMajorNumberService.getOne(majorNumberWapper));
//            Optional<MajorText> d2 = Optional.ofNullable(iMajorTextService.getOne(majorTextWapper));
//            //判断是否有该数据
//            if (d1.isPresent()) {
//                return new ResultInfo<List<String>>(400, "数据已存在，无法保存", null);
//            }
//            if(d2.isPresent()) {
//                return new ResultInfo<List<String>>(400, "数据已存在，无法保存", null);
//            }



    }
}
