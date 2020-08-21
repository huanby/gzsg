package net.webset.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import net.webset.util.options.Add;
import net.webset.util.options.Update;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

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
 * @since 2020-08-20
 */
@TableName(value = "b_la_on",resultMap = "laOnMap")
public class LaOn extends Model<LaOn> {

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
    private LocalDateTime createTime;

    /**
     * G1.国家示范校、骨干校、优质校成果数（个）
     */
    @TableField("g1")
    @NotNull(message = "国家示范校、骨干校、优质校成果数（个）不能为空",groups = {Add.class})
    private Integer g1;

    /**
     * G2.吉林省示范校、骨干校、优质校成果数（个）
     */
    @TableField("g2")
    @NotNull(message = "吉林省示范校、骨干校、优质校成果数（个）不能为空",groups = {Add.class})
    private Integer g2;

    /**
     * G3.国家级教育教学改革试点数（个）仅包括现代学徒制试点、教学工作诊断与改进工作试点、定向培养士官试点
     */
    @TableField("g3")
    @NotNull(message = "国家级教育教学改革试点数（个）不能为空",groups = {Add.class})
    private Integer g3;

    /**
     * G4.省级教育教学改革试点数（个）仅包括现代学徒制试点、教学工作诊断与改进工作试点、定向培养士官试点
     */
    @TableField("g4")
    @NotNull(message = "省级教育教学改革试点数（个）不能为空",groups = {Add.class})
    private Integer g4;

    /**
     * G5.国家级重点专业数（个）填报2006年以来国家级示范、品牌、特色专业和高水平专业建设项目
     */
    @TableField("g5")
    @NotNull(message = "国家级重点专业数（个）不能为空",groups = {Add.class})
    private Integer g5;

    /**
     * G6.省级重点专业数（个）填报2006年以来省级示范、品牌、特色专业和高水平专业建设项目
     */
    @TableField("g6")
    @NotNull(message = "省级重点专业数（个）不能为空",groups = {Add.class})
    private Integer g6;

    /**
     * G7.国家级财政支持的实训基地数（个）
     */
    @TableField("g7")
    @NotNull(message = "国家级财政支持的实训基地数（个）不能为空",groups = {Add.class})
    private Integer g7;

    /**
     * G8.省级财政支持的实训基地数（个）
     */
    @TableField("g8")
    @NotNull(message = "省级财政支持的实训基地数（个）不能为空",groups = {Add.class})
    private Integer g8;

    /**
     * G9.国家职业教育教学资源库数（个）
     */
    @TableField("g9")
    @NotNull(message = "国家职业教育教学资源库数（个）不能为空",groups = {Add.class})
    private Integer g9;

    /**
     * G10.全国就业创业典型数（个）填报近五年全国毕业生就业典型经验高校、创新创业典型经验高校、创新创业教育改革示范高校，国家“双创”基地、国家创新创业教育改革示范高校、国家大学科技园、国家级科技企业孵化器等
     */
    @TableField("g10")
    @NotNull(message = "全国就业创业典型数（个）不能为空",groups = {Add.class})
    private Integer g10;

    /**
     * G11.吉林省就业创业典型数（个）填报近五年全国、吉林省毕业生就业典型经验高校、创新创业典型经验高校、创新创业教育改革示范高校，国家“双创”基地、国家创新创业教育改革示范高校、国家大学科技园、国家级科技企业孵化器等
     */
    @TableField("g11")
    @NotNull(message = "吉林省就业创业典型数（个）不能为空",groups = {Add.class})
    private Integer g11;

    /**
     * G12.教师国家级荣誉数（个）
     */
    @TableField("g12")
    @NotNull(message = "教师国家级荣誉数（个）不能为空",groups = {Add.class})
    private Integer g12;

    /**
     * G13.教师省级荣誉数（个）
     */
    @TableField("g13")
    @NotNull(message = "教师省级荣誉数（个）不能为空",groups = {Add.class})
    private Integer g13;

    /**
     * G14.承办全国职业院校技能大赛数（个）仅填报近五年学校承办过的全国职业院校技能大赛
     */
    @TableField("g14")
    @NotNull(message = "承办全国职业院校技能大赛数（个）不能为空",groups = {Add.class})
    private Integer g14;

