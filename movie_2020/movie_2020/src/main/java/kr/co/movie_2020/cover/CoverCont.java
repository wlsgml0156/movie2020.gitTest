package kr.co.movie_2020.cover;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;

@Controller
public class CoverCont {

	@Autowired
	CoverDAO dao;

	@RequestMapping(value = "cover/intro.do")
	public ModelAndView intro(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cover/cover");

		String imonth = req.getParameter("imonth");
		if (imonth == null) {
			imonth = "01";
			mav.addObject("msg1", imonth);
			mav.addObject("list", dao.list(imonth));
		} else {
			mav.addObject("msg1", imonth);
			imonth = null;
			dao.list(imonth);
			imonth = req.getParameter("imonth");
			dao.list(imonth);
			if (dao.list(imonth) != null) {
				mav.addObject("list", dao.list(imonth));
			} else {
				mav.addObject("msg2", "<h4>선택하신 2020년 해당월에 확인되는 개봉영화가 없습니다.<br>" + "다른 날짜를 선택해 주세요.</h4>");
			}
		} // if end

		return mav;
	} // intro() end

	@RequestMapping(value = "cover/movieAdd.do", method = RequestMethod.GET)
	public String create() {
		return "cover/coverForm";
	} //create() end

	@RequestMapping(value = "cover/movieAdd.do", method = RequestMethod.POST)
	public ModelAndView createProc(HttpServletRequest req, CoverDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cover/cover");
		String imonth = req.getParameter("irlsDate").substring(5, 7);
		System.out.println("i_month" + imonth);
		dto.setImonth(imonth);

		String basePath = req.getRealPath("/cover/storage");
		MultipartFile posterMF = dto.getPosterMF();
		String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);
		dto.setPoster(poster);
		dao.create(dto);

		return mav;
	} // createProc() end

	@RequestMapping(value = "cover/deatil.do")
	public ModelAndView movieInfo(HttpServletRequest req, CoverDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cover/movieInfo");

		int imovieno = Integer.parseInt(req.getParameter("imovieno"));

		dto = dao.movieDetail(imovieno);
		String content = dto.getIcontent();
		content = content.replace("\n", "<br/>");
		content = content.replace(" ", "&nbsp;");
		dto.setIcontent(content);

		mav.addObject("dto", dto);
		
		return mav;
	} // movieInfo() end

	@RequestMapping(value = "cover/mdfy.do", method = RequestMethod.GET)
	public ModelAndView update(CoverDTO dto, HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cover/updateForm");
		
		int imovieno = Integer.parseInt(req.getParameter("imovieno"));

		mav.addObject("dto", dao.movieDetail(imovieno));

		return mav;
	} // update() end

	@RequestMapping(value = "cover/mdfy.do", method = RequestMethod.POST)
	public ModelAndView updateProc(CoverDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cover/msgView");
		String basePath = req.getRealPath("/cover/storage");

		int imovieno = Integer.parseInt(req.getParameter("imovieno"));
		CoverDTO oldDTO = dao.movieDetail(imovieno);
		MultipartFile posterMF = dto.getPosterMF();

		if (posterMF.getSize() > 0) {
			UploadSaveManager.deleteFile(basePath, oldDTO.getPoster());
			String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);
			dto.setPoster(poster);
		} else {
			dto.setPoster(oldDTO.getPoster());
		} // if end

		int cnt = dao.update(dto);
		
		if (cnt == 0) {
			mav.addObject("msg", "영화 수정 실패");
			mav.addObject("link1", "<p><a href='javascript:history.back()'>[다시시도]</a></p>");
		} else {
			mav.addObject("msg", "영화 수정 성공");
			mav.addObject("link1",
					"<input type='button' value='개봉⦁상영영화 보러가기' class='btn btn-success'  onclick='location.href=\"../cover/intro.do\"'>");

		}// if end

		return mav;
	} // updateProc() end

	@RequestMapping(value = "cover/del.do")
	public ModelAndView deleteProc(CoverDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cover/msgView");

		int imovieno = Integer.parseInt(req.getParameter("imovieno"));
		System.out.println(imovieno);
		CoverDTO oldDTO = dao.movieDetail(imovieno);

		int cnt = dao.delete(dto.getImovieno());
		if (cnt == 0) {
			mav.addObject("msg", "<p>영화 게시글 삭제 실패</p>");
			mav.addObject("link1", "<input type='button' value='돌아가기' onclick='javascript:history.back()'>");

		} else {
			String basepath = req.getRealPath("/media/storage");
			UploadSaveManager.deleteFile(basepath, oldDTO.getPoster());
			mav.addObject("msg", "<p>영화 게시글 삭제 성공</p>");
			mav.addObject("link1",
					"<input type='button' value='개봉⦁상영영화 보러가기' class='btn btn-success'  onclick='location.href=\"../cover/intro.do\"'>");

		} // if end

		return mav;
	} // deleteProc() end

}
