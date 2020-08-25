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

	
	
}
