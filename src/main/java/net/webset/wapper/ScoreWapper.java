package net.webset.wapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import net.webset.entity.Score;

public class ScoreWapper extends QueryWrapper<Score> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Integer examId;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
		if (this.userId != null) {
			this.eq(Score.USERID, this.userId);
		}
	}
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
		if (this.examId != null) {
			this.eq(Score.EXAMID, this.examId);
		}
	}
	

}
