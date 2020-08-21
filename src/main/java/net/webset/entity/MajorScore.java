package net.webset.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * 专业数据评分实体类
 * @author hby
 * create date: 2020-08-21
 */
@TableName(value= "b_major_score",resultMap="MajorScoreMap")
public class MajorScore extends Model<MajorScore> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId("id")
    private Integer id;

    /**
     * 专业文档id
     */
    @TableField("majorId")
    private Integer majorId;

    /**
     * 评价者ID
     */
    @TableField("create_id")
    private Integer createId;

    /**
     * 得分
     */
    @TableField("score")
    private Double score;

    /**
     * 是否删除：0：未删除、1：删除
     */
    @TableField("isdel")
    private Integer isdel;

    /**
     * 创建时间
     */
    @TableField("createtime")
    private LocalDateTime createtime;

    /**
     * 更新时间
     */
    @TableField("updatetime")
    private LocalDateTime updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }
    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }
    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }

    public static final String ID = "id";

    public static final String MAJORID = "majorId";

    public static final String CREATE_ID = "create_id";

    public static final String SCORE = "score";

    public static final String ISDEL = "isdel";

    public static final String CREATETIME = "createtime";

    public static final String UPDATETIME = "updatetime";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MajorScore{" +
        "id=" + id +
        ", majorId=" + majorId +
        ", createId=" + createId +
        ", score=" + score +
        ", isdel=" + isdel +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        "}";
    }
}
