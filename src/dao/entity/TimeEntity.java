package dao.entity;

import java.sql.Time;

public class TimeEntity {
	private  int pid;
	private Time start;
	private Time end;
	private String active;
	public TimeEntity(int pid, Time start, Time end, String active) {
		super();
		this.pid = pid;
		this.start = start;
		this.end = end;
		this.active = active;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Time getStart() {
		return start;
	}
	public void setStart(Time start_time) {
		this.start = start_time;
	}
	public Time getEnd() {
		return end;
	}
	public void setEnd(Time end_time) {
		this.end = end_time;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "TimeEntity [pid=" + pid + ", start=" + start + ", end=" + end + ", active=" + active + "]";
	}
	
	

}
