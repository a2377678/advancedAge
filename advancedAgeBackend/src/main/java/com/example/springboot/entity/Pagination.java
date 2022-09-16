package com.example.springboot.entity;

import java.io.Serializable;

public class Pagination implements Serializable{

	private Integer numbersOfPage;// �C����ܦh�ֱ����
	private Integer page;// ��e��ܲĴX��
	private Integer totalNumbers;// �`�@�h�ֱ����
	private Integer totalPages;// �`�@�h�֭��]�p��X�Ӫ��^
	

    private static final long serialVersionUID = 1L;
    
    public Pagination() {
    	
    }
	public Pagination(String page , String numbersOfPage){
		this.page = Integer.valueOf(page);
		this.numbersOfPage = Integer.valueOf(numbersOfPage);
	}

	public void setNums(Integer totalNumbers) {
		// �p��@�U�`���ơG�`���ؼư��H�C����ܪ����ؼơGtotalNumbers/numsOfPage
		double a = totalNumbers;
		double b = numbersOfPage;
		this.totalPages = (int)Math.ceil(a/b);
		this.totalNumbers = totalNumbers;
	} //
	
	public Integer getNumbersOfPage() {
        return numbersOfPage;
    }

    public void setNumbersOfPage(Integer numbersOfPage) {
        this.numbersOfPage = numbersOfPage;
    }

	public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

	public Integer getTotalNumbers() {
        return totalNumbers;
    }

    public void setTotalNumbers(Integer totalNumbers) {
        this.totalNumbers = totalNumbers;
    }

	public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
