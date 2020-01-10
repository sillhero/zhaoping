package com.mjc.javaee.Dao;

import com.mjc.javaee.Entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}16:32
 */
public interface PositionDao extends JpaRepository<Position,String> {
    @Query(value = "select * from Position where PositionName like %?1%",nativeQuery = true)
    List<Position> getByName(String name);
}
