package cn.java.personal.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.java.personal.dao.WorkMapper;
import cn.java.personal.pojo.Work;
import cn.java.personal.service.WorkService;

/**
*@author：zym
*@version：
*@time：2018年6月8日上午12:20:16
*/
@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkMapper wm=null;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int insertWork(Work work) {
		// TODO Auto-generated method stub
		return wm.insertWork(work);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int updateWork(Work work) {
		// TODO Auto-generated method stub
		return wm.updateWork(work);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public ArrayList<Work> queryWork(int userId) {
		// TODO Auto-generated method stub
		return wm.queryWork(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int deleteWorks(int userId) {
		// TODO Auto-generated method stub
		return wm.deleteWorks(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int deleteWork(int id) {
		// TODO Auto-generated method stub
		return wm.deleteWork(id);
	}

}
