package com.mjc.javaee.Service;

import com.mjc.javaee.Dao.ResumeDao;
import com.mjc.javaee.Dao.ResumeWithRecruitDao;
import com.mjc.javaee.Entity.Resume;
import com.mjc.javaee.Vo.ResumeWithRecruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName recruitment_system
 * @Description: TODO
 * @date ${DAT}10:15
 */
@Service
@Transactional
public class ResumeService {
    @Autowired
    ResumeDao resumeDao;
    @Autowired
    ResumeWithRecruitDao resumeWithRecruitDao;

    public void addResume(Resume resume){
        resumeDao.save(resume);
    }

    public List<ResumeWithRecruit> selectAllByName(String name){
        return resumeWithRecruitDao.getByName(name);
    }

    public void updateResume(Resume resume){
        resumeDao.save(resume);
    }

    public void deleteResume(String id){
        resumeDao.deleteById(id);
    }

    public List<ResumeWithRecruit> selectByRecrutmentID(String id){
        return resumeWithRecruitDao.getByRecrutmentID(id);
    }

    public void updatePass(String id){
        resumeDao.updatPass(id);
    }

    public Resume getByID(String id){
        return resumeDao.getByID(id);
    }

    public List<ResumeWithRecruit> getByUserName(String username){
        return resumeWithRecruitDao.getByUserName(username);
    }
}
