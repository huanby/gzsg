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
 * 师资队伍和教学资源
 * </p>
 *
 * @author 梁雪峰
 * @since 2020-08-18
 */
@TableName(value = "b_ts_tr",resultMap = "TsTrMap")
public class TsTr extends Model<TsTr> {

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
     * 创建人ID
     */
    @TableField("create_id")
    private Integer createId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * S1.生师比（X:1）
     */
    @TableField("s1")
    @NotNull(message = "生师比（X:1）不能为空",groups = {Add.class})
    private BigDecimal s1;

    /**
     * S2.国家级高层次人才数（人）
     */
    @TableField("s2")
    @NotNull(message = "国家级高层次人才数（人）不能为空",groups = {Add.class})
    private Integer s2;

    /**
     * S3.省级人才数（人）
     */
    @TableField("s3")
    @NotNull(message = "省级人才数（人）不能为空",groups = {Add.class})
    private Integer s3;

    /**
     * S4.国家级高层次教学、研究团队数 （个）
     */
    @TableField("s4")
    @NotNull(message = "国家级高层次教学、研究团队数 （个）不能为空",groups = {Add.class})
    private Integer s4;

    /**
     * S5.省级教学、研究团队数（个）
     */
    @TableField("s5")
    @NotNull(message = "S5.省级教学、研究团队数（个）不能为空",groups = {Add.class})
    private Integer s5;



    /**
     * S6.省级教学、研究团队数（个）
     */
    @TableField("s6")
    @NotNull(message = "S6.教师获国家级奖励数（项）不能为空",groups = {Add.class})
    private Integer s6;

    /**
     * S8.具有国（境）外学习工作经历的专任教师占比（%）
     */
    @TableField("s7")
    @NotNull(message = "硕士及以上学位专任教师占比（%）不能为空",groups = {Add.class})
    private BigDecimal s7;

    /**
     * S8.具有国（境）外学习工作经历的专任教师占比（%）
     */
    @TableField("s8")
    @NotNull(message = "具有国（境）外学习工作经历的专任教师占比（%）不能为空",groups = {Add.class})
    private BigDecimal s8;

    /**
     * S9.双师型专任教师占比（%）
     */
    @TableField("s9")
    @NotNull(message = "双师型专任教师占比（%）不能为空",groups = {Add.class})
    private BigDecimal s9;

    /**
     * S10.企业兼职教师占比（%）
     */
    @TableField("s10")
    @NotNull(message = "企业兼职教师占比（%）不能为空",groups = {Add.class})
    private BigDecimal s10;

    /**
     * S11.专业教师人均企业实践时间（天/人）
     */
    @TableField("s11")
    @NotNull(message = "专业教师人均企业实践时间（天/人）不能为空",groups = {Add.class})
    private BigDecimal s11;

    /**
     * S12.实践课时占比（%）
     */
    @TableField("s12")
    @NotNull(message = "实践课时占比（%）不能为空",groups = {Add.class})
    private BigDecimal s12;

    /**
     * S13.公开出版的校企合作教材数（种）
     */
    @TableField("s13")
    @NotNull(message = "公开出版的校企合作教材数（种）不能为空",groups = {Add.class})
    private Integer s13;

    /**
     * S14.国家级规划教材、精品教材数（种）
     */
    @TableField("s14")
    @NotNull(message = "国家级规划教材、精品教材数（种）不能为空",groups = {Add.class})
    private Integer s14;

    /**
     * S15.省部级规划教材、精品教材数（种）
     */
    @TableField("s15")
    @NotNull(message = "省部级规划教材、精品教材数（种）不能为空",groups = {Add.class})
    private Integer s15;

    /**
     * S16.省部级教学资源库开发数量（个）
     */
    @TableField("s16")
    @NotNull(message = "省部级教学资源库开发数量（个）不能为空",groups = {Add.class})
    private Integer s16;

    /**
     * S17.生均图书流通量（次/人）
     */
    @TableField("s17")
    @NotNull(message = "生均图书流通量、生均电子资源访问量（次/人）不能为空",groups = {Add.class})
    private BigDecimal s17;

    /**
     * S60.生均电子资源访问量（次/人）
     */
    @TableField("s60")
    @NotNull(message = "生均电子资源访问量（次/人）不能为空",groups = {Add.class})
    private BigDecimal s60;

    /**
     * S18.省级以上实习实训基地数（个）
     */
    @TableField("s18")
    @NotNull(message = "省级以上实习实训基地数（个）不能为空",groups = {Add.class})
    private Integer s18;

