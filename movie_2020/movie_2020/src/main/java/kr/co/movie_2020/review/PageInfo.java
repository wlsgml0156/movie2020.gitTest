package kr.co.movie_2020.review;

public class PageInfo {
	
	private int page;      
    private int listCount; 
    private int pageCount; 
    private int totalCount;
    private int startNum;  
    private int endNum;  
    private int totalPage; 
    private int startPage; 
    private int endPage; 
    private int nextPage;
    private int prevPage;
        
    public PageInfo(int page, int listCount, int pageCount, int totalCount) {
        this.page = page;
        this.listCount = listCount;
        this.pageCount = pageCount;
        this.totalCount = totalCount;
        
        totalPage = totalCount / listCount;
        if (totalCount % listCount > 0) {
            totalPage++;
        }
 
        if (totalPage < page) {
            page = totalPage;
        }
 
        startPage = ((page - 1) / pageCount) * pageCount + 1;
        endPage = startPage + pageCount - 1;
 
        if (endPage > totalPage) {
            endPage = totalPage;
        }
 
        startNum = (page - 1) * listCount + 1;
        endNum = page * listCount;
        
        nextPage = endPage + 1;
        prevPage = startPage - 1;
    }

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
 
    
    
}
