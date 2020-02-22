package kr.co.movie_2020.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReviewCont {

	@Autowired
	ReviewDAO dao;

	@RequestMapping(value = "/review/review.do")
	public String pagingList(HttpServletRequest req) throws ServletException, IOException {
		String paramPage = req.getParameter("page"); 
		String paramListCount = req.getParameter("listCount"); 
		String paramPageCount = req.getParameter("pageCount"); 

		int page;
		if (paramPage == null) {
			page = 1;
		} else {
			page = Integer.parseInt(paramPage);
		} // if end

		int listCount;
		if (paramListCount == null) {
			listCount = 10;
		} else {
			listCount = Integer.parseInt(paramListCount);
		} // if end

		int pageCount;
		if (paramPageCount == null) {
			pageCount = 10;
		} else {
			pageCount = Integer.parseInt(paramPageCount);
		} // if end


		int totalCount = dao.totalCount();

		PageInfo pageInfo = new PageInfo(page, listCount, pageCount, totalCount);
		int startNum = pageInfo.getStartNum();
		int endNum = pageInfo.getEndNum();

		ArrayList<ReviewDTO> list = dao.pagedList(startNum, endNum);
		
		req.setAttribute("list", list);
		req.setAttribute("pageInfo", pageInfo);

		return "review/reviewBbs";

	} // pagingList() end

	@RequestMapping(value = "/review/reviewAdd.do", method = RequestMethod.GET)
	public String create() {
		return "review/reviewForm";
	} // create() end

	@RequestMapping(value = "/review/reviewAdd.do", method = RequestMethod.POST)
	public ModelAndView createProc(HttpSession session, ReviewDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("review/msgView");
		int cnt = dao.create(dto);
		if (cnt == 0) {
			mav.addObject("msg", "<h3>게시글추가 실패</h3>");
			mav.setViewName("review/reviewBbs");
		} else {
			mav.addObject("msg", "<h3>게시글추가 성공</h3>");
			mav.addObject("link1",
					"<input type='button'  class='btn btn-success' value='리뷰 보러가기'  onclick='location.href=\"../review/review.do\"'>");
		} // if end

		return mav;
	} // createProc() end

	@RequestMapping(value = "/review/detail.do")
	public ModelAndView detail(ReviewDTO reviewDto, Model model, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/reviewDetail");
		int bbsno = Integer.parseInt(req.getParameter("bbsno"));
		dao.incrementCnt(bbsno);
		mav.addObject("list", dao.selectOne(bbsno));
		
		return mav;
	} // detail() end

	@RequestMapping(value = "/review/mdfy.do", method = RequestMethod.GET)
	public ModelAndView update(ReviewDTO reviewDto, Model model, HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/reviewInfo");
		int bbsno = Integer.parseInt(req.getParameter("bbsno"));

		ReviewDTO dto = dao.reviewInfo(bbsno);
		mav.addObject("wname", dto.getWname());
		mav.addObject("subject", dto.getSubject());
		mav.addObject("content", dto.getContent());
		mav.addObject("bbsno", dto.getBbsno());

		return mav;
	} //update() end

	@RequestMapping(value = "/review/mdfy.do", method = RequestMethod.POST)
	public ModelAndView updateProc(ReviewDTO reviewDto, Model model, HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/msgView");

		int bbsno = Integer.parseInt(req.getParameter("bbsno"));

		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		ReviewDTO dto = new ReviewDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		int cnt = dao.reviewInfoChange(dto, bbsno);

		if (cnt == 0) {
			mav.addObject("msg", "<h3>게시글수정 실패</h3>");
			mav.addObject("link1",
					"<input type='button' class='btn btn-success' value='돌아가기' onclick='javascript:history.back()'>");
		} else {
			mav.addObject("msg", "<h3>게시글수정 성공</h3>");
			mav.addObject("link1",
					"<input type='button'  class='btn btn-success' value='리뷰 보러가기'  onclick='location.href=\"../review/review.do\"'>");
		} // if end

		return mav;
	} // updateProc() end

	@RequestMapping(value = "/review/del.do")
	public ModelAndView delete(ReviewDTO reviewDto, Model model, HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/msgView");

		int bbsno = Integer.parseInt(req.getParameter("bbsno"));
		int cnt = dao.delete(bbsno);
		if (cnt == 0) {
			mav.addObject("msg", "<h3>게시글삭제 실패</h3>");
			mav.addObject("link1",
					"<input type='button' class='btn btn-success' value='돌아가기' onclick='javascript:history.back()'>");
		} else {
			mav.addObject("msg", "<h3>게시글삭제 성공</h3>");
			mav.addObject("link1",
					"<input type='button'  class='btn btn-success' value='리뷰 보러가기'  onclick='location.href=\"../review/review.do\"'>");
		} // if end
	
		return mav;
	} // delete()end
	
}
