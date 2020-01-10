package com.mjc.javaee.Service;

import com.mjc.javaee.Dao.RecruitWithPositionDao;
import com.mjc.javaee.Dao.RecruitmentDao;
import com.mjc.javaee.Entity.Recruitment;
import com.mjc.javaee.Vo.RecruitmentWithPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}0:12
 */
@Service
@Transactional
public class RecruitmentService {
    @Autowired
    RecruitmentDao recruitmentDao;
    @Autowired
    RecruitWithPositionDao recruitWithPositionDao;
    public void addRecruitment(Recruitment recruitment){
        recruitmentDao.save(recruitment);
    }

    public List<RecruitmentWithPosition> selectByName(String name){
       return recruitWithPositionDao.getByName(name);
    }

    public void deleteByID(String id){
        recruitmentDao.deleteById(id);
    }

    public void updateNum(String id){
        recruitmentDao.updateNum(id);
    }
}
