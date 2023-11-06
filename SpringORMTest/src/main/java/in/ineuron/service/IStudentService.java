package in.ineuron.service;

import org.springframework.stereotype.Service;

import in.ineuron.dto.StudentDTO;
@Service
public interface IStudentService {
public int addData(StudentDTO dto);
public String deleteData(int i);
public StudentDTO getData(int i);
public String updateData(StudentDTO dto);
}
