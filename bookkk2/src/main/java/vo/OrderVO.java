package vo;

public class OrderVO {
	
	//purchase
	private int purchaseNum,bookCnt,bookNum;
	private String id,regdate;
	
	
	//book
	private int price,stock,categortnum;
	private String subject,author,publishdate,publisher,intro,img;
	
	//user
	private String name, pwd, nickname, gender, address1, tel1, tel2, tel3, address2, email;
	private int jumin1, jumin2, postcode, shopPoint, money ;
	
	
	//oneBookPrice
	private int oneBookprice;
	
	//delivery
	private int deliveryNum,deliveryTel1,deliveryTel2,deliveryTel3,deliveryPostcode;
	private String deliveryName, deliveryAddress1,deliveryAddress2;
	
	//shoppingCart
	private int shopnum;
	private String regdate1;
	
	//포인트 추가
	private int point;
	private int totalPoint;
	
	
	//totalprice
	private int totalPrice;
	
	
	
	//update배송지
//	private String updatename,updatetel1,updatetel2,updatetel3,updateaddress1,updateaddress2;
//	private int updatepostcode;
//	
//	
	
	

	

	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
	public String getRegdate1() {
		return regdate1;
	}
	public void setRegdate1(String regdate1) {
		this.regdate1 = regdate1;
	}
	public int getShopnum() {
		return shopnum;
	}
	public void setShopnum(int shopnum) {
		this.shopnum = shopnum;
	}
	
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public int getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(int deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	public int getDeliveryTel1() {
		return deliveryTel1;
	}
	public void setDeliveryTel1(int deliveryTel1) {
		this.deliveryTel1 = deliveryTel1;
	}
	public int getDeliveryTel2() {
		return deliveryTel2;
	}
	public void setDeliveryTel2(int deliveryTel2) {
		this.deliveryTel2 = deliveryTel2;
	}
	public int getDeliveryTel3() {
		return deliveryTel3;
	}
	public void setDeliveryTel3(int deliveryTel3) {
		this.deliveryTel3 = deliveryTel3;
	}
	public int getDeliveryPostcode() {
		return deliveryPostcode;
	}
	public void setDeliveryPostcode(int deliveryPostcode) {
		this.deliveryPostcode = deliveryPostcode;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getDeliveryAddress1() {
		return deliveryAddress1;
	}
	public void setDeliveryAddress1(String deliveryAddress1) {
		this.deliveryAddress1 = deliveryAddress1;
	}
	public String getDeliveryAddress2() {
		return deliveryAddress2;
	}
	public void setDeliveryAddress2(String deliveryAddress2) {
		this.deliveryAddress2 = deliveryAddress2;
	}
	public int getOneBookprice() {
		return oneBookprice;
	}
	public void setOneBookprice(int oneBookprice) {
		this.oneBookprice = oneBookprice;
	}
	public int getShopPoint() {
		return shopPoint;
	}
	public void setShopPoint(int shopPoint) {
		this.shopPoint = shopPoint;
	}
	public int getJumin1() {
		return jumin1;
	}
	public void setJumin1(int jumin1) {
		this.jumin1 = jumin1;
	}
	public int getJumin2() {
		return jumin2;
	}
	public void setJumin2(int jumin2) {
		this.jumin2 = jumin2;
	}
	
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategortnum() {
		return categortnum;
	}
	public void setCategortnum(int categortnum) {
		this.categortnum = categortnum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public void initSaleTotal() {
		this.totalPrice = this.bookCnt* this.price;
		this.point = (int)(Math.floor(this.totalPoint*0.1));
	}
	
	@Override
	public String toString() {
		return " orderVO [id=" + id + ", bookCount=" + bookCnt +", bookNum=" + bookNum+"shopnum="+ shopnum+"price="+price+"subject="+subject+"]";
		
		
	}

	
	
	
	
}
