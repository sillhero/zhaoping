package com.mjc.javaee.Service;

import com.mjc.javaee.Dao.PositionDao;
import com.mjc.javaee.Entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}16:36
 */
@Service
@Transactional
public class PositionService {
    @Autowired
    PositionDao positionDao;

    public void addPosition(Position position){
        positionDao.save(position);
    }

    public List<Position> selectAll(){
        return positionDao.findAll();
    }

    public void deletByID(String id){
        positionDao.deleteById(id);
    }

    public void update(Position position){
        positionDao.save(position);
    }

    public List<Position> getByName(String name){
        return positionDao.getByName(name);
    }
}
