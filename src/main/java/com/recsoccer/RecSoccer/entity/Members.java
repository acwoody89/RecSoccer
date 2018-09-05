package com.recsoccer.RecSoccer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="members")
public class Members {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="memberid")
	private Long memberId;
	
	@Column(name="membername")
	private String memberName;
	
	@Column(name="membersrole")
	private String membersRole;
	
	@ManyToOne
	@JoinColumn(name="teamid")
	private Teams team;
	

	public Members(String memberName, String membersRole, Teams team) {
		super();
		this.memberName = memberName;
		this.membersRole = membersRole;
		this.team = team;
	}

	public Members(Long memberId, String memberName, String membersRole, Teams team) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.membersRole = membersRole;
		this.team = team;
	}

	public Teams getTeam() {
		return team;
	}

	public void setTeam(Teams team) {
		this.team = team;
	}

	public Members() {
		
	}
	

	@Override
	public String toString() {
		return "Members [memberId=" + memberId + ", memberName=" + memberName + ", membersRole=" + membersRole
				+ ", team=" + team + "]";
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMembersRole() {
		return membersRole;
	}

	public void setMembersRole(String membersRole) {
		this.membersRole = membersRole;
	}


	
	
	
}
