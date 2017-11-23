package common;

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
	private String actionName;
	private StringBuffer pageHtml;

//	search X
	public pagingAction(int currentPage, int totalCount, int blockCount, int blockPage, String actionName) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.actionName = actionName;

		totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}

		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		startCount = (currentPage - 1) * blockPage;
		endCount = startCount + blockPage - 1;

		startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;

		if (endPage > totalPage) {
			endPage = totalPage;
		}

		pageHtml = new StringBuffer();
		if (currentPage > blockPage) {
			pageHtml.append("<a class='page prv' href=" + actionName + ".action?currentPage=" + (startPage - 1) + ">");
			pageHtml.append("&lt;");
			pageHtml.append("</a>");
		}

		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pageHtml.append("<strong>");
				pageHtml.append(i);
				pageHtml.append("</strong>");
			} else {
				pageHtml.append("<a class='page' href=" + actionName + ".action?currentPage=");
				pageHtml.append(i);
				pageHtml.append(">");
				pageHtml.append(i);
				pageHtml.append("</a>");
			}
		}

		if (totalPage - startPage >= blockPage) {
			pageHtml.append("<a class='page next' href=" + actionName + ".action?currentPage=" + (endPage + 1) + ">");
			pageHtml.append("&gt;");
			pageHtml.append("</a>");
		}
	}
	
	
//	searchNum add(FAQ)
	public pagingAction(int currentPage, int totalCount, int blockCount, int blockPage, String actionName, int searchSC, int searchNum,
			String isSearch) {

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

		pageHtml = new StringBuffer();
		if (currentPage > blockPage) {
			if (isSearch != "")
				pageHtml.append("<a class='page prv' href=" + actionName + ".action?currentPage=" + (startPage - 1)
						+ "&searchKeyword=" + isSearch + ">");
			else
				pageHtml.append(
						"<a class='page prv' href=" + actionName + ".action?currentPage=" + (startPage - 1) + ">");
			pageHtml.append("&lt;");
			pageHtml.append("</a>");
		}

		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pageHtml.append("<strong>");
				pageHtml.append(i);
				pageHtml.append("</strong>");
			} else {
				pageHtml.append("<a class='page' href=" + actionName + ".action?currentPage=");
				pageHtml.append(i);
				if (isSearch != "")
					pageHtml.append("&searchKeyword=" + isSearch);
				pageHtml.append(">");
				pageHtml.append(i);
				pageHtml.append("</a>");
			}
		}
		if (totalPage - startPage >= blockPage) {
			pageHtml.append("<a class='page next' href=" + actionName + ".action?currentPage=" + (endPage + 1) + ">");
			if (isSearch != "")
				pageHtml.append("&searchKeyword=" + isSearch);
			pageHtml.append("&gt;");
			pageHtml.append("</a>");
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

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public StringBuffer getPageHtml() {
		return pageHtml;
	}

	public void setPageHtml(StringBuffer pageHtml) {
		this.pageHtml = pageHtml;
	}

}
