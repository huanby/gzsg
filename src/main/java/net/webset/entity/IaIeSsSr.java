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
@TableName(value = "b_ia_ie_ss_sr",resultMap = "IaIeSsSrMap")
public class IaIeSsSr extends Model<IaIeSsSr> {

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
     * S39.国家级教学成果奖获奖数（个）
     */
    @TableField("s39")
    @NotNull(message = "国家级教学成果奖获奖数（个）不能为空",groups = {Add.class})
    private Integer s39;

    /**
     * S40.省级教学成果奖获奖数（个）
     */
    @TableField("s40")
    @NotNull(message = "省级教学成果奖获奖数（个）不能为空",groups = {Add.class})
    private Integer s40;

    /**
     * S41.获国家级科研奖项数（个）
     */
    @TableField("s41")
    @NotNull(message = "获国家级科研奖项数（个）不能为空",groups = {Add.class})
    private Integer s41;

    /**
     * S42.获省部级和行业科研奖项数（个）
     */
    @TableField("s42")
    @NotNull(message = "获省部级和行业科研奖项数（个）不能为空",groups = {Add.class})
    private Integer s42;

    /**
     * S43.师均论文数（篇/人）
     */
    @TableField("s43")
    @NotNull(message = "师均论文数（篇/人）不能为空",groups = {Add.class})
    private BigDecimal s43;

    /**
     * S44.在校学历教育国际学生占比（%）
     */
    @TableField("s44")
    @NotNull(message = "在校学历教育国际学生占比（%）不能为空",groups = {Add.class})
    private BigDecimal s44;

    /**
     * S45.学生国（境）外学习、实习占比（%）
     */
    @TableField("s45")
    @NotNull(message = "学生国（境）外学习、实习占比（%）不能为空",groups = {Add.class})
    private BigDecimal s45;

    /**
     * S46.国际合作办学机构（项目）数（个）
     */
    @TableField("s46")
    @NotNull(message = "国际合作办学机构（项目）数（个）不能为空",groups = {Add.class})
    private Integer s46;

    /**
     * S47.技术转让当年实际收入（万元）
     */
    @TableField("s47")
    @NotNull(message = "技术转让当年实际收入（万元）不能为空",groups = {Add.class})
    private BigDecimal s47;

    /**
     * S48.决策咨询报告采纳数（篇）
     */
    @TableField("s48")
    @NotNull(message = "决策咨询报告采纳数（篇）不能为空",groups = {Add.class})
    private Integer s48;

    /**
     * S49.社会培训人时数（人天）
     */
    @TableField("s49")
    @NotNull(message = "社会培训人时数（人天）不能为空",groups = {Add.class})
    private BigDecimal s49;

    /**
     * S50.第一志愿录取率（%）
     */
    @TableField("s50")
    @NotNull(message = "第一志愿录取率（%）不能为空",groups = {Add.class})
    private BigDecimal s50;

    /**
     * S51.毕业生满意度（%）
     */
    @TableField("s51")
    @NotNull(message = "毕业生满意度（%）不能为空",groups = {Add.class})
    private BigDecimal s51;

    /**
     * S52.社会捐赠收入占比（%）
     */
    @TableField("s52")
    @NotNull(message = "社会捐赠收入占比（%）不能为空",groups = {Add.class})
    private BigDecimal s52;

    /**
     * S53.国家级示范校、骨干校荣誉数（个）
     */
    @TableField("s53")
    @NotNull(message = "请选择国家级示范校、骨干校【是-否】",groups = {Add.class})
    private Boolean s53;

    /**
     * S54.国家级特色高水平院校荣誉数（个）
     */
    @TableField("s54")
    @NotNull(message = "请选择国家级特色高水平院校【是-否】",groups = {Add.class})
    private Boolean s54;

    /**
     * S55.国家级优质校荣誉数（个）
     */
    @TableField("s55")
    @NotNull(message = "请选择国家级优质校【是-否】",groups = {Add.class})
    private Boolean s55;

    /**
     * S56.省级示范校、骨干校、优质校荣誉数（个）
     */
    @TableField("s56")
    @NotNull(message = "请选择省级示范校、骨干校、优质校【是-否】",groups = {Add.class})
    private Boolean s56;

    /**
     * S57.产教融合规划项目（个）
     */
    @TableField("s57")
    @NotNull(message = "产教融合规划项目（个）不能为空",groups = {Add.class})
    private Integer s57;

    /**
     * S58.承办过全国职业院校技能大赛个数（个）
     */
    @TableField("s58")
    @NotNull(message = "请选择承办过全国职业院校技能大赛【是-否】",groups = {Add.class})
    private Boolean s58;

