package com.mjc.javaee.Vo;

import com.mjc.javaee.Entity.Recruitment;

import javax.persistence.Entity;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}15:59
 */
@Entity
public class RecruitmentWithPosition extends Recruitment {
    private String positionName;
    private Double positionSalary;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Double getPositionSalary() {
        return positionSalary;
    }

    public void setPositionSalary(Double positionSalary) {
        this.positionSalary = positionSalary;
    }
}
