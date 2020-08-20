package net.webset.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import net.webset.entity.MajorNumber;
import net.webset.entity.MajorText;
import net.webset.entity.User;
import net.webset.service.IMajorInfoService;
import net.webset.service.IMajorNumberService;
import net.webset.service.IMajorTextService;
import net.webset.util.ResultInfo;
import net.webset.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

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
     * 保存专业填报数据信息
     * @param mn
     * @param mt
     * @param result
     * @return
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
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
                majorNumberUpdateWrapper.eq("majorId",majorId);
                majorTextUpdateWrapper.eq("majorId",majorId);
                //修改专业数据   判断更新是否成功
                boolean isSuccess1 = iMajorNumberService.update(mn,majorNumberUpdateWrapper);
                boolean isSuccess2 = iMajorTextService.update(mt,majorTextUpdateWrapper);
                //保存成功
                return new ResultInfo<List<String>>((isSuccess1 && isSuccess2) ? 200 : 400, (isSuccess1 && isSuccess2) ? "保存成功" : "保存失败", null);
            }
    }

    /**
     * 通过majorId删除专业数据文档
     * @param majorId
     * @return
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Boolean majorDel(Integer majorId) {
        //删除条件
        QueryWrapper<MajorText> majorTextQueryWrapper = new QueryWrapper<>();
        QueryWrapper<MajorNumber> majorNumberQueryWrapper = new QueryWrapper<>();
        //通过majorId删除数据
        majorTextQueryWrapper.eq("majorid",majorId);
        majorNumberQueryWrapper.eq("majorid",majorId);
        //判断是否删除成功
        boolean isDel1 = iMajorTextService.remove(majorTextQueryWrapper);
        boolean isDel2 = iMajorNumberService.remove(majorNumberQueryWrapper);
        //返回结果
        return (isDel1 && isDel2);
    }
}
