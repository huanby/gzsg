package net.webset.wapper.api.vos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import net.webset.entity.MajorNumber;
import net.webset.entity.MajorText;
import net.webset.util.options.Add;
import net.webset.util.options.Delete;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 专业数据厅展示实体类
 * @author hby
 * create date: 2020-08-24
 */
public class MajorConclusionVO extends MajorNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double score;

    private Integer raterId;

    private String t1;

    private String t2;

    private String t3;

    private String t4;


    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getRaterId() {
        return raterId;
    }

    public void setRaterId(Integer raterId) {
        this.raterId = raterId;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    public String getT4() {
        return t4;
    }

    public void setT4(String t4) {
        this.t4 = t4;
    }
}
