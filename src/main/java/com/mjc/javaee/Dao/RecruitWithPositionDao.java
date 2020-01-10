package com.mjc.javaee.Dao;

import com.mjc.javaee.Vo.RecruitmentWithPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}0:35
 */
public interface RecruitWithPositionDao extends JpaRepository<RecruitmentWithPosition,String> {
    @Query(value = "select Recruitment.ID,Num,PositionID,Requires,Position.PositionName,Position.PositionSalary from Recruitment,Position where Recruitment.PositionID = Position.ID and Position.PositionName like %?1%",nativeQuery = true)
    List<RecruitmentWithPosition> getByName(String name);
}
