public class dWebDS {
	private int id;
	private String msg, remark, memo;
	
	public dWebDS(int id, String msg, String remark, String memo) {
		this.id = id;
		this.msg = msg;
		this.remark = remark;
		this.memo = memo;
	}
	
	public void setMsg(String msg){
		this.msg = msg;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public void setMemo(String memo){
		this.memo = memo;
	}
	
	public int getID(){
		return this.id;
	}
	
	public String getMsg(){
		return this.msg;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public String getMemo(){
		return this.memo;
	}
}
