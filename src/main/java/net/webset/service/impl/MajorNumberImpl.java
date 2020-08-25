package net.webset.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.webset.entity.LaOn;
import net.webset.entity.MajorNumber;
import net.webset.entity.MajorScore;
import net.webset.entity.Score;
import net.webset.mapper.MajorNumberMapper;
import net.webset.mapper.MajorScoreMapper;
import net.webset.service.IMajorNumberService;
import net.webset.wapper.LaOnWapper;
import net.webset.wapper.MajorNumberWapper;
import net.webset.wapper.ScoreWapper;
import net.webset.wapper.api.vos.MajorConclusionVO;
import net.webset.wapper.MajorConclusionVOWapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    private MajorScoreMapper majorScoreMapper;


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


    /**
     * 同步评分总数
     * @param majorScore
     * @return
     */
    @Transactional
    public boolean syncScoreAndMajorNumber(MajorScore majorScore) {
        //同步评分总数
        Integer majorId = majorScore.getMajorId();
        QueryWrapper<MajorScore> majorScoreQueryWrapper = new QueryWrapper<>();
        majorScoreQueryWrapper.select(MajorScore.MAJORID+" as majorId,sum("+MajorScore.SCORE+") as score_end").
                eq(MajorScore.MAJORID, majorScore.getMajorId()).groupBy(true, MajorScore.MAJORID);
        //取得专业得分信息
        MajorScore majorScoreEnd = this.majorScoreMapper.selectOne(majorScoreQueryWrapper);
//        Score sr = scoreMapper.selectOne(sw);
        MajorNumberWapper majorNumberWapper = new MajorNumberWapper();
        majorNumberWapper.setMajorid(majorId);
        MajorNumber majorNumber = majorNumberMapper.selectOne(majorNumberWapper);
        //更新专业得分信息
        majorNumber.setScoreEnd(majorScoreEnd.getScoreEnd());
        Integer success = majorNumberMapper.updateById(majorNumber);
        return success > 0 ;
    }

}