    /**
     * S19.产学研合作项目（基地）数（个）
     */
    @TableField("s19")
    @NotNull(message = "产学研合作项目（基地）数（个）不能为空",groups = {Add.class})
    private String s19;

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
    public BigDecimal getS1() {
        return s1;
    }

    public void setS1(BigDecimal s1) {
        this.s1 = s1;
    }
    public Integer getS2() {
        return s2;
    }

    public void setS2(Integer s2) {
        this.s2 = s2;
    }
    public Integer getS3() {
        return s3;
    }

    public void setS3(Integer s3) {
        this.s3 = s3;
    }
    public Integer getS4() {
        return s4;
    }

    public void setS4(Integer s4) {
        this.s4 = s4;
    }
    public Integer getS5() {
        return s5;
    }

    public void setS5(Integer s5) {
        this.s5 = s5;
    }
    public BigDecimal getS8() {
        return s8;
    }

    public void setS8(BigDecimal s8) {
        this.s8 = s8;
    }
    public BigDecimal getS9() {
        return s9;
    }

    public void setS9(BigDecimal s9) {
        this.s9 = s9;
    }
    public BigDecimal getS10() {
        return s10;
    }

    public void setS10(BigDecimal s10) {
        this.s10 = s10;
    }
    public BigDecimal getS11() {
        return s11;
    }

    public void setS11(BigDecimal s11) {
        this.s11 = s11;
    }
    public BigDecimal getS12() {
        return s12;
    }

    public void setS12(BigDecimal s12) {
        this.s12 = s12;
    }
    public Integer getS13() {
        return s13;
    }

    public void setS13(Integer s13) {
        this.s13 = s13;
    }
    public Integer getS14() {
        return s14;
    }

    public void setS14(Integer s14) {
        this.s14 = s14;
    }
    public Integer getS15() {
        return s15;
    }

    public void setS15(Integer s15) {
        this.s15 = s15;
    }
    public Integer getS16() {
        return s16;
    }

    public void setS16(Integer s16) {
        this.s16 = s16;
    }
    public BigDecimal getS17() {
        return s17;
    }

    public void setS17(BigDecimal s17) {
        this.s17 = s17;
    }
    public Integer getS18() {
        return s18;
    }

    public void setS18(Integer s18) {
        this.s18 = s18;
    }
    public String getS19() {
        return s19;
    }

    public void setS19(String s19) {
        this.s19 = s19;
    }

    public BigDecimal getS60() {
        return s60;
    }

    public void setS60(BigDecimal s60) {
        this.s60 = s60;
    }

    public Integer getS6() {
        return s6;
    }

    public void setS6(Integer s6) {
        this.s6 = s6;
    }

    public BigDecimal getS7() {
        return s7;
    }

    public void setS7(BigDecimal s7) {
        this.s7 = s7;
    }

    public static final String ID = "id";

    public static final String CREATEID = "create_id";

    public static final String CREATETIME = "create_time";

    public static final String S1 = "s1";

    public static final String S2 = "s2";

    public static final String S3 = "s3";

    public static final String S4 = "s4";

    public static final String S5 = "s5";

    public static final String S8 = "s8";

    public static final String S9 = "s9";

    public static final String S10 = "s10";

    public static final String S11 = "s11";

    public static final String S12 = "s12";

    public static final String S13 = "s13";

    public static final String S14 = "s14";

    public static final String S15 = "s15";

    public static final String S16 = "s16";

    public static final String S17 = "s17";

    public static final String S18 = "s18";

    public static final String S19 = "s19";

    public static final String S60 = "s60";

    public static final String S6 = "s6";

    public static final String S7 = "s7";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TsTr{" +
        "id=" + id +
        ", createId=" + createId +
        ", createTime=" + createTime +
        ", s1=" + s1 +
        ", s2=" + s2 +
        ", s3=" + s3 +
        ", s4=" + s4 +
        ", s5=" + s5 +
        ", s8=" + s8 +
        ", s9=" + s9 +
        ", s10=" + s10 +
        ", s11=" + s11 +
        ", s12=" + s12 +
        ", s13=" + s13 +
        ", s14=" + s14 +
        ", s15=" + s15 +
        ", s16=" + s16 +
        ", s17=" + s17 +
        ", s18=" + s18 +
        ", s19=" + s19 +
        "}";
    }
}
