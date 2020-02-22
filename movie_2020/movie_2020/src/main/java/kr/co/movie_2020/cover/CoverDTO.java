package kr.co.movie_2020.cover;

import org.springframework.web.multipart.MultipartFile;

public class CoverDTO {
	private String ititle;
	private String igenre;
	private String iforeman;
	private String icast;
	private String irlsDate;
	private String imonth;
	private String irating;
	private String icontent;
	private String poster;
	private long filesize;
	private int imovieno;
	private MultipartFile posterMF;

	public String getItitle() {
		return ititle;
	}

	public void setItitle(String ititle) {
		this.ititle = ititle;
	}

	public String getIgenre() {
		return igenre;
	}

	public void setIgenre(String igenre) {
		this.igenre = igenre;
	}

	public String getIforeman() {
		return iforeman;
	}

	public void setIforeman(String iforeman) {
		this.iforeman = iforeman;
	}

	public String getIcast() {
		return icast;
	}

	public void setIcast(String icast) {
		this.icast = icast;
	}

	public String getIrlsDate() {
		return irlsDate;
	}

	public void setIrlsDate(String irlsDate) {
		this.irlsDate = irlsDate;
	}
	
	

	public String getImonth() {
		return imonth;
	}

	public void setImonth(String imonth) {
		this.imonth = imonth;
	}

	public String getIrating() {
		return irating;
	}

	public void setIrating(String irating) {
		this.irating = irating;
	}

	public String getIcontent() {
		return icontent;
	}

	public void setIcontent(String icontent) {
		this.icontent = icontent;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public int getImovieno() {
		return imovieno;
	}

	public void setImovieno(int imovieno) {
		this.imovieno = imovieno;
	}

	public MultipartFile getPosterMF() {
		return posterMF;
	}

	public void setPosterMF(MultipartFile posterMF) {
		this.posterMF = posterMF;
	}

	@Override
	public String toString() {
		return "CoverDTO [ititle=" + ititle + ", igenre=" + igenre + ", iforeman=" + iforeman + ", icast=" + icast
				+ ", irlsDate=" + irlsDate + ", irating=" + irating + ", icontent=" + icontent + ", poster=" + poster
				+ ", filesize=" + filesize + ", imovieno=" + imovieno + ", posterMF=" + posterMF + "]";
	}

	public CoverDTO() {
	}

}
