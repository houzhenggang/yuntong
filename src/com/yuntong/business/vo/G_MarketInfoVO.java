package com.yuntong.business.vo;

public class G_MarketInfoVO {
	private int marketId;
    private int  marketAreaID ;
    private String marketName;
    private String marketAddress;
    private String markeyPostId;
	public String getMarketAddress() {
		return marketAddress;
	}
	public void setMarketAddress(String marketAddress) {
		this.marketAddress = marketAddress;
	}
	public int getMarketAreaID() {
		return marketAreaID;
	}
	public void setMarketAreaID(int marketAreaID) {
		this.marketAreaID = marketAreaID;
	}
	public int getMarketId() {
		return marketId;
	}
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public String getMarkeyPostId() {
		return markeyPostId;
	}
	public void setMarkeyPostId(String markeyPostId) {
		this.markeyPostId = markeyPostId;
	}
}
