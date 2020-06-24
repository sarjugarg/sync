package org.sync.model;

public class Search {

	private String term;
	private Integer cid;
    private String type;
    private String startdate;
    private String enddate;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	

	
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Search [term=" + term + ", cid=" + cid + ", type=" + type + ", startdate=" + startdate + ", enddate="
				+ enddate + "]";
	}
	
	
	
	
}
