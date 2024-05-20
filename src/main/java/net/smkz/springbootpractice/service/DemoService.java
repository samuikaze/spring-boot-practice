package net.smkz.springbootpractice.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.smkz.springbootpractice.dto.StaffDTO;
import net.smkz.springbootpractice.entity.StaffInfo;
import net.smkz.springbootpractice.repository.IStaffRepository;

@Component
public class DemoService implements IDemoService {
	
	@Autowired
	private IStaffRepository staffRepository;
	
	public String hello() {
		return "Hello spring boot.";
	}
	
	public List<String> getList() {
		List<String> list = new LinkedList<>();
		list.add("123");
		
		return list;
	}
	
	public List<StaffInfo> getAllStaff() {
		return this.staffRepository.findAll();
	}
	
	public StaffDTO createStaff() {
		StaffInfo staffInfo = new StaffInfo();
		staffInfo.setEmail("test1@example.com");
		staffInfo.setPhone("012345678");
		staffInfo.setPassword("77777");
		staffInfo.setPosition("0");
		
		var result = staffRepository.save(staffInfo);
		
		StaffDTO newStaff = new StaffDTO();
		newStaff.setId(result.getId());
		newStaff.setPhone(result.getPhone());
		newStaff.setEmail(result.getEmail());
		newStaff.setPosition(result.getPosition());
		
		return newStaff;
	}
}
