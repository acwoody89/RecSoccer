package com.recsoccer.RecSoccer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recsoccer.RecSoccer.entity.Teams;
@Repository
public interface TeamsRepo extends JpaRepository <Teams, Long> {
	
	@Query("SELECT DISTINCT teamName FROM Teams")
	List<Teams> getTeams();
	
	@Query("SELECT DISTINCT teamName FROM Teams")
	List<String> findDistinctTeam();
	
	@Query("SELECT DISTINCT teamId FROM Teams")
	List<Teams> getTeamsId(String teamName);
	
	Teams findIdByTeamName(String name);
	List<Teams> findMembersListByTeamId(Long id);
	List<Teams> findMembersListByTeamName(String teamName);
}
