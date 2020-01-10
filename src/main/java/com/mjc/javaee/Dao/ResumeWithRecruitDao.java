package com.mjc.javaee.Dao;

import com.mjc.javaee.Vo.ResumeWithRecruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}10:13
 */
public interface ResumeWithRecruitDao extends JpaRepository<ResumeWithRecruit,String> {
    @Query(value = "select Resume.ID,Resume.Name,RecrutmentID,Skill,UserName,WorkExperience,IsPass,Position.PositionName,Recruitment.Requires from Resume,Position,Recruitment where Resume.RecrutmentID = Recruitment.ID and Position.ID = Recruitment.PositionID and Resume.Name like %?1%",nativeQuery = true)
    List<ResumeWithRecruit> getByName(String name);

    @Query(value = "select Resume.ID,Resume.Name,RecrutmentID,Skill,UserName,WorkExperience,IsPass,Position.PositionName,Recruitment.Requires from Resume,Position,Recruitment where Resume.RecrutmentID = Recruitment.ID and Position.ID = Recruitment.PositionID and Resume.RecrutmentID = ?1",nativeQuery = true)
    List<ResumeWithRecruit> getByRecrutmentID(String id);

    @Query(value = "select Resume.ID,Resume.Name,RecrutmentID,Skill,UserName,WorkExperience,IsPass,Position.PositionName,Recruitment.Requires from Resume,Position,Recruitment where Resume.RecrutmentID = Recruitment.ID and Position.ID = Recruitment.PositionID and UserName = ?1",nativeQuery = true)
    List<ResumeWithRecruit> getByUserName(String id);
}