    /**
     * G15.承办吉林省职业院校技能大赛数（个）仅填报近五年学校承办过的吉林职业院校技能大赛
     */
    @TableField("g15")
    @NotNull(message = "承办吉林省职业院校技能大赛数（个）不能为空",groups = {Add.class})
    private Integer g15;

    /**
     * G16.国家级教学成果奖励数（个）学校须为第一完成单位
     */
    @TableField("g16")
    @NotNull(message = "国家级教学成果奖励数（个）不能为空",groups = {Add.class})
    private Integer g16;

    /**
     * G17.吉林省教学成果奖励数（个）学校须为第一完成单位
     */
    @TableField("g17")
    @NotNull(message = "吉林省教学成果奖励数（个）不能为空",groups = {Add.class})
    private Integer g17;

    /**
     * G18.教师全国职业院校教学能力比赛获奖（含职业院校信息化教学大赛）数（个）
     */
    @TableField("g18")
    @NotNull(message = "教师全国职业院校教学能力比赛获奖（含职业院校信息化教学大赛）数（个）不能为空",groups = {Add.class})
    private Integer g18;

    /**
     * G19.教师吉林省职业院校教学能力比赛获奖（含职业院校信息化教学大赛）数（个）
     */
    @TableField("g19")
    @NotNull(message = "教师吉林省职业院校教学能力比赛获奖（含职业院校信息化教学大赛）数（个）不能为空",groups = {Add.class})
    private Integer g19;

    /**
     * G20.学生全国职业院校技能大赛获奖数（个）近五年
     */
    @TableField("g20")
    @NotNull(message = "学生全国职业院校技能大赛获奖数（个）近五年不能为空",groups = {Add.class})
    private Integer g20;

    /**
     * G21.学生吉林省职业院校技能大赛获奖数（个）近五年
     */
    @TableField("g21")
    @NotNull(message = "学生吉林省职业院校技能大赛获奖数（个）近五年不能为空",groups = {Add.class})
    private Integer g21;

    /**
     * G22.学生中国“互联网+”大学生创新创业大赛获奖数（个）近五年
     */
    @TableField("g22")
    @NotNull(message = "学生中国“互联网+”大学生创新创业大赛获奖数（个）近五年不能为空",groups = {Add.class})
    private Integer g22;

    /**
     * G23.学生吉林省“互联网+”大学生创新创业大赛获奖数（个）近五年
     */
    @TableField("g23")
    @NotNull(message = "学生吉林省“互联网+”大学生创新创业大赛获奖数（个）近五年不能为空",groups = {Add.class})
    private Integer g23;

    /**
     * G24.学生“挑战杯”全国大学生课外学术科技作品竞赛和中国大学生创业计划竞赛获奖数（个）近五年
     */
    @TableField("g24")
    @NotNull(message = "学生“挑战杯”全国大学生课外学术科技作品竞赛和中国大学生创业计划竞赛获奖数（个）近五年不能为空",groups = {Add.class})
    private Integer g24;

    /**
     * G25.其它国家级成果数，学校须为主持单位（个）
     */
    @TableField("g25")
    @NotNull(message = "其它国家级成果数，学校须为主持单位（个）不能为空",groups = {Add.class})
    private Integer g25;

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
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Integer getG1() {
        return g1;
    }

    public void setG1(Integer g1) {
        this.g1 = g1;
    }
    public Integer getG2() {
        return g2;
    }

    public void setG2(Integer g2) {
        this.g2 = g2;
    }
    public Integer getG3() {
        return g3;
    }

    public void setG3(Integer g3) {
        this.g3 = g3;
    }
    public Integer getG4() {
        return g4;
    }

    public void setG4(Integer g4) {
        this.g4 = g4;
    }
    public Integer getG5() {
        return g5;
    }

    public void setG5(Integer g5) {
        this.g5 = g5;
    }
    public Integer getG6() {
        return g6;
    }

    public void setG6(Integer g6) {
        this.g6 = g6;
    }
    public Integer getG7() {
        return g7;
    }

    public void setG7(Integer g7) {
        this.g7 = g7;
    }
    public Integer getG8() {
        return g8;
    }

