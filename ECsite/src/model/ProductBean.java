package model;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private int proCd;
	private String proName;
	private int proStock;
	private int proPrice;
	private int catId;
	private String proImg;
	private String proMsg;


	public int getProCd() {
		return proCd;
	}
	public void setProCd(int proCd) {
		this.proCd = proCd;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getProImg() {
		return proImg;
	}
	public void setProImg(String proImg) {
		this.proImg = proImg;
	}
	public String getProMsg() {
		return proMsg;
	}
	public void setProMsg(String proMsg) {
		this.proMsg = proMsg;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getProStock() {
		return proStock;
	}
	public void setProStock(int proStock) {
		this.proStock = proStock;
	}


}
