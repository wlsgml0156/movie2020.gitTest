function loginReady() {
	alert("로그인이 필요합니다.");
	return true;
}

function loginCheck(f) {
	// 로그인 유효성 검사(과제)
	// 1) 아이디 5~10글자 이내
	var m_id = f.m_id.value;
	m_id = m_id.trim();
	if (m_id.length < 5 || m_id.length > 10) {
		alert("아이디를 입력해주세요.")
		return false;
	}
	// 2) 비밀번호 4~10글자 이내

	var m_pwd = f.m_pwd.value;
	m_pwd = m_pwd.trim();
	if (m_pwd.length < 4 || m_pwd.length > 10) {
		alert("비밀번호를 입력해주세요.")
		return false;
	}

	return true;

}// loginCheck() end

function memberCheck(f) {

	// 회원가입 유효성 검사
	// 1)아이디 5~10글자 이내인지?
	var m_id = f.m_id.value;
	m_id = m_id.trim();
	if (m_id.length < 5 || m_id.length > 10) {
		alert("아이디 5~10글자 이내로 입력해 해주세요.");
		return false;
	}

	// 2)비밀번호 4~10글자 이내인지?
	var m_pwd = f.m_pwd.value;
	m_pwd = m_pwd.trim();
	if (m_pwd.length < 4 || m_pwd.length > 10) {
		alert("비밀번호 4~10글자 이내로 입력해 해주세요.");
		return false;
	}

	var m_name = f.m_name.value;
	m_name = m_name.trim();
	if (m_name.length == 0) {
		alert("이름을 입력해주세요.");
		return false;
	}

	var m_email = f.m_email.value;
	m_email = m_email.trim();
	at2 = m_email.indexOf("@");
	if (m_email.length == 0) {
		alert("이메일을 적어주세요.");
		return false;
	} else if (at2 == -1) {
		alert("이메일 형식으로 적어주세요.");
		return false;
	} else if (m_email.slice(0, m_email.indexOf("@")).length < 1) {
		alert("이메일 형식으로 적어주세요.");
		return false;
	}
	return true;

}// memberCheck() end

function reviewCheck(f) {
	var subject = f.subject.value;
	subject = subject.trim();
	if (subject.length == 0) {
		alert("제목을 입력해주세요.");
		return false;
	}

	var content = f.content.value;
	content = content.trim();
	if (content.length == 0) {
		alert("내용을 입력해주세요.");
		return false;
	}

	return true;
} // reviewCheck() end

function coverCheck(f) {

	var ititle = f.ititle.value;
	ititle = ititle.trim();
	if (ititle.length == 0) {
		alert("제목을 입력해주세요.");
		return false;
	}

	var igenre = f.igenre.value;
	igenre = igenre.trim();
	if (igenre.length == 0) {
		alert("장르를 입력해주세요.");
		return false;
	}

	var iforeman = f.iforeman.value;
	iforeman = iforeman.trim();
	if (iforeman.length == 0) {
		alert("감독을 입력해주세요.");
		return false;
	}

	var icast = f.icast.value;
	icast = icast.trim();
	if (icast.length == 0) {
		alert("출연진을 입력해주세요.");
		return false;
	}

	var posterMF = f.posterMF.value;
	posterMF = posterMF.trim();
	if (posterMF.length == 0) {
		alert("포스터를 입력해주세요.");
		return false;
	}

	var icontent = f.icontent.value;
	icontent = icontent.trim();
	if (icontent.length == 0) {
		alert("줄거리를 입력해주세요.");
		return false;
	}

	var irlsDate = f.irlsDate.value;
	irlsDate = irlsDate.trim();
	dot = irlsDate.indexOf(".");
	var year = irlsDate.slice(0, 3);
	if (irlsDate.length < 10) {
		alert("개봉날짜를 제대로  입력해주세요.");
		return false;
	} else if (dot != 4) {
		alert("개봉날짜를 제대로 입력해주세요.");
		return false;
	}

	return true;

}
