package net.webset.service.impl;

import net.webset.entity.Score;
import net.webset.mapper.ScoreMapper;
import net.webset.service.IScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 梁雪峰
 * @since 2020-08-21
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

}