    /**
     * S59.发布《高等职业院校质量年度报告》个数（个）
     */
    @TableField("s59")
    @NotNull(message = "发布《高等职业院校质量年度报告》个数（个）不能为空",groups = {Add.class})
    private Integer s59;

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
    public Integer getS39() {
        return s39;
    }

    public void setS39(Integer s39) {
        this.s39 = s39;
    }
    public Integer getS40() {
        return s40;
    }

    public void setS40(Integer s40) {
        this.s40 = s40;
    }
    public Integer getS41() {
        return s41;
    }

    public void setS41(Integer s41) {
        this.s41 = s41;
    }
    public Integer getS42() {
        return s42;
    }

    public void setS42(Integer s42) {
        this.s42 = s42;
    }
    public BigDecimal getS43() {
        return s43;
    }

    public void setS43(BigDecimal s43) {
        this.s43 = s43;
    }
    public BigDecimal getS44() {
        return s44;
    }

    public void setS44(BigDecimal s44) {
        this.s44 = s44;
    }
    public BigDecimal getS45() {
        return s45;
    }

    public void setS45(BigDecimal s45) {
        this.s45 = s45;
    }
    public Integer getS46() {
        return s46;
    }

    public void setS46(Integer s46) {
        this.s46 = s46;
    }
    public BigDecimal getS47() {
        return s47;
    }

    public void setS47(BigDecimal s47) {
        this.s47 = s47;
    }
    public Integer getS48() {
        return s48;
    }

    public void setS48(Integer s48) {
        this.s48 = s48;
    }
    public BigDecimal getS49() {
        return s49;
    }

    public void setS49(BigDecimal s49) {
        this.s49 = s49;
    }
    public BigDecimal getS50() {
        return s50;
    }

    public void setS50(BigDecimal s50) {
        this.s50 = s50;
    }
    public BigDecimal getS51() {
        return s51;
    }

    public void setS51(BigDecimal s51) {
        this.s51 = s51;
    }
    public BigDecimal getS52() {
        return s52;
    }

    public void setS52(BigDecimal s52) {
        this.s52 = s52;
    }
    public Boolean getS53() {
        return s53;
    }

    public void setS53(Boolean s53) {
        this.s53 = s53;
    }
    public Boolean getS54() {
        return s54;
    }

    public void setS54(Boolean s54) {
        this.s54 = s54;
    }
    public Boolean getS55() {
        return s55;
    }

    public void setS55(Boolean s55) {
        this.s55 = s55;
    }
    public Boolean getS56() {
        return s56;
    }

    public void setS56(Boolean s56) {
        this.s56 = s56;
    }
    public Integer getS57() {
        return s57;
    }

    public void setS57(Integer s57) {
        this.s57 = s57;
    }
    public Boolean getS58() {
        return s58;
    }

    public void setS58(Boolean s58) {
        this.s58 = s58;
    }
    public Integer getS59() {
        return s59;
    }

    public void setS59(Integer s59) {
        this.s59 = s59;
    }

    public static final String ID = "id";

    public static final String CREATEID = "create_id";

    public static final String CREATETIME = "create_time";

    public static final String S39 = "s39";

    public static final String S40 = "s40";

    public static final String S41 = "s41";

    public static final String S42 = "s42";

    public static final String S43 = "s43";

    public static final String S44 = "s44";

    public static final String S45 = "s45";

    public static final String S46 = "s46";

    public static final String S47 = "s47";

    public static final String S48 = "s48";

    public static final String S49 = "s49";

    public static final String S50 = "s50";

    public static final String S51 = "s51";

    public static final String S52 = "s52";

    public static final String S53 = "s53";

    public static final String S54 = "s54";

    public static final String S55 = "s55";

    public static final String S56 = "s56";

    public static final String S57 = "s57";

    public static final String S58 = "s58";

    public static final String S59 = "s59";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "IaIeSsSr{" +
        "id=" + id +
        ", createId=" + createId +
        ", createTime=" + createTime +
        ", s39=" + s39 +
        ", s40=" + s40 +
        ", s41=" + s41 +
        ", s42=" + s42 +
        ", s43=" + s43 +
        ", s44=" + s44 +
        ", s45=" + s45 +
        ", s46=" + s46 +
        ", s47=" + s47 +
        ", s48=" + s48 +
        ", s49=" + s49 +
        ", s50=" + s50 +
        ", s51=" + s51 +
        ", s52=" + s52 +
        ", s53=" + s53 +
        ", s54=" + s54 +
        ", s55=" + s55 +
        ", s56=" + s56 +
        ", s57=" + s57 +
        ", s58=" + s58 +
        ", s59=" + s59 +
        "}";
    }
}
