package com.office.library.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	
	@Autowired
	AdminMemberService adminMemberService;

	//로그인
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("[AdminMembercontroller] loginForm()");

		String nextPage = "admin/member/login_form";

		return nextPage;
	}

	//로그인 확인
	@PostMapping("/loginConfirm")
	public String loginConfirm(AdminMemberVo adminMemberVo, HttpSession session) {
		System.out.println("[AdminMembercontroller] loginConfirm()");

		String nextPage = "admin/member/login_ok";

		AdminMemberVo loginedAdminMemberVo = adminMemberService.loginConfirm(adminMemberVo);

		if(loginedAdminMemberVo == null) {
			nextPage = "admin/member/login_ng";
		} else {
			session.setAttribute("loginedAdminMemberVo", loginedAdminMemberVo);
			session.setMaxInactiveInterval(60 * 30);
		}

		return nextPage;
	}

	@RequestMapping(value = "/logoutConfirm", method = RequestMethod.GET)
	public String logoutConfirm(HttpSession session) {
		System.out.println("[AdminMembercontroller] logoutConfirm()");

		String nextPage = "redirect:/admin";

		session.invalidate();

		return nextPage;
	}
	
	//회원가입
	@RequestMapping(value = "/createAccountForm", method = RequestMethod.GET)
	public String createAccountForm() {
		System.out.println("[AdminMemberController] createAccountForm()");
		
		String nextPage = "admin/member/create_account_form";
		
		return nextPage;
	}
	
	//회원가입확인
	@PostMapping(value = "/createAccountConfirm")
	public String createAccountConfirm(AdminMemberVo adminMemberVo) {
		System.out.println("[AdminMemberController] createAccountConfirm()");
		
		String nextPage = "admin/member/create_account_ok";
		
		int result = adminMemberService.createAccountConfirm(adminMemberVo);
		
		if (result <= 0) nextPage = "admin/member/create_account_ng";
		
		return nextPage;
	}

	@RequestMapping(value = "/listupAdmin", method = RequestMethod.GET)
	public String listupAdmin(Model model) {
		System.out.println("[AdminMemberController] listupAdmin()");

		String nextPage = "admin/member/listup_admins";
		List<AdminMemberVo> adminMemberVos = adminMemberService.listupAdmin();

		model.addAttribute("adminMemberVos", adminMemberVos);

		return nextPage;
	}

	@RequestMapping(value = "/setAdminApproval", method = RequestMethod.GET)
	public String setAdminApproval(@RequestParam("a_m_no") int a_m_no) {
		System.out.println("[AdminMemberController] setAdmminApproval()");

		String nextPage = "redirect:/admin/member/listupAdmin";

		adminMemberService.setAdminApproval(a_m_no);

		return nextPage;
	}
}
