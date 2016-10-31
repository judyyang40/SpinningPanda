package api;

import gumball.GumballMachine ;

class GMObject {
	private String banner;
	private int count;
	private String state;

	public String getBanner() {
		return banner;
	}
	public int getCount() {
		return count;
	}
	public String getState() {
		return state;
	}
	public void setBanner(String b) {
		banner = b;
	}
	public void setCount(int c) {
		count = c;
	}
	public void setState(String s) {
		state = s;
	}
}