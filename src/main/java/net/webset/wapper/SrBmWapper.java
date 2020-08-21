package net.webset.wapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import net.webset.entity.SrBm;

public class SrBmWapper extends QueryWrapper<SrBm> {
	
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
			this.eq(SrBm.CREATEID, this.createId);
		}
	}
	

}
