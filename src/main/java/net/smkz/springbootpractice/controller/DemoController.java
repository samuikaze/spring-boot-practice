package net.smkz.springbootpractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.smkz.springbootpractice.dto.StaffDTO;
import net.smkz.springbootpractice.entity.StaffInfo;
import net.smkz.springbootpractice.service.IDemoService;

@Controller
public class DemoController {
	@Autowired
	private IDemoService demoService;
	
	@GetMapping("/")
	@ResponseBody
	public String hello() {
		return this.demoService.hello();
	}
	
	@GetMapping("/list/method1")
	@ResponseBody
	public List<String> getList() {
		return this.demoService.getList();
	}
	
	@GetMapping("/list/method2")
	public ResponseEntity<List<String>> getList2() {
		return new ResponseEntity<List<String>>(
			this.demoService.getList(),
			HttpStatus.OK);
	}
	
	@GetMapping("/list/method3")
	public ResponseEntity<List<String>> getList3() {
		return ResponseEntity
				.ok()
				.header("Content-Type", "application/json")
				.body(this.demoService.getList());
	}
	
	@GetMapping("/list/staff")
	@ResponseBody
	public List<StaffInfo> getAllStaff() {
		return this.demoService.getAllStaff();
	}
	
	@GetMapping("/staff")
	@ResponseBody
	public StaffDTO createStaff() {
		return this.demoService.createStaff();
	}
}
