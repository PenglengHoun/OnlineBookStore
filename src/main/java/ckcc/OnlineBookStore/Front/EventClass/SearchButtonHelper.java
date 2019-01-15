package ckcc.OnlineBookStore.Front.EventClass;

import ckcc.OnlineBookStore.Back.Extra.TableTitle;

public class SearchButtonHelper{
	
	private String type;
	private boolean isString;
	
	public SearchButtonHelper(String type) {
		isString = false;
		if(type.equals(TableTitle.ID)) {
			this.type = "id";
		}
		else if(type.equals(TableTitle.TITLE)) {
			this.type = "title";
			isString = true;
		}
		else if(type.equals(TableTitle.PUBLISHER)) {
			this.type = "publisher";
			isString = true;
		}
		else if(type.equals(TableTitle.YEAR_PUBLISHED)) {
			this.type = "yearPublished";
			isString = true;
		}
		else if(type.equals(TableTitle.ISBN)) {
			this.type = "ISBN";
			isString = true;
		}
		else if(type.equals(TableTitle.PRICE)) {
			this.type = "price";
		}
		else if(type.equals(TableTitle.AUTHOR)) {
			this.type = "author";
			isString = true;
		}
		else if(type.equals(TableTitle.EDITION)) {
			this.type = "edition";
		}
		else if(type.equals(TableTitle.BOOK_ID)) {
			this.type = "bookId";
		}
		else if(type.equals(TableTitle.QTY)) {
			this.type = "qty";
		}
		else {
			this.type = "volume";
		}
	}
	
	public String getType() {
		return type;
	}
	
	public boolean isString() {
		return isString;
	}
	
}
