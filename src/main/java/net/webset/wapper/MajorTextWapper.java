package net.webset.wapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.webset.entity.MajorText;
import net.webset.entity.User;
import org.apache.commons.lang3.StringUtils;

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

	private String t1;

	private Integer createId;


	private String majorTextName;

	public String getMajorTextName() {
		return majorTextName;
	}

	public void setMajorTextName(String majorTextName) {
		this.majorTextName = majorTextName;
		if (StringUtils.isNotBlank(this.majorTextName)) {
			this.like(MajorText.T1, this.majorTextName);
		}
	}


	public String getT1() {
		return t1;
	}

	public Integer getCreateId() {
		return createId;
	}


	public void setCreateId(String t1) {
		this.t1 = t1;
		if (StringUtils.isNotBlank(this.t1)) {
			this.like(MajorText.T1, this.t1);
		}
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
		if (this.createId != null) {
			this.eq(MajorText.CREATEID, this.createId);
		}
	}



	
	
}
