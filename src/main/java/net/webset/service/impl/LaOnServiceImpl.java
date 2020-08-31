package net.webset.service.impl;

import net.webset.entity.LaOn;
import net.webset.entity.Score;
import net.webset.mapper.LaOnMapper;
import net.webset.mapper.ScoreMapper;
import net.webset.service.ILaOnService;
import net.webset.wapper.LaOnWapper;
import net.webset.wapper.ScoreWapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 梁雪峰
 * @since 2020-08-20
 */
@Service
public class LaOnServiceImpl extends ServiceImpl<LaOnMapper, LaOn> implements ILaOnService {

	@Autowired 
	private ScoreMapper scoreMapper;
	
	@Autowired
	private LaOnMapper laOnMapper;
	
	@Transactional
	public boolean syncScoreAndLaOn(Score sc) {
		//同步评分总数
		ScoreWapper sw = new ScoreWapper();
		sw.select(Score.USERID+" as user_id,sum("+Score.SCORE+") as score_end").
			eq(Score.USERID, sc.getUserId()).groupBy(true, Score.USERID);
		Score sr = scoreMapper.selectOne(sw);
		LaOnWapper low = new LaOnWapper();
		low.setCreateId(sc.getUserId());
		LaOn la = laOnMapper.selectOne(low);
		if(la == null) {
			la = new LaOn();
			la.setCreateId(sc.getUserId());
			laOnMapper.insert(la);
		}
		la.setScoreEnd(sr.getScoreEnd());
		Integer success = laOnMapper.updateById(la);
		return success > 0 ;
	}

}
