package common.entity;

import java.util.List;

public class PageBean<T extends java.io.Serializable> {

	/**
	 * Ҫ���ص�ĳһҳ�ļ�¼�б�
	 */
	private List<T> list;
	/**
	 * �ܼ�¼��
	 */
	private int allRow;
	/**
	 * ��ҳ��
	 */
	private int totalPage;
	/**
	 * ��ǰҳ
	 */
	private int currentPage;
	/**
	 * ÿҳ��¼��
	 */
	private int pageSize;
	/**
	 * �Ƿ�Ϊ��һҳ
	 */
	private boolean isFirstPage;
	/**
	 * �Ƿ�Ϊ���һҳ
	 */
	private boolean isLastPage;
	/**
	 * �Ƿ���ǰһҳ
	 */
	private boolean hasPreviousPage;
	/**
	 * �Ƿ�����һҳ
	 */
	private boolean hasNextPage;
	/**
	 * ���� * ��ʼ����ҳ��Ϣ ����
	 */
	public void init() {
		this.isFirstPage = isFirstPage();
		this.isLastPage = isLastPage();
		this.hasPreviousPage = isHasPreviousPage();
		this.hasNextPage = isHasNextPage();
	}

	/**
	 * �жϵ�ǰҳ�Ƿ�Ϊ��һҳ
	 * 
	 * @return (true:�� false:��)
	 */
	public boolean isFirstPage() {
		return (currentPage == 1);
	}

	/**
	 * �жϵ�ǰҳ�Ƿ�Ϊ���һҳ
	 * 
	 * @return true:�� false:��)
	 */
	public boolean isLastPage() {
		return (currentPage == totalPage);
	}
	/**
	 * �Ƿ�����һ�ڵ�
	 * 
	 * @return (true:�� false:��)
	 */
	
	public boolean isHasPreviousPage() {
		return (currentPage != 1);
	}


	/**
	 * �Ƿ�����һ�ڵ�
	 * 
	 * @return (true:�� false:��)
	 */
	public boolean isHasNextPage() {
		return (currentPage != totalPage);
	}

	/**
	 * ���� * ������ҳ��,��̬����,���ⲿֱ��ͨ���������� ���� * @param pageSize ÿҳ��¼�� ���� * @param allRow
	 * �ܼ�¼�� ���� * @return ��ҳ�� ����
	 */
	public static int countTotalPage(final int pageSize, final int allRow) {
		int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow
				/ pageSize + 1;
		return totalPage;
	}

	/**
	 * ���� * ���㵱ǰҳ��ʼ��¼ ���� * @param pageSize ÿҳ��¼�� ���� * @param currentPage ��ǰ�ڼ�ҳ
	 * ���� * @return ��ǰҳ��ʼ��¼�� ����
	 */
	public static int countOffset(final int pageSize, final int currentPage) {
		final int offset = pageSize * (currentPage - 1);
		return offset;
	}

	/**
	 * ���� * ���㵱ǰҳ,��Ϊ0���������URL��û��"?page=",����1���� ���� * @param page
	 * ����Ĳ���(����Ϊ��,��0,�򷵻�1) ���� * @return ��ǰҳ ����
	 */
	public static int countCurrentPage(int page) {
		final int curPage = (page == 0 ? 1 : page);
		return curPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

}
