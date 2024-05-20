package net.smkz.springbootpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.smkz.springbootpractice.entity.StaffInfo;

@Repository
public interface IStaffRepository extends JpaRepository<StaffInfo, Integer> {

}
