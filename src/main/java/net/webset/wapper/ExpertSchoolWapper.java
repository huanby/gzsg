package net.webset.wapper;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import net.webset.view.ExpertSchool;

public class ExpertSchoolWapper extends QueryWrapper<ExpertSchool> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer createId;
	
	private String schoolName;
	
	private String leName;
	
	private Integer score;
	
	private Integer examId;
	
	private String sort;
	
	private String sortOrder;

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
		if (this.createId != null) {
			this.eq(ExpertSchool.CREATEID, this.createId);
		}
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
		if (StringUtils.isNotBlank(this.schoolName)) {
			this.like(ExpertSchool.SCHOOLNAME, this.schoolName);
		}
	}

	public String getLeName() {
		return leName;
	}

	public void setLeName(String leName) {
		this.leName = leName;
		if (StringUtils.isNotBlank(this.leName)) {
			this.like(ExpertSchool.LENAME, this.leName);
		}
	}
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
		if (this.score != null) {
			this.eq(ExpertSchool.SCORE, this.score);
		}
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
		if (this.examId != null) {
			this.eq(ExpertSchool.EXAMID, this.examId);
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
			Field[] fields = ExpertSchool.class.getDeclaredFields();
			for(Field f : fields) {
				if(f.getName().equals(this.sort)) {
					this.orderBy(true, "asc".equals(this.sortOrder),f.getAnnotation(TableField.class).value());
				}
			}
		}
	}
}
