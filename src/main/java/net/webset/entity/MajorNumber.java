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
 * 专业数据数值类型实体类
 * @author hby
 * create date: 2020-08-18
 */
@TableName(value= "b_major_number",resultMap="MajorNumberMap")
public class MajorNumber {

    @Id
    @TableId(value = ID,type= IdType.AUTO)
    private Integer id;

    @TableField(MAJORID)
    private Integer majorid;

    @TableField(NAME)
//    @NotBlank(message="专业（群）名称不能为空",groups= {Add.class})
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

    @TableField(CREATEID)
    private Integer createId;

    @TableField(N1)
    private Integer n1;

    @TableField(N2)
    private Integer n2;

    @TableField(N3)
    private Integer n3;

    @TableField(N4)
    private Integer n4;

    @TableField(N5)
    private Integer n5;

    @TableField(N6)
    private Integer n6;

    @TableField(N7)
    private Integer n7;

    @TableField(N8)
    private Double n8;

    @TableField(N9)
    private Double n9;

    @TableField(N10)
    private Integer n10;

    @TableField(N11)
    private Double n11;

    @TableField(N12)
    private Integer n12;

    @TableField(N13)
    private Double n13;

    @TableField(N14)
    private Integer n14;

    @TableField(N15)
    private Double n15;

    @TableField(N16)
    private Integer n16;

    @TableField(N17)
    private Integer n17;

    @TableField(N18)
    private Double n18;

    @TableField(N19)
    private Double n19;

    @TableField(N20)
    private Integer n20;

    @TableField(N21)
    private Integer n21;

    @TableField(N22)
    private Integer n22;

    @TableField(N23)
    private Integer n23;

    @TableField(N24)
    private Integer n24;

    @TableField(N25)
    private Integer n25;

    @TableField(N26)
    private Integer n26;

    @TableField(N27)
    private Double n27;

    @TableField(N28)
    private Double n28;

    @TableField(N29)
    private Double n29;

    @TableField(N30)
    private Integer n30;

    @TableField(N31)
    private Integer n31;

    @TableField(N32)
    private Integer n32;

    @TableField(N33)
    private Integer n33;

    @TableField(N34)
    private Integer n34;

    @TableField(N35)
    private Integer n35;

    @TableField(N36)
    private Integer n36;

    @TableField(N37)
    private Integer n37;

    @TableField(N38)
    private Integer n38;

    @TableField(N39)
    private Integer n39;

    @TableField(N40)
    private Integer n40;

    @TableField(N41)
    private Integer n41;

    @TableField(N42)
    private Integer n42;

    @TableField(N43)
    private Double n43;

    @TableField(N44)
    private Integer n44;

    public MajorNumber(Integer id, Integer majorid, String name, Integer type, Integer state, Integer isdel, Date createtime, Date updatetime, Integer n1, Integer n2, Integer n3, Integer n4, Integer n5, Integer n6, Integer n7, Double n8, Double n9, Integer n10, Double n11, Integer n12, Double n13, Integer n14, Double n15, Integer n16, Integer n17, Double n18, Double n19, Integer n20, Integer n21, Integer n22, Integer n23, Integer n24, Integer n25, Integer n26, Double n27, Double n28, Double n29, Integer n30, Integer n31, Integer n32, Integer n33, Integer n34, Integer n35, Integer n36, Integer n37, Integer n38, Integer n39, Integer n40, Integer n41, Integer n42, Double n43, Integer n44, Integer createId) {
        this.id = id;
        this.majorid = majorid;
        this.name = name;
        this.type = type;
        this.state = state;
        this.isdel = isdel;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
        this.n6 = n6;
        this.n7 = n7;
        this.n8 = n8;
        this.n9 = n9;
        this.n10 = n10;
        this.n11 = n11;
        this.n12 = n12;
        this.n13 = n13;
        this.n14 = n14;
        this.n15 = n15;
        this.n16 = n16;
        this.n17 = n17;
        this.n18 = n18;
        this.n19 = n19;
        this.n20 = n20;
        this.n21 = n21;
        this.n22 = n22;
        this.n23 = n23;
        this.n24 = n24;
        this.n25 = n25;
        this.n26 = n26;
        this.n27 = n27;
        this.n28 = n28;
        this.n29 = n29;
        this.n30 = n30;
        this.n31 = n31;
        this.n32 = n32;
        this.n33 = n33;
        this.n34 = n34;
        this.n35 = n35;
        this.n36 = n36;
        this.n37 = n37;
        this.n38 = n38;
        this.n39 = n39;
        this.n40 = n40;
        this.n41 = n41;
        this.n42 = n42;
        this.n43 = n43;
        this.n44 = n44;
        this.createId = createId;
    }

