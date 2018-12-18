package cn.java.personal.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import cn.java.personal.pojo.Award;

/**
*@author：zym
*@version：
*@time：2018年6月7日下午3:26:28
*/
@Repository
public interface AwardMapper {

	public int insertAward(Award award);
	public int updateAward(Award award);
	public ArrayList<Award> queryAward(int userId);
	public int deleteAwards(int userId);
	public int deleteAward(int Id);
}
