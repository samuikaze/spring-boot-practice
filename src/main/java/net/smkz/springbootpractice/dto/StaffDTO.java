package net.smkz.springbootpractice.dto;

import lombok.Data;

@Data
public class StaffDTO {
	private Integer id;
	private String email;
	private String phone;
	private String position;
}
