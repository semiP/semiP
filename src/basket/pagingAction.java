package basket;

public class pagingAction {
	private int currentPage;
	private int totalCount;
	private int totalPage;
	private int blockCount;
	private int blockPage;
	private int startCount;
	private int endCount;
	private int startPage;
	private int endPage;
	private StringBuffer pagingHtml;

	// search없는 메소드
	public pagingAction(int currentPage, int totalCount, int blockCount, int blockPage, String actionName) {
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;

		// 전체 페이지 수
		totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}

		// 현재페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		// 현재 페이지의 처음과 마지막 글의 번호 가져오기
		startCount = (currentPage - 1) * blockCount;
		endCount = startCount + blockCount - 1;

		// 시작 페이지와 마지막 페이지 값 구하기
		startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;

		// 마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// 이전 block 페이지
		pagingHtml = new StringBuffer();
		if (currentPage > blockPage) {
			pagingHtml.append("a href=" + actionName + ".action?currentPage=" + (startPage - 1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a>");
		}
		pagingHtml.append("&nbsp;|&nbsp;");

		// 페이지 번호, 현재 페이지는 다르게 표시
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pagingHtml.append("&nbsp;<b> <font color='red'>");
				pagingHtml.append(i);
				pagingHtml.append("</font><b>");
			} else {
				pagingHtml.append("&nbsp;<a href='");
				pagingHtml.append(actionName);
				pagingHtml.append(".action?currentPage=");
				pagingHtml.append(i);
				pagingHtml.append("'>");
				pagingHtml.append(i);
				pagingHtml.append("</a>");
			}
			pagingHtml.append("&nbsp");
		}
		pagingHtml.append("&nbsp;&nbsp;|&nbsp;&nbsp;");

		// 다음 block 페이지
		if (totalPage - startPage >= blockPage) {
			pagingHtml.append("<a href=" + actionName + ".action?currentPage=" + (endPage + 1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a>");
		}
	}

	// search있는 메소드
	public pagingAction(int currentPage, int totalCount, int blockCount, int blockPage, String actionName,
			int searchNum, String isSearch) {

		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;

		totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}

		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		startCount = (currentPage - 1) * blockCount;
		endCount = startCount + blockCount - 1;

		startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;

		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// 이전 block 페이지
		pagingHtml = new StringBuffer();
		if (currentPage > blockPage) {
			if (isSearch != "")
				pagingHtml.append("<a class='page prv' href=" + actionName + ".action?currentPage=" + (startPage - 1)
						+ "&searchNum=" + searchNum + "&searchKeyword=" + isSearch + ">");
			else
				pagingHtml.append(
						"<a class='page prv' href=" + actionName + ".action?currentPage=" + (startPage - 1) + ">");
			pagingHtml.append("&lt;");
			pagingHtml.append("</a>");
		}

		// 페이지 번호, 현재 페이지는 다르게 표시
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pagingHtml.append("<strong>");
				pagingHtml.append(i);
				pagingHtml.append("</strong>");
			} else {
				pagingHtml.append("<a class='page' href=" + actionName + ".action?currentPage=");
				pagingHtml.append(i);
				if (isSearch != "")
					pagingHtml.append("&searchKeyword=" + isSearch);
				pagingHtml.append(">");
				pagingHtml.append(i);
				pagingHtml.append("</a>");
			}
		}
		// 다음 block 페이지
		if (totalPage - startPage >= blockPage) {
			pagingHtml.append("<a class='page next' href=" + actionName + ".action?currentPage=" + (endPage + 1) + ">");
			if (isSearch != "")
				pagingHtml.append("&searchKeyword=" + isSearch);
			pagingHtml.append("&gt;");
			pagingHtml.append("</a>");
		}

	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getStartCount() {
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public void setEndCount(int endCount) {
		this.endCount = endCount;
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

	public StringBuffer getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(StringBuffer pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

}
