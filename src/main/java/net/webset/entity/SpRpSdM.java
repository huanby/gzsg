package net.webset.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import net.webset.util.options.Add;
import net.webset.util.options.Update;

import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.data.annotation.Id;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁雪峰
 * @since 2020-08-18
 */
@TableName(value = "b_sp_rp_sd_m",resultMap = "SpRpSdMMap")
public class SpRpSdM extends Model<SpRpSdM> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @NotNull(message = "未找到该数据",groups = {Update.class})
    @Null(message = "该数据已存在",groups = {Add.class})
    @TableId(value = "id", type = IdType.AUTO)
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
     * S20.国家级现代学徒制试点（个）
     */
    @TableField("s20")
    @NotNull(message = "国家级现代学徒制试点（个）不能为空",groups = {Add.class})
    private Integer s20;

    /**
     * S21.省级现代学徒制试点（个）
     */
    @TableField("s21")
    @NotNull(message = "省级现代学徒制试点（个）不能为空",groups = {Add.class})
    private Integer s21;

    /**
     * S22.省级及以上三全育人综合改革试点（个）
     */
    @TableField("s22")
    @NotNull(message = "省级及以上三全育人综合改革试点（个）不能为空",groups = {Add.class})
    private Integer s22;

    /**
     * S23.省级及以上教学工作诊断与改进工作试点（个）
     */
    @TableField("s23")
    @NotNull(message = "省级及以上教学工作诊断与改进工作试点（个）不能为空",groups = {Add.class})
    private Integer s23;

    /**
     * S24.国家级创新创业教育示范基地数（个）
     */
    @TableField("s24")
    @NotNull(message = "国家级创新创业教育示范基地数（个）不能为空",groups = {Add.class})
    private Integer s24;

    /**
     * S25.省部级创新创业教育示范基地数（个）
     */
    @TableField("s25")
    @NotNull(message = "省部级创新创业教育示范基地数（个）不能为空",groups = {Add.class})
    private Integer s25;

    /**
     * S26.省级示范性实习实训基地（个）
     */
    @TableField("s26")
    @NotNull(message = "省级示范性实习实训基地（个）不能为空",groups = {Add.class})
    private Integer s26;

    /**
     * S27.师均科研经费（万元/人）
     */
    @TableField("s27")
    @NotNull(message = "师均科研经费（万元/人）不能为空",groups = {Add.class})
    private BigDecimal s27;

    /**
     * S28.师均新增省部级科研项目数（个/人）
     */
    @TableField("s28")
    @NotNull(message = "师均新增省部级科研项目数（个/人）不能为空",groups = {Add.class})
    private BigDecimal s28;

    /**
     * S29.师均企事业委托项目数（个/人）
     */
    @TableField("s29")
    @NotNull(message = "师均企事业委托项目数（个/人）不能为空",groups = {Add.class})
    private BigDecimal s29;

    /**
     * S30.高级职称人员、技术技能大师为学生授课比例（%）
     */
    @TableField("s30")
    @NotNull(message = "高级职称人员、技术技能大师为学生授课比例（%）不能为空",groups = {Add.class})
    private BigDecimal s30;

    /**
     * S31.学生在国家级竞赛中获得奖励数（项）
     */
    @TableField("s31")
    @NotNull(message = "学生在国家级竞赛中获得奖励数（项）不能为空",groups = {Add.class})
    private Integer s31;

    /**
     * S32.学生在省级竞赛中获得奖励数（项）
     */
    @TableField("s32")
    @NotNull(message = "学生在省级竞赛中获得奖励数（项）不能为空",groups = {Add.class})
    private Integer s32;

    /**
     * S33.学生初次就业率（%）
     */
    @TableField("s33")
    @NotNull(message = "学生初次就业率（%）不能为空",groups = {Add.class})
    private BigDecimal s33;

    /**
     * S34.学生本省就业率（%）
     */
    @TableField("s34")
    @NotNull(message = "学生本省就业率（%）不能为空",groups = {Add.class})
    private BigDecimal s34;

    /**
     * S35.国家级特色高水平专业数（个）
     */
    @TableField("s35")
    @NotNull(message = "国家级特色高水平专业数（个）不能为空",groups = {Add.class})
    private Integer s35;

    /**
     * S36.国家级重点专业数（个）
     */
    @TableField("s36")
    @NotNull(message = "国家级重点专业数（个）不能为空",groups = {Add.class})
    private Integer s36;

    /**
     * S37.国家级优质（骨干）专业数（个）
     */
    @TableField("s37")
    @NotNull(message = "国家级优质（骨干）专业数（个）不能为空",groups = {Add.class})
    private Integer s37;

    /**
     * S38.入选“特色高水平专业（群）”数（个）
     */
    @TableField("s38")
    @NotNull(message = "入选“特色高水平专业（群）”数（个）不能为空",groups = {Add.class})
    private Integer s38;

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
    public Integer getS20() {
        return s20;
    }

    public void setS20(Integer s20) {
        this.s20 = s20;
    }
    public Integer getS21() {
        return s21;
    }

    public void setS21(Integer s21) {
        this.s21 = s21;
    }
    public Integer getS22() {
        return s22;
    }

    public void setS22(Integer s22) {
        this.s22 = s22;
    }
    public Integer getS23() {
        return s23;
    }

    public void setS23(Integer s23) {
        this.s23 = s23;
    }
    public Integer getS24() {
        return s24;
    }

    public void setS24(Integer s24) {
        this.s24 = s24;
    }
    public Integer getS25() {
        return s25;
    }

    public void setS25(Integer s25) {
        this.s25 = s25;
    }
    public Integer getS26() {
        return s26;
    }

    public void setS26(Integer s26) {
        this.s26 = s26;
    }
    public BigDecimal getS27() {
        return s27;
    }

    public void setS27(BigDecimal s27) {
        this.s27 = s27;
    }
    public BigDecimal getS28() {
        return s28;
    }

    public void setS28(BigDecimal s28) {
        this.s28 = s28;
    }
    public BigDecimal getS29() {
        return s29;
    }

    public void setS29(BigDecimal s29) {
        this.s29 = s29;
    }
    public BigDecimal getS30() {
        return s30;
    }

    public void setS30(BigDecimal s30) {
        this.s30 = s30;
    }
    public Integer getS31() {
        return s31;
    }

    public void setS31(Integer s31) {
        this.s31 = s31;
    }
    public Integer getS32() {
        return s32;
    }

    public void setS32(Integer s32) {
        this.s32 = s32;
    }
    public BigDecimal getS33() {
        return s33;
    }

    public void setS33(BigDecimal s33) {
        this.s33 = s33;
    }
    public BigDecimal getS34() {
        return s34;
    }

    public void setS34(BigDecimal s34) {
        this.s34 = s34;
    }
    public Integer getS35() {
        return s35;
    }

    public void setS35(Integer s35) {
        this.s35 = s35;
    }
    public Integer getS36() {
        return s36;
    }

    public void setS36(Integer s36) {
        this.s36 = s36;
    }
    public Integer getS37() {
        return s37;
    }

    public void setS37(Integer s37) {
        this.s37 = s37;
    }
    public Integer getS38() {
        return s38;
    }

    public void setS38(Integer s38) {
        this.s38 = s38;
    }

    public static final String ID = "id";

    public static final String CREATE_ID = "create_id";

    public static final String CREATE_TIME = "create_time";

    public static final String S20 = "s20";

    public static final String S21 = "s21";

    public static final String S22 = "s22";

    public static final String S23 = "s23";

    public static final String S24 = "s24";

    public static final String S25 = "s25";

    public static final String S26 = "s26";

    public static final String S27 = "s27";

    public static final String S28 = "s28";

    public static final String S29 = "s29";

    public static final String S30 = "s30";

    public static final String S31 = "s31";

    public static final String S32 = "s32";

    public static final String S33 = "s33";

    public static final String S34 = "s34";

    public static final String S35 = "s35";

    public static final String S36 = "s36";

    public static final String S37 = "s37";

    public static final String S38 = "s38";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SpRpSdM{" +
        "id=" + id +
        ", createId=" + createId +
        ", createTime=" + createTime +
        ", s20=" + s20 +
        ", s21=" + s21 +
        ", s22=" + s22 +
        ", s23=" + s23 +
        ", s24=" + s24 +
        ", s25=" + s25 +
        ", s26=" + s26 +
        ", s27=" + s27 +
        ", s28=" + s28 +
        ", s29=" + s29 +
        ", s30=" + s30 +
        ", s31=" + s31 +
        ", s32=" + s32 +
        ", s33=" + s33 +
        ", s34=" + s34 +
        ", s35=" + s35 +
        ", s36=" + s36 +
        ", s37=" + s37 +
        ", s38=" + s38 +
        "}";
    }
}
