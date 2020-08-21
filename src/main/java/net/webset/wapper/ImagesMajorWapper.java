package net.webset.wapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.webset.entity.Images;
import net.webset.entity.ImagesMajor;

public class ImagesMajorWapper extends QueryWrapper<ImagesMajor> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer majorId;

	private Integer createId;


	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
		if (this.majorId != null) {
			this.eq(ImagesMajor.MAJORID, this.majorId);
		}
	}

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
		if (this.createId != null) {
			this.eq(Images.CREATE_ID, this.createId);
		}
	}

}
