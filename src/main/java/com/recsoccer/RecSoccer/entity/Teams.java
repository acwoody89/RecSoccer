package com.recsoccer.RecSoccer.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Teams {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teamid")
	private Long teamId;
	
	@Column(name="teamname")
	private String teamName;
	
	@OneToMany(mappedBy ="team", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Members> membersList = new ArrayList<>();
	
	public Teams() {
		
	}
	
	
	public Teams(Long teamId, String teamName, List<Members> mList) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.membersList = mList;
	}


	public Teams(String teamName, List<Members> mList) {
		super();
		this.teamName = teamName;
		this.membersList = mList;
	}

	
	
	public List<Members> getMembersList() {
		return membersList;
	}
	public void setMembertsList(List<Members> membersList) {
		this.membersList = membersList;
	}
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", teamName=" + teamName + ", membersList=" + membersList + "]";
	}

	
}
