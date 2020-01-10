package com.mjc.javaee.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}1:25
 */
@Entity
public class Recruitment {
    private String id;
    private Integer num;
    private String positionId;
    private String requires;

    @Id
    @Column(name = "ID", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Num", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "PositionID", nullable = true, length = 50)
    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }


    @Basic
    @Column(name = "Requires", nullable = true, length = -1)
    public String getRequires() {
        return requires;
    }

    public void setRequires(String require) {
        this.requires = require;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruitment that = (Recruitment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(num, that.num) &&
                Objects.equals(positionId, that.positionId) &&
                Objects.equals(requires, that.requires);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num, positionId, requires);
    }
}
