package net.webset.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.webset.util.options.Add;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 专业数据文本类型实体类
 * @author hby
 * create date: 2020-08-18
 */
@TableName(value= "b_major_text",resultMap="MajorTextMap")
public class MajorText {

    @Id
    @TableId(value = ID,type= IdType.AUTO)
    private Integer id;

    @TableField(MAJORID)
    private Integer majorid;

    @TableField(NAME)
    @NotBlank(message="专业（群）名称不能为空",groups= {Add.class})
    private String name;

    @TableField(TYPE)
    private Integer type;

    @TableField(STATE)
    private Integer state;

    @TableField(ISDEL)
    private Integer isdel;

    @TableField(CREATETIME)
    private Date createtime;

    @TableField(UPDATETIME)
    private Date updatetime;

    private String t1;

    private String t2;

    private String t3;

    private String t4;

    private Date t5;

    private Date t6;

    private Date t7;

    private String t8;

    private String t9;

    private Date t10;

    private String t11;

    private String t12;

    private String t13;

    private String t14;

    private String t15;

    private String t16;

    private String t17;

    private String t18;

    private String t19;

    private String t20;

    private String t21;

    @TableField(CREATEID)
    private Integer createId;

    public MajorText(Integer id, Integer majorid, String name, Integer type, Integer state, Integer isdel, Date createtime, Date updatetime, String t1, String t2, String t3, String t4, Date t5, Date t6, Date t7, String t8, String t9, Date t10, String t11, String t12, String t13, String t14, String t15, String t16, String t17, String t18, String t19, String t20, String t21, Integer createId) {
        this.id = id;
        this.majorid = majorid;
        this.name = name;
        this.type = type;
        this.state = state;
        this.isdel = isdel;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
        this.t6 = t6;
        this.t7 = t7;
        this.t8 = t8;
        this.t9 = t9;
        this.t10 = t10;
        this.t11 = t11;
        this.t12 = t12;
        this.t13 = t13;
        this.t14 = t14;
        this.t15 = t15;
        this.t16 = t16;
        this.t17 = t17;
        this.t18 = t18;
        this.t19 = t19;
        this.t20 = t20;
        this.t21 = t21;
        this.createId = createId;
    }

    public MajorText() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1 == null ? null : t1.trim();
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2 == null ? null : t2.trim();
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3 == null ? null : t3.trim();
    }

    public String getT4() {
        return t4;
    }

    public void setT4(String t4) {
        this.t4 = t4 == null ? null : t4.trim();
    }

    public Date getT5() {
        return t5;
    }

    public void setT5(Date t5) {
        this.t5 = t5;
    }

    public Date getT6() {
        return t6;
    }

    public void setT6(Date t6) {
        this.t6 = t6;
    }

    public Date getT7() {
        return t7;
    }

    public void setT7(Date t7) {
        this.t7 = t7;
    }

    public String getT8() {
        return t8;
    }

    public void setT8(String t8) {
        this.t8 = t8 == null ? null : t8.trim();
    }

    public String getT9() {
        return t9;
    }

    public void setT9(String t9) {
        this.t9 = t9 == null ? null : t9.trim();
    }

    public Date getT10() {
        return t10;
    }

    public void setT10(Date t10) {
        this.t10 = t10;
    }

    public String getT11() {
        return t11;
    }

    public void setT11(String t11) {
        this.t11 = t11 == null ? null : t11.trim();
    }

    public String getT12() {
        return t12;
    }

    public void setT12(String t12) {
        this.t12 = t12 == null ? null : t12.trim();
    }

    public String getT13() {
        return t13;
    }

    public void setT13(String t13) {
        this.t13 = t13 == null ? null : t13.trim();
    }

    public String getT14() {
        return t14;
    }

    public void setT14(String t14) {
        this.t14 = t14 == null ? null : t14.trim();
    }

    public String getT15() {
        return t15;
    }

    public void setT15(String t15) {
        this.t15 = t15 == null ? null : t15.trim();
    }

    public String getT16() {
        return t16;
    }

    public void setT16(String t16) {
        this.t16 = t16 == null ? null : t16.trim();
    }

    public String getT17() {
        return t17;
    }

    public void setT17(String t17) {
        this.t17 = t17 == null ? null : t17.trim();
    }

    public String getT18() {
        return t18;
    }

    public void setT18(String t18) {
        this.t18 = t18 == null ? null : t18.trim();
    }

    public String getT19() {
        return t19;
    }

    public void setT19(String t19) {
        this.t19 = t19 == null ? null : t19.trim();
    }

    public String getT20() {
        return t20;
    }

    public void setT20(String t20) {
        this.t20 = t20 == null ? null : t20.trim();
    }

    public String getT21() {
        return t21;
    }

    public void setT21(String t21) {
        this.t21 = t21 == null ? null : t21.trim();
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public static final String ID = "id";
    public static final String MAJORID = "majorId";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String STATE = "state";
    public static final String ISDEL = "isdel";
    public static final String CREATETIME = "createtime";
    public static final String UPDATETIME = "updatetime";
    public static final String CREATEID = "create_id";
    public static final String T1 = "t1";
    public static final String T2 = "t2";
    public static final String T3 = "t3";
    public static final String T4 = "t4";
    public static final String T5 = "t5";
    public static final String T6 = "t6";
    public static final String T7 = "t7";
    public static final String T8 = "t8";
    public static final String T9 = "t9";
    public static final String T10 = "t10";
    public static final String T11 = "t11";
    public static final String T12 = "t12";
    public static final String T13 = "t13";
    public static final String T14 = "t14";
    public static final String T15 = "t15";
    public static final String T16 = "t16";
    public static final String T17 = "t17";
    public static final String T18 = "t18";
    public static final String T19 = "t19";
    public static final String T20 = "t20";
    public static final String T21 = "t21";

}