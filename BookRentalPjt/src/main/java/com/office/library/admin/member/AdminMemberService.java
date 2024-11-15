package com.office.library.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMemberService {
	
	final static public int ADMIN_ACCOUNT_ALREADY_EXIST = 0;	//이미 존재하는 ID
	final static public int ADMIN_ACCOUNT_CREATE_SUCCESS = 1;	//생성 성공
	final static public int ADMIN_ACCOUNT_CREATE_FAIL = -1;		//생성 실패
	
	@Autowired
	AdminMemberDao adminMemberDao;
	
	public int createAccountConfirm(AdminMemberVo adminMemberVo) {
		System.out.println("[AdminMemberService] createAccountconfirm()");
		
		boolean isMember = adminMemberDao.isAdminMember(adminMemberVo.getA_m_id());
		
		if (!isMember) {
			int result = adminMemberDao.insertAdminAccount(adminMemberVo);
			
			if (result > 0) return ADMIN_ACCOUNT_CREATE_SUCCESS;
			else return ADMIN_ACCOUNT_CREATE_FAIL;
		} else return ADMIN_ACCOUNT_ALREADY_EXIST;
	}

    public AdminMemberVo loginConfirm(AdminMemberVo adminMemberVo) {
		System.out.println("[AdminMemberService] loginConfirm()");

		AdminMemberVo loginedAdminMemberVo = adminMemberDao.selectAdmin(adminMemberVo);

		if (loginedAdminMemberVo != null) {
			System.out.println("[AdminMemberService] ADMIN MEMBER LOGIN SUCCESS!!");
		} else System.out.println("[AdminMemberService] ADMIN MEMBER LOGIN FAIL!");

		return loginedAdminMemberVo;
	}

	public List<AdminMemberVo> listupAdmin() {
		System.out.println("[AdminMemberService] listupAdmin()");

		return adminMemberDao.selectAdmins();
	}

	public void setAdminApproval(int a_m_no) {
		System.out.println("[AdminMemberService] setAdminApproval()");

		int result = adminMemberDao.updateAdminAccount(a_m_no);
	}
}
