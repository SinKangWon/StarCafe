package kr.ac.kopo.starcafe.pager;

public class ProductPager extends Pager {
	private int minPrice;
	private int maxPrice;
	
	public String getQuery() {
		String query = super.getQuery();
		
		query += "&minPrice=" + minPrice;
		
		query += "&maxPrice=" + maxPrice;
		
		return query;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
}
