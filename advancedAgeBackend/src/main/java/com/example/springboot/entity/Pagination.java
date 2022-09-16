package com.example.springboot.entity;

import java.io.Serializable;

public class Pagination implements Serializable{

	private Integer numbersOfPage;// 每頁顯示多少條資料
	private Integer page;// 當前顯示第幾頁
	private Integer totalNumbers;// 總共多少條資料
	private Integer totalPages;// 總共多少頁（計算出來的）
	

    private static final long serialVersionUID = 1L;
    
    public Pagination() {
    	
    }
	public Pagination(String page , String numbersOfPage){
		this.page = Integer.valueOf(page);
		this.numbersOfPage = Integer.valueOf(numbersOfPage);
	}

	public void setNums(Integer totalNumbers) {
		// 計算一下總頁數：總條目數除以每頁顯示的條目數：totalNumbers/numsOfPage
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
