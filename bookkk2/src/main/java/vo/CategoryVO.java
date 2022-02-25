package vo;

public class CategoryVO {
/*
create table category(
    tier number(1) not null,
    cateName varchar2(30) not null,
    categoryNum int not null,
    cateParent int ,
    primary key(categoryNum),
    foreign key(cateParent) references category(categoryNum) 
);
);
*/
	
	private int tier;
	private String cateName;
	private int categoryNum;
	private int cateParent;
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
	public int getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}
	public int getCateParent() {
		return cateParent;
	}
	public void setCateParent(int cateParent) {
		this.cateParent = cateParent;
	}
	
	
	
	
	
	
	

}
