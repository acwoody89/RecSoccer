package com.recsoccer.RecSoccer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.recsoccer.RecSoccer.entity.Members;
import com.recsoccer.RecSoccer.entity.Teams;
import com.recsoccer.RecSoccer.repo.MembersRepo;
import com.recsoccer.RecSoccer.repo.TeamsRepo;

@Controller
public class RecSoccerController {

	@Autowired
	TeamsRepo tRepo;
	@Autowired
	MembersRepo mRepo;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		return new ModelAndView("index");
		
	}
	@GetMapping("/cancel")
	public ModelAndView cancel() {
		
		return new ModelAndView("index");
		
	}
	
	@RequestMapping("/teamList")
	public ModelAndView teamPage() {
		ModelAndView mv = new ModelAndView("teamList");
		mv.addObject("h1", "Team Name");
		mv.addObject("teamlist", tRepo.findAll());
		System.out.println(tRepo.getTeams());
		return mv; 
	}

	@RequestMapping("/memberList/{teamId}")
	public ModelAndView memberListPage(@PathVariable("teamId") long id, Optional<Teams> team) {
		team = tRepo.findById(id);
		Teams team1 = team.get();
		team1.getMembersList();
		return new ModelAndView("memberList", "members", team1.getMembersList());
	}
	
	@RequestMapping("/memberEdit/{memberId}/{teamId}")
	public ModelAndView memberForm(@PathVariable("memberId") long id) {
		ModelAndView mv = new ModelAndView("memberEdit");
		mv.addObject("m", mRepo.findById(id).orElse(null));
		return mv;
	}
	@PostMapping("/memberEdit/{memberId}/{teamId}")
	public ModelAndView memberEditPage(@PathVariable("memberId") long mId,Teams team,@PathVariable("teamId") long teamId, Members member) {
		member.setTeam(tRepo.getOne(teamId));
		mRepo.save(member);
		
		return new ModelAndView("redirect:/memberList/{teamId}");
	}
	
	@RequestMapping("/members")
	public ModelAndView memberListPage() {
		ModelAndView mv = new ModelAndView("teamList");
		mv.addObject("h1", "Member Name");
		mv.addObject("h2", "Member ID");
		mv.addObject("h3", "Member Role");
		mv.addObject("h4", "Team Name");
		mv.addObject("memberlist", mRepo.findAll());
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView registerPlayerPage() {
		ModelAndView mv = new ModelAndView("/register", "teams", tRepo.findDistinctTeam());
		return mv;
	}
	
	@RequestMapping("/registercomplete")
	public ModelAndView registerPlayerCompletePage(@RequestParam("memberName") String name, @RequestParam("membersRole") String role, @RequestParam("teamselect") String teamSelect, Members member) {
		System.out.println();
		//Teams team = tRepo.getOne(tRepo.findIdByTeamName(teamSelect));
		member.setTeam(tRepo.findIdByTeamName(teamSelect));
		mRepo.save(member);
		return new ModelAndView("redirect:/");
	}
	
	
	
}