    public MajorNumber() {
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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getN1() {
        return n1;
    }

    public void setN1(Integer n1) {
        this.n1 = n1;
    }

    public Integer getN2() {
        return n2;
    }

    public void setN2(Integer n2) {
        this.n2 = n2;
    }

    public Integer getN3() {
        return n3;
    }

    public void setN3(Integer n3) {
        this.n3 = n3;
    }

    public Integer getN4() {
        return n4;
    }

    public void setN4(Integer n4) {
        this.n4 = n4;
    }

    public Integer getN5() {
        return n5;
    }

    public void setN5(Integer n5) {
        this.n5 = n5;
    }

    public Integer getN6() {
        return n6;
    }

    public void setN6(Integer n6) {
        this.n6 = n6;
    }

    public Integer getN7() {
        return n7;
    }

    public void setN7(Integer n7) {
        this.n7 = n7;
    }

    public Double getN8() {
        return n8;
    }

    public void setN8(Double n8) {
        this.n8 = n8;
    }

    public Double getN9() {
        return n9;
    }

    public void setN9(Double n9) {
        this.n9 = n9;
    }

    public Integer getN10() {
        return n10;
    }

    public void setN10(Integer n10) {
        this.n10 = n10;
    }

    public Double getN11() {
        return n11;
    }

    public void setN11(Double n11) {
        this.n11 = n11;
    }

    public Integer getN12() {
        return n12;
    }

    public void setN12(Integer n12) {
        this.n12 = n12;
    }

    public Double getN13() {
        return n13;
    }

    public void setN13(Double n13) {
        this.n13 = n13;
    }

    public Integer getN14() {
        return n14;
    }

    public void setN14(Integer n14) {
        this.n14 = n14;
    }

    public Double getN15() {
        return n15;
    }

    public void setN15(Double n15) {
        this.n15 = n15;
    }

    public Integer getN16() {
        return n16;
    }

    public void setN16(Integer n16) {
        this.n16 = n16;
    }

    public Integer getN17() {
        return n17;
    }

    public void setN17(Integer n17) {
        this.n17 = n17;
    }

    public Double getN18() {
        return n18;
    }

    public void setN18(Double n18) {
        this.n18 = n18;
    }

    public Double getN19() {
        return n19;
    }

    public void setN19(Double n19) {
        this.n19 = n19;
    }

    public Integer getN20() {
        return n20;
    }

    public void setN20(Integer n20) {
        this.n20 = n20;
    }

    public Integer getN21() {
        return n21;
    }

    public void setN21(Integer n21) {
        this.n21 = n21;
    }

    public Integer getN22() {
        return n22;
    }

    public void setN22(Integer n22) {
        this.n22 = n22;
    }

    public Integer getN23() {
        return n23;
    }

    public void setN23(Integer n23) {
        this.n23 = n23;
    }

    public Integer getN24() {
        return n24;
    }

    public void setN24(Integer n24) {
        this.n24 = n24;
    }

    public Integer getN25() {
        return n25;
    }

    public void setN25(Integer n25) {
        this.n25 = n25;
    }

    public Integer getN26() {
        return n26;
    }

    public void setN26(Integer n26) {
        this.n26 = n26;
    }

    public Double getN27() {
        return n27;
    }

    public void setN27(Double n27) {
        this.n27 = n27;
    }

    public Double getN28() {
        return n28;
    }

    public void setN28(Double n28) {
        this.n28 = n28;
    }

    public Double getN29() {
        return n29;
    }

    public void setN29(Double n29) {
        this.n29 = n29;
    }

    public Integer getN30() {
        return n30;
    }

    public void setN30(Integer n30) {
        this.n30 = n30;
    }

    public Integer getN31() {
        return n31;
    }

    public void setN31(Integer n31) {
        this.n31 = n31;
    }

    public Integer getN32() {
        return n32;
    }

    public void setN32(Integer n32) {
        this.n32 = n32;
    }

    public Integer getN33() {
        return n33;
    }

    public void setN33(Integer n33) {
        this.n33 = n33;
    }

    public Integer getN34() {
        return n34;
    }

    public void setN34(Integer n34) {
        this.n34 = n34;
    }

    public Integer getN35() {
        return n35;
    }

    public void setN35(Integer n35) {
        this.n35 = n35;
    }

    public Integer getN36() {
        return n36;
    }

    public void setN36(Integer n36) {
        this.n36 = n36;
    }

    public Integer getN37() {
        return n37;
    }

    public void setN37(Integer n37) {
        this.n37 = n37;
    }

    public Integer getN38() {
        return n38;
    }

    public void setN38(Integer n38) {
        this.n38 = n38;
    }

    public Integer getN39() {
        return n39;
    }

    public void setN39(Integer n39) {
        this.n39 = n39;
    }

    public Integer getN40() {
        return n40;
    }

    public void setN40(Integer n40) {
        this.n40 = n40;
    }

    public Integer getN41() {
        return n41;
    }

    public void setN41(Integer n41) {
        this.n41 = n41;
    }

    public Integer getN42() {
        return n42;
    }

    public void setN42(Integer n42) {
        this.n42 = n42;
    }

    public Double getN43() {
        return n43;
    }

    public void setN43(Double n43) {
        this.n43 = n43;
    }

    public Integer getN44() {
        return n44;
    }

    public void setN44(Integer n44) {
        this.n44 = n44;
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
    public static final String N1 = "n1";
    public static final String N2 = "n2";
    public static final String N3 = "n3";
    public static final String N4 = "n4";
    public static final String N5 = "n5";
    public static final String N6 = "n6";
    public static final String N7 = "n7";
    public static final String N8 = "n8";
    public static final String N9 = "n9";
    public static final String N10 = "n10";
    public static final String N11 = "n11";
    public static final String N12 = "n12";
    public static final String N13 = "n13";
    public static final String N14 = "n14";
    public static final String N15 = "n15";
    public static final String N16 = "n16";
    public static final String N17 = "n17";
    public static final String N18 = "n18";
    public static final String N19 = "n19";
    public static final String N20 = "n20";
    public static final String N21 = "n21";
    public static final String N22 = "n22";
    public static final String N23 = "n23";
    public static final String N24 = "n24";
    public static final String N25 = "n25";
    public static final String N26 = "n26";
    public static final String N27 = "n27";
    public static final String N28 = "n28";
    public static final String N29 = "n29";
    public static final String N30 = "n30";
    public static final String N31 = "n31";
    public static final String N32 = "n32";
    public static final String N33 = "n33";
    public static final String N34 = "n34";
    public static final String N35 = "n35";
    public static final String N36 = "n36";
    public static final String N37 = "n37";
    public static final String N38 = "n38";
    public static final String N39 = "n39";
    public static final String N40 = "n40";
    public static final String N41 = "n41";
    public static final String N42 = "n42";
    public static final String N43 = "n43";
    public static final String N44 = "n44";

}