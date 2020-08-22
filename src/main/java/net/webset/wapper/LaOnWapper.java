package net.webset.wapper;

import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import net.webset.entity.LaOn;
import net.webset.util.Utils;

public class LaOnWapper extends QueryWrapper<LaOn> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer createId;
	
	private String sort;
	
	private String sortOrder;

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
		if (this.createId != null) {
			this.eq(LaOn.CREATEID, this.createId);
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
			String[] fild = Utils.getFiledName(new LaOn());
			for(String f : fild) {
				if(f.equals(this.sort.toUpperCase())) {
					clumn = Utils.getFieldValueByName(f,LaOn.class);
				}
			}
			this.orderBy(true, "asc".equals(this.sortOrder), new String[] {clumn.toString()});
		}
		
	}

}
