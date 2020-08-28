package net.webset.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import net.webset.util.options.Add;
import net.webset.util.options.Update;

/**
 * 学校基本信息实体
 * @author 梁雪峰
 *
 */
@TableName(value= "b_school_info",resultMap="schoolInfoMap")
public class SchoolData {
	@Id
	@TableId(value = ID,type=IdType.AUTO)
	@Null(message = "该数据已存在",groups = {Add.class})
	@NotNull(message = "数据不存在",groups = {Update.class})
	private Integer id;
	
	@TableField(SCHOOLNAME)
	@NotBlank(message="学校名称不能为空",groups= {Add.class})
	private String schoolName;
	
	@TableField(ADDRESS)
	@NotBlank(message="学校地址不能为空",groups= {Add.class})
	private String address;
	
	@TableField(BUILDDAY)
	@NotNull(message="建校日不能为空",groups= {Add.class})
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date buildDay;
	
	@TableField(NATURE)
	@NotBlank(message="学校性质不能为空",groups= {Add.class})
	private String nature;
	
	@TableField(TYPE)
	@NotBlank(message="举办单位类型不能为空",groups= {Add.class})
	private String type;
	
	@TableField(WEBSITE)
	@NotBlank(message="学校网址不能为空",groups= {Add.class})
	private String website;
	
	@TableField(POSTALADDRESS)
	@NotBlank(message="通讯地址不能为空",groups= {Add.class})
	private String postalAddress;
	
	@TableField(POSTCODE)
	@NotBlank(message="邮编不能为空",groups= {Add.class})
	private String postcode;
	
	@TableField(LENAME)
	@NotBlank(message="法人名不能为空",groups= {Add.class})
	private String leName;
	
	@TableField(LEPOST)
	private String lePost;
	
	@TableField(LEOFFICEPHONE)
	@NotBlank(message="法人办公电话不能为空",groups= {Add.class})
	private String leOfficePhone;
	
	@TableField(LEPHONE)
	@NotBlank(message="法人联系方式不能为空",groups= {Add.class})
	private String lePhone;
	
	@TableField(LEFAX)
	private String leFax;
	
	@TableField(LEEMAIL)
	private String leEmail;
	
	@TableField(CONNAME)
	@NotBlank(message="联系人不能为空",groups= {Add.class})
	private String conName;
	
	@TableField(CONPOST)
	private String conPost;
	
	@NotBlank(message="联系人办公电话不能为空",groups= {Add.class})
	@TableField(CONOFFICEPHONE)
	private String conOfficePhone;
	
	@TableField(CONPHONE)
	@NotBlank(message="联系人联系方式不能为空",groups= {Add.class})
	private String conPhone;
	
	@TableField(CONFAX)
	private String conFax;
	
	@TableField(CONEMAIL)
	private String conEmail;
	
	@TableField(CREATEID)
	private Integer createId;
	
    private Score score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBuildDay() {
		return buildDay;
	}
	public void setBuildDay(Date buildDay) {
		this.buildDay = buildDay;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getLeName() {
		return leName;
	}
	public void setLeName(String leName) {
		this.leName = leName;
	}
	public String getLePost() {
		return lePost;
	}
	public void setLePost(String lePost) {
		this.lePost = lePost;
	}
	public String getLeOfficePhone() {
		return leOfficePhone;
	}
	public void setLeOfficePhone(String leOfficePhone) {
		this.leOfficePhone = leOfficePhone;
	}
	public String getLePhone() {
		return lePhone;
	}
	public void setLePhone(String lePhone) {
		this.lePhone = lePhone;
	}
	public String getLeFax() {
		return leFax;
	}
	public void setLeFax(String leFax) {
		this.leFax = leFax;
	}
	public String getLeEmail() {
		return leEmail;
	}
	public void setLeEmail(String leEmail) {
		this.leEmail = leEmail;
	}
	public String getConName() {
		return conName;
	}
	public void setConName(String conName) {
		this.conName = conName;
	}
	public String getConPost() {
		return conPost;
	}
	public void setConPost(String conPost) {
		this.conPost = conPost;
	}
	public String getConOfficePhone() {
		return conOfficePhone;
	}
	public void setConOfficePhone(String conOfficePhone) {
		this.conOfficePhone = conOfficePhone;
	}
	public String getConPhone() {
		return conPhone;
	}
	public void setConPhone(String conPhone) {
		this.conPhone = conPhone;
	}
	public String getConFax() {
		return conFax;
	}
	public void setConFax(String conFax) {
		this.conFax = conFax;
	}
	public String getConEmail() {
		return conEmail;
	}
	public void setConEmail(String conEmail) {
		this.conEmail = conEmail;
	}
	public Integer getCreateId() {
		return createId;
	}
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}

	public static final String ID = "id";
	public static final String SCHOOLNAME = "school_name";
	public static final String ADDRESS = "address";
	public static final String BUILDDAY = "build_day";
	public static final String NATURE = "nature";
	public static final String TYPE = "type";
	public static final String WEBSITE = "website";
	public static final String POSTALADDRESS = "postal_address";
	public static final String POSTCODE = "postcode";
	public static final String LENAME = "le_name";
	public static final String LEPOST = "le_post";
	public static final String LEOFFICEPHONE = "le_office_phone";
	public static final String LEPHONE = "le_phone";
	public static final String LEFAX = "le_fax";
	public static final String LEEMAIL = "le_email";
	public static final String CONNAME = "con_name";
	public static final String CONPOST = "con_post";
	public static final String CONOFFICEPHONE = "con_office_phone";
	public static final String CONPHONE = "con_phone";
	public static final String CONFAX = "con_fax";
	public static final String CONEMAIL = "con_email";
	public static final String CREATEID = "create_id";

}