    public void setG8(Integer g8) {
        this.g8 = g8;
    }
    public Integer getG9() {
        return g9;
    }

    public void setG9(Integer g9) {
        this.g9 = g9;
    }
    public Integer getG10() {
        return g10;
    }

    public void setG10(Integer g10) {
        this.g10 = g10;
    }
    public Integer getG11() {
        return g11;
    }

    public void setG11(Integer g11) {
        this.g11 = g11;
    }
    public Integer getG12() {
        return g12;
    }

    public void setG12(Integer g12) {
        this.g12 = g12;
    }
    public Integer getG13() {
        return g13;
    }

    public void setG13(Integer g13) {
        this.g13 = g13;
    }
    public Integer getG14() {
        return g14;
    }

    public void setG14(Integer g14) {
        this.g14 = g14;
    }
    public Integer getG15() {
        return g15;
    }

    public void setG15(Integer g15) {
        this.g15 = g15;
    }
    public Integer getG16() {
        return g16;
    }

    public void setG16(Integer g16) {
        this.g16 = g16;
    }
    public Integer getG17() {
        return g17;
    }

    public void setG17(Integer g17) {
        this.g17 = g17;
    }
    public Integer getG18() {
        return g18;
    }

    public void setG18(Integer g18) {
        this.g18 = g18;
    }
    public Integer getG19() {
        return g19;
    }

    public void setG19(Integer g19) {
        this.g19 = g19;
    }
    public Integer getG20() {
        return g20;
    }

    public void setG20(Integer g20) {
        this.g20 = g20;
    }
    public Integer getG21() {
        return g21;
    }

    public void setG21(Integer g21) {
        this.g21 = g21;
    }
    public Integer getG22() {
        return g22;
    }

    public void setG22(Integer g22) {
        this.g22 = g22;
    }
    public Integer getG23() {
        return g23;
    }

    public void setG23(Integer g23) {
        this.g23 = g23;
    }
    public Integer getG24() {
        return g24;
    }

    public void setG24(Integer g24) {
        this.g24 = g24;
    }
    public Integer getG25() {
        return g25;
    }

    public void setG25(Integer g25) {
        this.g25 = g25;
    }

    public static final String ID = "id";

    public static final String CREATEID = "create_id";

    public static final String CREATETIME = "create_time";

    public static final String G1 = "g1";

    public static final String G2 = "g2";

    public static final String G3 = "g3";

    public static final String G4 = "g4";

    public static final String G5 = "g5";

    public static final String G6 = "g6";

    public static final String G7 = "g7";

    public static final String G8 = "g8";

    public static final String G9 = "g9";

    public static final String G10 = "g10";

    public static final String G11 = "g11";

    public static final String G12 = "g12";

    public static final String G13 = "g13";

    public static final String G14 = "g14";

    public static final String G15 = "g15";

    public static final String G16 = "g16";

    public static final String G17 = "g17";

    public static final String G18 = "g18";

    public static final String G19 = "g19";

    public static final String G20 = "g20";

    public static final String G21 = "g21";

    public static final String G22 = "g22";

    public static final String G23 = "g23";

    public static final String G24 = "g24";

    public static final String G25 = "g25";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LaOn{" +
        "id=" + id +
        ", createId=" + createId +
        ", createTime=" + createTime +
        ", g1=" + g1 +
        ", g2=" + g2 +
        ", g3=" + g3 +
        ", g4=" + g4 +
        ", g5=" + g5 +
        ", g6=" + g6 +
        ", g7=" + g7 +
        ", g8=" + g8 +
        ", g9=" + g9 +
        ", g10=" + g10 +
        ", g11=" + g11 +
        ", g12=" + g12 +
        ", g13=" + g13 +
        ", g14=" + g14 +
        ", g15=" + g15 +
        ", g16=" + g16 +
        ", g17=" + g17 +
        ", g18=" + g18 +
        ", g19=" + g19 +
        ", g20=" + g20 +
        ", g21=" + g21 +
        ", g22=" + g22 +
        ", g23=" + g23 +
        ", g24=" + g24 +
        ", g25=" + g25 +
        "}";
    }
}
