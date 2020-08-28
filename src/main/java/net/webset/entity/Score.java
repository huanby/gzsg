package net.webset.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import net.webset.util.options.Add;
import net.webset.util.options.Update;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.data.annotation.Id;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁雪峰
 * @since 2020-08-21
 */
@TableName(value = "b_score",resultMap = "scoreMap")
public class Score extends Model<Score> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
	@TableId(value = ID,type=IdType.AUTO)
	@Null(message = "该数据已存在",groups = {Add.class})
	@NotNull(message = "数据不存在",groups = {Update.class})
    private Integer id;

    /**
     * 评分结果
     */
    @TableField("score")
    @NotNull(message = "评分结果不能为空", groups = {Add.class})
    private Integer score;

    /**
     * 评价对象ID
     */
    @TableField("user_id")
    @NotNull(message = "评分对象不存在", groups = {Add.class})
    private Integer userId;

    /**
     * 评分结果ID
     */
    @TableField("exam_id")
    private Integer examId;
    
    /**
     * 评价说明
     */
    @TableField("remark")
    @NotBlank(message = "评分说明不能为空", groups = {Add.class})
    private String remark;
    
    /**
     * 评分结果
     */
    @TableField("score_end")
    private BigDecimal scoreEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
	public BigDecimal getScoreEnd() {
		return scoreEnd;
	}

	public void setScoreEnd(BigDecimal scoreEnd) {
		this.scoreEnd = scoreEnd;
	}

	public static final String ID = "id";

    public static final String SCORE = "score";

    public static final String USERID = "user_id";

    public static final String EXAMID = "exam_id";
    
    public static final String REMARK = "remark";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Score{" +
        "id=" + id +
        ", score=" + score +
        ", userId=" + userId +
        ", examId=" + examId +
        ", remark=" + remark +
        "}";
    }
}
