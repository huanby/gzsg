package net.webset.wapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.webset.entity.MajorNumber;
import net.webset.util.Utils;
import net.webset.wapper.api.vos.MajorConclusionVO;
import org.apache.commons.lang3.StringUtils;

/**
 * 专业数据数值类型Mybatis-plus插件Wrapper类
 * @author hby
 * create date: 2020-08-18
 */
public class MajorConclusionVOWapper extends QueryWrapper<MajorConclusionVO>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer createId;

	private String sort;

	private String sortOrder;

	private String t1;

	private String t2;

	private String t23;

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
		if (this.createId != null) {
			this.eq(MajorNumber.CREATEID, this.createId);
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
			String[] fild = Utils.getFiledName(new MajorNumber());
			for(String f : fild) {
				if(f.equals(this.sort.toUpperCase())) {
					clumn = Utils.getFieldValueByName(f,MajorNumber.class);
				}
			}
			this.orderBy(true, "asc".equals(this.sortOrder), new String[] {clumn.toString()});
		}

	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public String getT23() {
		return t23;
	}

	public void setT23(String t23) {
		this.t23 = t23;
	}
}
