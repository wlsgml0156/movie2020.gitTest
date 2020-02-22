package kr.co.movie_2020.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberCont {

	@Autowired
	private MemberDAO dao;

	@RequestMapping(value = "member/login.do", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/loginForm");
		return mav;
	} // login() end

	@RequestMapping(value = "member/login.do", method = RequestMethod.POST)
	public ModelAndView loginPro(MemberDTO dto, HttpServletRequest req, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/msgView");

		String m_id = dao.loginProc(dto);

		if (m_id.equals("guest")) {
			mav.addObject("msg", "<p>아이디/비번 다시 한번 확인해주세요!!</p>");
			mav.addObject("link1",
					"<input type='button' class='btn btn-success' value='돌아가기' onclick='javascript:history.back()'>");
		} else {
			session.setAttribute("s_id", m_id);

			mav.addObject("msg", "<h3>로그인성공</h3>");
			mav.addObject("link1",
					"<input type='button' class='btn btn-success' value='홈으로'  onclick='location.href=\"../\"'>");

		}

		return mav;
	} // loginPro() end

	@RequestMapping(value = "member/memberJoin.do", method = RequestMethod.GET)
	public String join() {
		return "member/joinForm";
	} // join() end

	@RequestMapping(value = "member/memberJoin.do", method = RequestMethod.POST)
	public ModelAndView joinProc(HttpServletRequest req, MemberDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/msgView");

		int cnt = dao.joinIns(dto);
		if (cnt == 0) {
			mav.addObject("msg", "<h3>회원가입 실패</h3>");
			mav.addObject("link1",
					"<input type='button' class='btn btn-success' value='돌아가기' onclick='javascript:history.back()'>");
		} else {
			mav.addObject("msg", "<h3>회원가입 성공</h3>");
			mav.addObject("link1",
					"<input type='button' class='btn btn-success' value='로그인하러가기'  onclick='location.href=\"../member/login.do\"'>");
		}
		return mav;
	} // joinProc() end

	@RequestMapping("member/idcheck.do")
	public void idCheck(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String m_id = req.getParameter("m_id").trim();
			String message = "";
			if (m_id.length() < 5 || m_id.length() >= 11) {
				message = "<span style='color:red;font-weight:bold'>아이디는 5~10글자 이내 입력해 주세요!!</span>";
			} else {

				MemberDAO dao = new MemberDAO();
				
				int cnt = dao.duplecateID(m_id);
				
				if (cnt == 0) {
					message = "<span style='color:blue;font-weight:bold'>사용가능한 아이디 입니다</span>";
				} else {
					message = "<span style='color:green;font-weight:bold'>중복된 아이디 입니다</span>";
				} // if end

			} // if end

			resp.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println(message);
			out.flush();
			out.close();

		} catch (Exception e) {
			System.out.println("응답실패:" + e);
		}
	}// idCheck() end

	@RequestMapping("member/pwdcheck.do")
	public void pwdCheck(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String m_pwd = req.getParameter("m_pwd").trim();
			String message = "";
			if (m_pwd.length() < 4 || m_pwd.length() >= 11) {
				message = "<span style='color:red;font-weight:bold'>비밀번호는 4~10글자 이내 입력해 주세요!!</span>";
			}

			resp.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println(message);
			out.flush();
			out.close();

		} catch (Exception e) {
			System.out.println("응답실패:" + e);
		}
	}// pwdCheck() end

	@RequestMapping(value = "member/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/loginForm";
	} // logout() end

	@RequestMapping(value = "member/myinfo.do", method = RequestMethod.GET)
	public ModelAndView myInfo(HttpSession session, Model model, MemberDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/info");
		String m_id = (String) session.getAttribute("s_id");

		MemberDTO user = dao.myInfo(m_id);
		mav.addObject("m_id", user.getM_id());
		mav.addObject("m_pwd", user.getM_pwd());
		mav.addObject("m_name", user.getM_name());
		mav.addObject("m_email", user.getM_email());

		return mav;
	} // myInfo() end

	@RequestMapping(value = "member/myInfoChange.do")
	public ModelAndView update(HttpSession session, Model model, MemberDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/updateForm");
		String m_id = (String) session.getAttribute("s_id");

		MemberDTO user = dao.myInfo(m_id);
		mav.addObject("m_id", user.getM_id());
		mav.addObject("m_pwd", user.getM_pwd());
		mav.addObject("m_name", user.getM_name());
		mav.addObject("m_email", user.getM_email());
		return mav;

	} // update() end

	@RequestMapping(value = "member/myInfoChangeOK.do")
	public ModelAndView updateProc(HttpSession session, Model model, MemberDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/msgView");
		int cnt = dao.myinfoUpdate(dto);

		if (cnt == 0) {
			mav.addObject("msg", "<h3>정보수정 실패</h3>");
			mav.addObject("link1",
					"<input type='button' class='btn btn-success' value='돌아가기' onclick='javascript:history.back()'>");
		} else {
			mav.addObject("msg", "<h3>정보수정 성공</h3>");
			mav.addObject("link1",
					"<input type='button' class='btn btn-success' value='홈으로'  onclick='location.href=\"../\"'>");
		}
		return mav;

	} // update() end

	@RequestMapping(value = "member/memberScsn.do", method = RequestMethod.GET)
	public String checkPwd() {
		return "member/checkPwd";
	}// checkPwd() end

	@RequestMapping(value = "member/memberScsn.do", method = RequestMethod.POST)
	public ModelAndView scsn(HttpSession session, MemberDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/msgView");
		String m_id = (String) session.getAttribute("s_id");
		String m_pwd = dao.checkPw(dto);

		int cnt = dao.delete(m_id, m_pwd);
		if (cnt == 0) {
			mav.addObject("msg", "<h3>회원탈퇴 실패</h3>");
			mav.addObject("link1",
					"<input type='button' class='btn btn-success' value='돌아가기' onclick='javascript:history.back()'>");
		} else {
			mav.addObject("msg", "<h3>회원탈퇴 성공</h3>");
			mav.addObject("link1",
					"<input type='button' class='btn btn-success' value='홈으로'  onclick='location.href=\"../\"'>");
			session.invalidate();
		}

		return mav;
	}// checkPwd() end

}
