package net.webset.wapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.webset.entity.MajorNumber;

/**
 * 专业数据数值类型Mybatis-plus插件Wrapper类
 * @author hby
 * create date: 2020-08-18
 */
public class MajorNumberWapper extends QueryWrapper<MajorNumber>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer createId;

	private Integer majorid;

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
		if (this.createId != null) {
			this.eq(MajorNumber.CREATEID, this.createId);
		}
	}

	public Integer getMajorid() {
		return majorid;
	}

	public void setMajorid(Integer majorid) {
		this.majorid = majorid;
		if (this.majorid != null) {
			this.eq(MajorNumber.MAJORID, this.majorid);
		}
	}
}
