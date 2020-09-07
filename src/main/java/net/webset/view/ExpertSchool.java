package net.webset.view;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "B_VIEW_EXPERT_SCHOOL",resultMap = "expertSchoolMap")
public class ExpertSchool {
	
	@TableId("id")
	private Integer id;
	
	@TableField("school_name")
	private String schoolName;
	
	@TableField("address")
	private String address;
	
	@TableField("build_day")
	private Date buildDay;
	
	@TableField("nature")
	private String nature;
	
	@TableField("type")
	private String type;
	
	@TableField("website")
	private String website;
	
	@TableField("postal_address")
	private String postalAddress;
	
	@TableField("postcode")
	private String postcode;
	
	@TableField("le_name")
	private String leName;
	
	@TableField("le_post")
	private String lePost;
	
	@TableField("le_office_phone")
	private String leOfficePhone;
	
	@TableField("le_phone")
	private String lePhone;
	
	@TableField("le_fax")
	private String leFax;
	
	@TableField("le_email")
	private String leEmail;
	
	@TableField("con_name")
	private String conName;
	
	@TableField("con_post")
	private String conPost;
	
	@TableField("con_office_phone")
	private String conOfficePhone;
	
	@TableField("con_phone")
	private String conPhone;
	
	@TableField("con_fax")
	private String conFax;
	
	@TableField("con_email")
	private String conEmail;
	
	@TableField("create_id")
	private Integer createId;
	
	@TableField("score")
	private Integer score;
	
	@TableField("exam_id")
	private Integer examId;

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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
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
	public static final String SCORE = "score";
	public static final String EXAMID = "exam_id";
	
	
}
