package net.webset.wapper.api.vos;

import net.webset.entity.MajorText;

import java.io.Serializable;

public class MajorScoreVO extends MajorText implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double score;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
