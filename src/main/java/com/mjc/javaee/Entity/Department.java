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
public class Department {
    private String id;
    private String departmentName;
    private String leader;

    @Id
    @Column(name = "ID", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DepartmentName", nullable = true, length = 50)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Basic
    @Column(name = "Leader", nullable = true, length = 50)
    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(leader, that.leader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentName, leader);
    }
}
