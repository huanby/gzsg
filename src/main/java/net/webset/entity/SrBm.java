package net.webset.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.data.annotation.Id;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import net.webset.util.options.Add;
import net.webset.util.options.Update;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁雪峰
 * @since 2020-08-19
 */
@TableName(value = "b_sr_bm",resultMap = "SrBmMap")
public class SrBm extends Model<SrBm> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(message = "未找到该数据",groups = {Update.class})
    @Null(message = "该数据已存在",groups = {Add.class})
    private Integer id;

    /**
     * 创建者ID
     */
    @TableField("create_id")
    private Integer createId;
    
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * X1.本学校年生均财政拨款水平（万元）
     */
    @TableField("x1")
    @NotNull(message = "本学校年生均财政拨款水平（万元）不能为空",groups = {Add.class})
    private BigDecimal x1;

    /**
     * X2.2017年学校总收入（万元）
     */
    @TableField("x2")
    @NotNull(message = "2017年学校总收入（万元）不能为空",groups = {Add.class})
    private BigDecimal x2;

    /**
     * X3.2017年学校总支出（万元）
     */
    @TableField("x3")
    @NotNull(message = "2017年学校总支出（万元）不能为空",groups = {Add.class})
    private BigDecimal x3;

    /**
     * X4.2018年学校总收入（万元）
     */
    @TableField("x4")
    @NotNull(message = "2018年学校总收入（万元）不能为空",groups = {Add.class})
    private BigDecimal x4;

    /**
     * X5.2018年学校总支出（万元）
     */
    @TableField("x5")
    @NotNull(message = "2018年学校总支出（万元）不能为空",groups = {Add.class})
    private BigDecimal x5;

    /**
     * X6.2019年学校总收入（万元）
     */
    @TableField("x6")
    @NotNull(message = "2019年学校总收入（万元）不能为空",groups = {Add.class})
    private BigDecimal x6;

    /**
     * X7.2019年学校总支出（万元）
     */
    @TableField("x7")
    @NotNull(message = "2019年学校总支出（万元）不能为空",groups = {Add.class})
    private BigDecimal x7;

    /**
     * X8.学校办学条件高于专科高职学校设置标准
     */
    @TableField("x8")
    @NotNull(message = "请选择学校办学条件高于专科高职学校设置标准【是-否】",groups = {Add.class})
    private Boolean x8;

    /**
     * X9.年生均财政拨款水平达到国家统一要求
     */
    @TableField("x9")
    @NotNull(message = "请选择年生均财政拨款水平达到国家统一要求【是-否】",groups = {Add.class})
    private Boolean x9;

    /**
     * X10.校园网全覆盖
     */
    @TableField("x10")
    @NotNull(message = "请选择校园网全覆盖【是-否】",groups = {Add.class})
    private Boolean x10;

    /**
     * X11.有三届以上全日制普通专科（三年制）毕业生
     */
    @TableField("x11")
    @NotNull(message = "请选择有三届以上全日制普通专科（三年制）毕业生【是-否】",groups = {Add.class})
    private Boolean x11;

    /**
     * X12.重点建设专业群的全日制在校生规模在800人以上
     */
    @TableField("x12")
    @NotNull(message = "请选择重点建设专业群的全日制在校生规模在800人以上【是-否】",groups = {Add.class})
    private Boolean x12;

    /**
     * X13.学校师生在校期间获得过省级教学成果一等及以上奖
     */
    @TableField("x13")
    @NotNull(message = "请选择学校师生在校期间获得过省级教学成果一等及以上奖【是-否】",groups = {Add.class})
    private Boolean x13;

    /**
     * X14.学校师生在校期间获得过吉林省高等职业院校技能大赛一等奖
     */
    @TableField("x14")
    @NotNull(message = "请选择学校师生在校期间获得过吉林省高等职业院校技能大赛一等奖【是-否】",groups = {Add.class})
    private Boolean x14;

    /**
     * X15.2016年以来，学校（单位或现任主要领导）没有因违纪违法受到处分的情况
     */
    @TableField("x15")
    @NotNull(message = "请选择2016年以来，学校（单位或现任主要领导）没有因违纪违法受到处分的情况【是-否】",groups = {Add.class})
    private Boolean x15;

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCreateId() {
        return createId;
    }
    
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }
    public Date getCreateTime() {
		return createTime;
	}
    
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public BigDecimal getX1() {
        return x1;
    }

    public void setX1(BigDecimal x1) {
        this.x1 = x1;
    }
    public BigDecimal getX2() {
        return x2;
    }

    public void setX2(BigDecimal x2) {
        this.x2 = x2;
    }
    public BigDecimal getX3() {
        return x3;
    }

    public void setX3(BigDecimal x3) {
        this.x3 = x3;
    }
    public BigDecimal getX4() {
        return x4;
    }

    public void setX4(BigDecimal x4) {
        this.x4 = x4;
    }
    public BigDecimal getX5() {
        return x5;
    }

    public void setX5(BigDecimal x5) {
        this.x5 = x5;
    }
    public BigDecimal getX6() {
        return x6;
    }

    public void setX6(BigDecimal x6) {
        this.x6 = x6;
    }
    public BigDecimal getX7() {
        return x7;
    }

    public void setX7(BigDecimal x7) {
        this.x7 = x7;
    }
    public Boolean getX8() {
        return x8;
    }

    public void setX8(Boolean x8) {
        this.x8 = x8;
    }
    public Boolean getX9() {
        return x9;
    }

    public void setX9(Boolean x9) {
        this.x9 = x9;
    }
    public Boolean getX10() {
        return x10;
    }

    public void setX10(Boolean x10) {
        this.x10 = x10;
    }
    public Boolean getX11() {
        return x11;
    }

    public void setX11(Boolean x11) {
        this.x11 = x11;
    }
    public Boolean getX12() {
        return x12;
    }

    public void setX12(Boolean x12) {
        this.x12 = x12;
    }
    public Boolean getX13() {
        return x13;
    }

    public void setX13(Boolean x13) {
        this.x13 = x13;
    }
    public Boolean getX14() {
        return x14;
    }

    public void setX14(Boolean x14) {
        this.x14 = x14;
    }
    public Boolean getX15() {
        return x15;
    }

    public void setX15(Boolean x15) {
        this.x15 = x15;
    }

    public static final String ID = "id";

    public static final String CREATEID = "create_id";
    
    public static final String CREATETIME = "create_time";

    public static final String X1 = "x1";

    public static final String X2 = "x2";

    public static final String X3 = "x3";

    public static final String X4 = "x4";

    public static final String X5 = "x5";

    public static final String X6 = "x6";

    public static final String X7 = "x7";

    public static final String X8 = "x8";

    public static final String X9 = "x9";

    public static final String X10 = "x10";

    public static final String X11 = "x11";

    public static final String X12 = "x12";

    public static final String X13 = "x13";

    public static final String X14 = "x14";

    public static final String X15 = "x15";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SrBm{" +
        "id=" + id +
        ", createId=" + createId +
        ", createTime=" + createTime +
        ", x1=" + x1 +
        ", x2=" + x2 +
        ", x3=" + x3 +
        ", x4=" + x4 +
        ", x5=" + x5 +
        ", x6=" + x6 +
        ", x7=" + x7 +
        ", x8=" + x8 +
        ", x9=" + x9 +
        ", x10=" + x10 +
        ", x11=" + x11 +
        ", x12=" + x12 +
        ", x13=" + x13 +
        ", x14=" + x14 +
        ", x15=" + x15 +
        "}";
    }
}
