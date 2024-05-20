package net.smkz.springbootpractice.service;

import java.util.List;

import net.smkz.springbootpractice.dto.StaffDTO;
import net.smkz.springbootpractice.entity.StaffInfo;

public interface IDemoService {

	public String hello();
	
	public List<String> getList();
	
	public List<StaffInfo> getAllStaff();
	
	public StaffDTO createStaff();
}
