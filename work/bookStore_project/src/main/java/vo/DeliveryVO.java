package vo;

public class DeliveryVO {
	//http://localhost:9090/controller/update_success_payment.do?updatename=%EB%B3%80%EA%B2%BD&updatetel1=010&updatetel2=1231&updatetel3=1321&updatepostcode=18560&updateaddress1=%EA%B2%BD%EA%B8%B0+%ED%99%94%EC%84%B1%EC%8B%9C+%EC%9A%B0%EC%A0%95%EC%9D%8D+3.1%EB%A7%8C%EC%84%B8%EB%A1%9C281%EB%B2%88%EA%B8%B8+73-39&updateaddress2=123213132&id=jacomyou1026&price=9000&bookCnt=1&bookNum=21&price=10000&bookCnt=1&bookNum=20&price=9000&bookCnt=1&bookNum=21
	
	private int deliveryNum,price,deliverypostcode;
	private String deliveryaddress1,deliveryaddress2;
	private String id,deliverytel1,deliverytel2,deliverytel3,deliveryname;
	private int shopnum;
	private int purchaseNum,bookCnt,bookNum;
	
	
	
	public String getDeliveryname() {
		return deliveryname;
	}

	public void setDeliveryname(String deliveryname) {
		this.deliveryname = deliveryname;
	}

	public String getDeliverytel1() {
		return deliverytel1;
	}

	public void setDeliverytel1(String deliverytel1) {
		this.deliverytel1 = deliverytel1;
	}

	public String getDeliverytel2() {
		return deliverytel2;
	}

	public void setDeliverytel2(String deliverytel2) {
		this.deliverytel2 = deliverytel2;
	}

	public String getDeliverytel3() {
		return deliverytel3;
	}

	public void setDeliverytel3(String deliverytel3) {
		this.deliverytel3 = deliverytel3;
	}

	public int getDeliveryNum() {
		return deliveryNum;
	}

	public void setDeliveryNum(int deliveryNum) {
		this.deliveryNum = deliveryNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDeliverypostcode() {
		return deliverypostcode;
	}

	public void setDeliverypostcode(int deliverypostcode) {
		this.deliverypostcode = deliverypostcode;
	}

	
	public String getDeliveryaddress1() {
		return deliveryaddress1;
	}

	public void setDeliveryaddress1(String deliveryaddress1) {
		this.deliveryaddress1 = deliveryaddress1;
	}

	public String getDeliveryaddress2() {
		return deliveryaddress2;
	}

	public void setDeliveryaddress2(String deliveryaddress2) {
		this.deliveryaddress2 = deliveryaddress2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getShopnum() {
		return shopnum;
	}

	public void setShopnum(int shopnum) {
		this.shopnum = shopnum;
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
	
	
	
	
	
	
	
}
