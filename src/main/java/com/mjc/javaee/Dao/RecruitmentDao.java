package com.mjc.javaee.Dao;

import com.mjc.javaee.Entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}0:13
 */
public interface RecruitmentDao extends JpaRepository<Recruitment,String> {
    @Query(value = "update Recruitment set Num = Num - 1 where ID = ?1",nativeQuery = true)
    @Modifying
    void updateNum(String id);
}
