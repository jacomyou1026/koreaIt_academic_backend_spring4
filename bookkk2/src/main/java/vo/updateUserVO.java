package vo;

public class updateUserVO {
	//http://localhost:9090/controller/update_success_payment.do?updatename=%EB%B3%80%EA%B2%BD&updatetel1=010&updatetel2=1231&updatetel3=1321&updatepostcode=18560&updateaddress1=%EA%B2%BD%EA%B8%B0+%ED%99%94%EC%84%B1%EC%8B%9C+%EC%9A%B0%EC%A0%95%EC%9D%8D+3.1%EB%A7%8C%EC%84%B8%EB%A1%9C281%EB%B2%88%EA%B8%B8+73-39&updateaddress2=123213132&id=jacomyou1026&price=9000&bookCnt=1&bookNum=21&price=10000&bookCnt=1&bookNum=20&price=9000&bookCnt=1&bookNum=21
	private int updatetel1,updatetel2,updatetel3,updatepostcode;
	private String updatename, updateaddress1,updateaddress2;
	private String id;
	
	private int shopnum;
	
	
	private int purchaseNum,bookCnt,bookNum;

	
	
	public int getUpdatetel1() {
		return updatetel1;
	}
	public void setUpdatetel1(int updatetel1) {
		this.updatetel1 = updatetel1;
	}
	public int getUpdatetel2() {
		return updatetel2;
	}
	public void setUpdatetel2(int updatetel2) {
		this.updatetel2 = updatetel2;
	}
	public int getUpdatetel3() {
		return updatetel3;
	}
	public void setUpdatetel3(int updatetel3) {
		this.updatetel3 = updatetel3;
	}
	public int getUpdatepostcode() {
		return updatepostcode;
	}
	public void setUpdatepostcode(int updatepostcode) {
		this.updatepostcode = updatepostcode;
	}
	public String getUpdatename() {
		return updatename;
	}
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}
	public String getUpdateaddress1() {
		return updateaddress1;
	}
	public void setUpdateaddress1(String updateaddress1) {
		this.updateaddress1 = updateaddress1;
	}
	public String getUpdateaddress2() {
		return updateaddress2;
	}
	public void setUpdateaddress2(String updateaddress2) {
		this.updateaddress2 = updateaddress2;
	}
	public int getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public int getBookCnt() {
		return bookCnt;
	}
	public void setBookCnt(int bookCnt) {
		this.bookCnt = bookCnt;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public int getShopnum() {
		return shopnum;
	}
	public void setShopnum(int shopnum) {
		this.shopnum = shopnum;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
