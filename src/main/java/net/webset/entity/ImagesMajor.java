package net.webset.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * 附件实体类
 * @author hby
 * create date: 2020-08-21
 */
@TableName(value= "b_images_major",resultMap="MajorImageMap")
public class ImagesMajor extends Model<ImagesMajor> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 专业文档id
     */
    @TableField("majorId")
    private Integer majorId;

    /**
     * 创建者ID
     */
    @TableField("create_id")
    private Integer createId;

    /**
     * 图片名称
     */
    @TableField("name")
    private String name;

    /**
     * 文件原名
     */
    @TableField("source_name")
    private String sourceName;

    /**
     * 文件大小
     */
    @TableField("size")
    private Long size;

    /**
     * 文件类型
     */
    @TableField("type")
    private String type;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static final String ID = "id";

    public static final String MAJORID = "majorId";

    public static final String CREATE_ID = "create_id";

    public static final String NAME = "name";

    public static final String SOURCE_NAME = "source_name";

    public static final String SIZE = "size";

    public static final String TYPE = "type";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ImagesMajor{" +
        "id=" + id +
        ", majorId=" + majorId +
        ", createId=" + createId +
        ", name=" + name +
        ", sourceName=" + sourceName +
        ", size=" + size +
        ", type=" + type +
        "}";
    }
}
