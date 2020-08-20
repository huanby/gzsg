package net.webset.wapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.webset.entity.MajorText;

/**
 * 专业数据文本类型Mybatis-plus插件Wrapper类
 * @author hby
 * create date: 2020-08-18
 */
public class MajorTextWapper extends QueryWrapper<MajorText>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer createId;

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
		if (this.createId != null) {
			this.eq(MajorText.CREATEID, this.createId);
		}
	}

	
	
}
