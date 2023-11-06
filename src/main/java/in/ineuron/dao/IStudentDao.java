package in.ineuron.dao;

import in.ineuron.bo.StudentBO;

public interface IStudentDao {
	public int addDaoData(StudentBO stdbo);
	public String deleteDaoData(int i);
	public StudentBO getDaoData(int i);
	public String updateDaoData(StudentBO stdbo);
}
