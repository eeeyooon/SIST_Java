package com.project.sports.input;

public class YearTeam {
	
	private int seq;
	private String type;
	private String teamName;
	
	public YearTeam(int seq, String type, String teamName) {
		this.seq = seq;
		this.type = type;
		this.teamName = teamName;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		return String.format("YearTeam [seq=%s, type=%s, teamName=%s]", seq, type, teamName);
	}
	
	
	
	

}
