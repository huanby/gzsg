package net.webset.wapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.webset.entity.MajorText;
import net.webset.entity.SchoolData;
import net.webset.entity.User;
import net.webset.util.Utils;
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

	private String t2;

	private String t23;

	private Integer createId;

	private String majorTextName;

	private String sort;

	private String sortOrder;


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

	public void setT1(String t1) {
		this.t1 = t1;
		if (StringUtils.isNotBlank(this.t1)) {
			this.like(MajorText.T1, this.t1);
		}
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
		if (StringUtils.isNotBlank(this.t2)) {
			this.like(MajorText.T2, this.t2);
		}
	}

	public String getT23() {
		return t23;
	}

	public void setT23(String t23) {
		this.t23 = t23;
		if (StringUtils.isNotBlank(this.t23)) {
			this.like(MajorText.T23, this.t23);
		}
	}

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
		if (this.createId != null) {
			this.eq(MajorText.CREATEID, this.createId);
		}
	}


	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
		this.initOrder();
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
		this.initOrder();
	}

	//升降序操作。
	public void initOrder() {
		if(StringUtils.isNoneBlank(this.sort) && StringUtils.isNoneBlank(this.sortOrder)) {
			Object clumn = "";
			String[] fild = Utils.getFiledName(new MajorText());
			for(String f : fild) {
				if(f.equals(this.sort.toUpperCase())) {
					clumn = Utils.getFieldValueByName(f,MajorText.class);
				}
			}
			this.orderBy(true, "asc".equals(this.sortOrder), new String[] {clumn.toString()});
		}

	}



}
