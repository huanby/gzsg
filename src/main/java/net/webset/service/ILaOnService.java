package net.webset.service;

import net.webset.entity.LaOn;
import net.webset.entity.Score;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 梁雪峰
 * @since 2020-08-20
 */
public interface ILaOnService extends IService<LaOn> {

	public boolean syncScoreAndLaOn(Score sc);

}
