package com.mjc.javaee.Dao;

import com.mjc.javaee.Entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}10:14
 */
public interface ResumeDao extends JpaRepository<Resume,String> {
    @Query(value = "update Resume set Ispass = '审核通过' where ID = ?1",nativeQuery = true)
    @Modifying
    void updatPass(String id);

    @Query(value = "select * from Resume where ID = ?1",nativeQuery = true)
    Resume getByID(String id);
}
