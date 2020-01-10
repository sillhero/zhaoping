package com.mjc.javaee.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}16:09
 */
@Entity
public class Resume {
    private String id;
    private String name;
    private String workExperience;
    private String skill;
    private String recrutmentId;
    private String userName;
    private String isPass;



    @Id
    @Column(name = "ID", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "WorkExperience", nullable = true, length = 50)
    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    @Basic
    @Column(name = "Skill", nullable = true, length = 50)
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Basic
    @Column(name = "RecrutmentID", nullable = true, length = 50)
    public String getRecrutmentId() {
        return recrutmentId;
    }

    public void setRecrutmentId(String recrutmentId) {
        this.recrutmentId = recrutmentId;
    }

    @Basic
    @Column(name = "IsPass",nullable = true,length = 50)
    public String getIsPass() {
        return isPass;
    }

    public void setIsPass(String isPass) {
        this.isPass = isPass;
    }
    @Basic
    @Column(name = "UserName", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(id, resume.id) &&
                Objects.equals(name, resume.name) &&
                Objects.equals(workExperience, resume.workExperience) &&
                Objects.equals(skill, resume.skill) &&
                Objects.equals(recrutmentId, resume.recrutmentId) &&
                Objects.equals(userName, resume.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, workExperience, skill, recrutmentId, userName);
    }
}
