package cn.java.personal.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.java.personal.dao.AwardMapper;
import cn.java.personal.pojo.Award;
import cn.java.personal.service.AwardService;

/**
*@author：zym
*@version：
*@time：2018年6月8日上午12:01:13
*/
@Service
public class AwardServiceImpl implements AwardService {

	@Autowired
	private AwardMapper awardMapper=null;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int insertAward(Award award) {
		// TODO Auto-generated method stub
		return awardMapper.insertAward(award);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int updateAward(Award award) {
		// TODO Auto-generated method stub
		return awardMapper.updateAward(award);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public ArrayList<Award> queryAward(int userId) {
		// TODO Auto-generated method stub
		return awardMapper.queryAward(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int deleteAwards(int userId) {
		// TODO Auto-generated method stub
		return awardMapper.deleteAwards(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int deleteAward(int Id) {
		// TODO Auto-generated method stub
		return awardMapper.deleteAward(Id);
	}

}
