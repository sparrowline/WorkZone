package com.jsp.workZone.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.Admin;
import com.jsp.workZone.repo.AdminRepo;
import com.jsp.workZone.util.AES_workZone;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepo adminRepo;

	public Admin saveAdmin(Admin admin) {

		admin.setPwd(AES_workZone.encrypt(admin.getPwd()));

		return adminRepo.save(admin);
	}

	public Admin findAdminById(int id) {

		if (adminRepo.findById(id).isPresent()) {
			Admin admin = adminRepo.findById(id).get();
			admin.setPwd(AES_workZone.decrypt(admin.getPwd()));
			return admin;

		} else {
			return null;
		}
	}

	public Admin updateAdmin(Admin admin) {
		if (adminRepo.findById(admin.getId()).isPresent()) {
			Admin db = adminRepo.findById(admin.getId()).get();

			if (admin.getAddress() == null) {
				admin.setAddress(db.getAddress());
			}
			if (admin.getEmail() == null) {
				admin.setEmail(db.getEmail());
			}
			if (admin.getGender() == null) {
				admin.setGender(db.getGender());
			}
			if (admin.getName() == null) {
				admin.setName(db.getName());
			}
			if (admin.getPhone() == 0) {
				admin.setPhone(db.getPhone());
			}
			if (admin.getPwd() == null) {
				admin.setPwd(db.getPwd());
			}
			return adminRepo.save(admin);
		}
		return null;
	}

	

}
