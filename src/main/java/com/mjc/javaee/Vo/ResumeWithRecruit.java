package com.mjc.javaee.Vo;

import com.mjc.javaee.Entity.Resume;

import javax.persistence.Entity;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}10:09
 */
@Entity
public class ResumeWithRecruit extends Resume {
    private String requires;
    private String positionName;

    public String getRequires() {
        return requires;
    }

    public void setRequires(String require) {
        this.requires = require;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
