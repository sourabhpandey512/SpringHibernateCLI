package in.ineuron.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.StudentBO;
import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.StudentDTO;
@Service
public class IStudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentDao dao;

	@Override
	public int addData(StudentDTO dto) {
		// TODO Auto-generated method stub
		StudentBO stdbo=new StudentBO();
		System.out.println("Student DTO Object");
		System.out.println(dto.getSname()+" "+dto.getSaddress()+" "+dto.getSage());
		BeanUtils.copyProperties(dto,stdbo);
		System.out.println(stdbo);
		
		return dao.addDaoData(stdbo);
		
	}

	@Override
	public String deleteData(int i) {
		// TODO Auto-generated method stub
		return dao.deleteDaoData(i);
	}

	@Override
	public StudentDTO getData(int i) {
		// TODO Auto-generated method stub
		StudentDTO stdto=new StudentDTO();
		StudentBO stdbo=dao.getDaoData(i);
		System.out.println(stdbo);
		BeanUtils.copyProperties(stdbo, stdto);
		stdto.setId(stdbo.getSid());
		return stdto;
	}

	@Override
	public String updateData(StudentDTO dto) {
		// TODO Auto-generated method stub
		StudentBO stdbo=new StudentBO();
		BeanUtils.copyProperties(stdbo, dto);
		return dao.updateDaoData(stdbo);
	}

}
