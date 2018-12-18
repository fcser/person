package cn.java.personal.service;

import java.util.ArrayList;

import cn.java.personal.pojo.Award;

/**
*@author：zym
*@version：
*@time：2018年6月7日下午11:58:31
*/
public interface AwardService {

	public int insertAward(Award award);
	public int updateAward(Award award);
	public ArrayList<Award> queryAward(int userId);
	public int deleteAwards(int userId);
	public int deleteAward(int Id);
}
