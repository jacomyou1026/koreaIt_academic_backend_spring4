package vo;

import org.springframework.web.multipart.MultipartFile;
import java.util.Date;
public class BookVO {
	
	private String subject, author, publisher, intro;
	private Date publishDate;
	private int bookNum, price, stock;
	private MultipartFile photo; // 파일을 받기위한 클래스
	private String img; //파일명
	
	//=======================================================
	private int tier;
	private String cateName;
	private int categoryNum;
	private int cateParent;
	//신규 게시물에 new마크를 붙일지 말지 결정하는 논리필드 선언.
	private boolean newMark;
	
	
	public int getTier() {
		return tier;
	}
	public void setTier(int tier) {
		this.tier = tier;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getCateParent() {
		return cateParent;
	}
	public void setCateParent(int cateParent) {
		this.cateParent = cateParent;
	}
	public boolean isNewMark() {
		return newMark;
	}
	public void setNewMark(boolean newMark) {
		this.newMark = newMark;
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

	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
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
	public int getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "BookVO [bookNum=" + bookNum + ", subject=" + subject + ", author=" + author + ", publishDate="
				+ publishDate + ", publisher=" + publisher + ", price=" + price + ", intro=" + intro + ", img=" + img
				+ ", stock=" + stock + ", tier=" + tier + ", cateName=" + cateName + ", categoryNum=" + categoryNum
				+ ", cateParent=" + cateParent + ", newMark=" + newMark + "]";
	}

	
}
