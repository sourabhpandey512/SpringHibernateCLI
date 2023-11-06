package in.ineuron.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.StudentBO;
@Repository
@Transactional
public class IStudentDaoImpl implements IStudentDao {
    @Autowired
	HibernateTemplate hibernate;
	@Override
	public int addDaoData(StudentBO stdbo) {
		
		
		return (int)hibernate.save(stdbo);
		
	}
	@Override
	public String deleteDaoData(int i) {
		// TODO Auto-generated method stub
		StudentBO stdbo=hibernate.get(StudentBO.class,i);
		hibernate.delete(stdbo);
		return "success";
		

	}
	@Override
	public StudentBO getDaoData(int i) {
		// TODO Auto-generated method stub
		StudentBO stdbo=hibernate.get(StudentBO.class,i);
		return stdbo;
	}
	@Override
	public String updateDaoData(StudentBO stdbo) {
		// TODO Auto-generated method stub
		hibernate.update(stdbo);
		
		return "success";
	}
	

}
