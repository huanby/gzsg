package net.webset.wapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import net.webset.entity.SchoolData;

public class SchoolDataWapper extends QueryWrapper<SchoolData>  {

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
			this.eq(SchoolData.CREATEID, this.createId);
		}
	}
	
	
}
