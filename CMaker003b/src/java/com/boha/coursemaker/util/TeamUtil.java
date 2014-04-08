/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.coursemaker.util;

import com.boha.coursemaker.data.DemoAnnouncement;
import com.boha.coursemaker.data.Team;
import com.boha.coursemaker.data.TeamMember;
import com.boha.coursemaker.data.Trainee;
import com.boha.coursemaker.dto.DemoAnnouncementDTO;
import com.boha.coursemaker.dto.TeamDTO;
import com.boha.coursemaker.dto.TeamMemberDTO;
import com.boha.coursemaker.dto.platform.ResponseDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author aubreyM
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class TeamUtil {
    @PersistenceContext
    EntityManager em;
    public  ResponseDTO getTeamsByCompany(Integer companyID) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            
            Query q = em.createNamedQuery("Team.findByCompany",Team.class);
            q.setParameter("id", companyID);
            List<Team> list = q.getResultList();
            List<TeamDTO> dto = new ArrayList<>();
            for (Team t : list) {
                dto.add(new TeamDTO(t));
            }
            List<TeamMemberDTO> tmList = getMembersByCompany(companyID);
            for (TeamDTO t : dto) {
                t.setTeamMemberList(new ArrayList<TeamMemberDTO>());
                for (TeamMemberDTO tm : tmList) {
                    if (tm.getTeamID().intValue() == t.getTeamID().intValue()) {
                        t.getTeamMemberList().add(tm);
                    }
                }
            }
            d.setTeamList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to get data", e);
            throw new DataException("Failed to get data\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    public  ResponseDTO getTeamsByClass(Integer trainingClassID) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            
            Query q = em.createNamedQuery("Team.findByClass",Team.class);
            q.setParameter("id", trainingClassID);
            List<Team> list = q.getResultList();
            List<TeamDTO> dto = new ArrayList<>();
            for (Team t : list) {
                dto.add(new TeamDTO(t));
            }
            List<TeamMemberDTO> tmList = getMembersByClass(trainingClassID);
            for (TeamDTO t : dto) {
                t.setTeamMemberList(new ArrayList<TeamMemberDTO>());
                for (TeamMemberDTO tm : tmList) {
                    if (tm.getTeamID().intValue() == t.getTeamID().intValue()) {
                        t.getTeamMemberList().add(tm);
                    }
                }
            }
            d.setTeamList(dto);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to get data", e);
            throw new DataException("Failed to get data\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    private  List<TeamMemberDTO> getMembersByCompany(Integer companyID) {
        
        Query q = em.createNamedQuery("TeamMember.findByCompany",TeamMember.class);
        q.setParameter("id", companyID);
        List<TeamMember> list = q.getResultList();
        List<TeamMemberDTO> dto = new ArrayList<>();
        for (TeamMember tm : list) {
            dto.add(new TeamMemberDTO(tm));
        }
        return dto;
    }

    private  List<TeamMemberDTO> getMembersByClass(Integer trainingClassID) {
        
        Query q = em.createNamedQuery("TeamMember.findByClass",TeamMember.class);
        q.setParameter("id", trainingClassID);
        List<TeamMember> list = q.getResultList();
        List<TeamMemberDTO> dto = new ArrayList<>();
        for (TeamMember tm : list) {
            dto.add(new TeamMemberDTO(tm));
        }
        return dto;
    }

    public  ResponseDTO getDemoAnnouncementsByClass(Integer trainingClassID) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            
            Query q = em.createNamedQuery("DemoAnnouncement.findByClass",DemoAnnouncement.class);
            q.setParameter("id", trainingClassID);

            List<DemoAnnouncement> list = q.getResultList();
            List<DemoAnnouncementDTO> dto = new ArrayList<>();
            for (DemoAnnouncement da : list) {
                dto.add(new DemoAnnouncementDTO(da));
            }
            d.setDemoAnnouncementList(dto);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to get data", e);
            throw new DataException("Failed to get data\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    public  ResponseDTO getDemoAnnouncementsByCompany(Integer companyID) throws DataException {
        ResponseDTO d = new ResponseDTO();
        try {
            
            Query q = em.createNamedQuery("DemoAnnouncement.findByCompany",DemoAnnouncement.class);
            q.setParameter("id", companyID);
            List<DemoAnnouncement> list = q.getResultList();
            List<DemoAnnouncementDTO> dto = new ArrayList<>();
            for (DemoAnnouncement da : list) {
                dto.add(new DemoAnnouncementDTO(da));
            }
            d.setDemoAnnouncementList(dto);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to get data", e);
            throw new DataException("Failed to get data\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    public  ResponseDTO cancelDemoAnnouncement(Integer demoAnnouncementID) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            
            DemoAnnouncement a = getDemoAnnouncementByID(demoAnnouncementID);
            a.setCancellationDate(new Date());
            em.merge(a);

            log.log(Level.INFO, "Demo cancelled");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to cancel demo", e);
            throw new DataException("Failed to cancel demo\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    public  ResponseDTO addTeam(TeamDTO team) throws DataException {
        ResponseDTO d = new ResponseDTO();

        try {
            
            
            Team a = new Team();
            a.setDateRegistered(new Date());
            a.setTeamName(team.getTeamName());
            a.setTrainingClass(DataUtil.getTrainingClassByID(team.getTrainingClassID(), em));
            
            em.persist(a);
            
            log.log(Level.INFO, "Team added: {0}", team.getTeamName());
            TeamDTO td = new TeamDTO(a);
            try {
                if (team.getTeamMemberList() != null && team.getTeamMemberList().size() > 0) {
                    TeamMemberDTO tm = team.getTeamMemberList().get(0);
                    tm.setTeamID(a.getTeamID());
                    ResponseDTO r = addTeamMember(tm);
                    if (r.getStatusCode() == 0) {
                        td.setTeamMemberList(new ArrayList<TeamMemberDTO>());
                        td.getTeamMemberList().add(r.getTeamMember());
                    }
                }
            } catch (Exception e) {
                log.log(Level.SEVERE, "Failed to add team member", e);
            }
            d.setTeam(td);

        } catch (RollbackException e) {
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Duplicate team found. This team already exists");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add team", e);
            throw new DataException("Failed to add team\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    public  ResponseDTO addTeamMember(TeamMemberDTO member) throws DataException {

        ResponseDTO d = new ResponseDTO();
        try {
            
            
            TeamMember a = new TeamMember();
            a.setDateRegistered(new Date());
            Team team = getTeamByID(member.getTeamID());
            if (team == null) {
                log.log(Level.SEVERE, "FUCK!!! - team is null");
                throw new DataException("Team is NULL. teamID: " + member.getTeamID());
            }
            a.setTeam(team);
            Trainee trainee = DataUtil.getTraineeByID(member.getTraineeID(), em);
             if (trainee == null) {
                 log.log(Level.SEVERE, "FUCK!!! - trainee is null");
                throw new DataException("Trainee is NULL. traineeID: " + member.getTraineeID());
            }
            a.setTrainee(trainee);
            a.setActiveFlag(1);
            em.persist(a);
            
            Query q = em.createNamedQuery("TeamMember.findByTeam",TeamMember.class);
            q.setParameter("id", team.getTeamID());
            List<TeamMember> list = q.getResultList();
            List<TeamMemberDTO> dto = new ArrayList<>();
            for (TeamMember tm : list) {
                dto.add(new TeamMemberDTO(tm));
            }
            d.setTeamMemberList(dto);
            log.log(Level.INFO, "Team member added: {0} - {1} {2}",
                    new Object[]{a.getTeam().getTeamName(), a.getTrainee().getFirstName(), a.getTrainee().getLastName()});
        } catch (RollbackException e) {
            d.setStatusCode(ResponseDTO.ERROR_DUPLICATE);
            d.setMessage("Team member already in the team.");
        } catch (ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> set = e.getConstraintViolations();
            for (Iterator<ConstraintViolation<?>> it = set.iterator(); it.hasNext();) {
                ConstraintViolation<? extends Object> constraintViolation = it.next();
                log.log(Level.SEVERE, "FUCK!!! - " + constraintViolation.getMessage(), e);               
            }
             throw new DataException("Failed to add TeamMember\n" + DataUtil.getErrorString(e));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add team member", e);
            throw new DataException("Failed to add team member\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    public  ResponseDTO addDemoAnnouncement(DemoAnnouncementDTO ann) throws DataException {

        ResponseDTO d = new ResponseDTO();
        String name = null;
        try {
            
            
            DemoAnnouncement a = new DemoAnnouncement();
            a.setDateRequested(new Date());
            a.setDemoDate(new Date(ann.getDemoDate()));
            a.setDescription(ann.getDescription());
            if (ann.getTeamID() != null) {
                a.setTeam(getTeamByID(ann.getTeamID()));
                name = a.getTeam().getTeamName();
            }
            if (ann.getTraineeID() != null) {
                a.setTrainee(DataUtil.getTraineeByID(ann.getTraineeID(), em));
                name = a.getTrainee().getFirstName() + " " + a.getTrainee().getLastName();
            }
            if (ann.getTrainingClassID() != null) {
                a.setTrainingClass(DataUtil.getTrainingClassByID(ann.getTrainingClassID(), em));
            }           
            em.persist(a);
            Query q = null;
            if (ann.getTeamID() != null) {
               q = em.createNamedQuery("DemoAnnouncement.findByTeam", DemoAnnouncement.class);
               q.setParameter("id", ann.getTeamID());
            }
            if (ann.getTraineeID() != null) {
                q = em.createNamedQuery("DemoAnnouncement.findByTrainee", DemoAnnouncement.class);
                q.setParameter("id", ann.getTraineeID());
                            }
            if (ann.getTrainingClassID() != null) {
                q = em.createNamedQuery("DemoAnnouncement.findByClass",DemoAnnouncement.class);
                q.setParameter("id", ann.getTrainingClassID());
            }    
            List<DemoAnnouncement> list = q.getResultList();
            List<DemoAnnouncementDTO> dto = new ArrayList<>();
            for (DemoAnnouncement da : list) {
                dto.add(new DemoAnnouncementDTO(da));
            }
            d.setDemoAnnouncementList(dto);
            log.log(Level.INFO, "Demo announcement added: {0} - demoDate: {1}",
                    new Object[]{name, a.getDemoDate().toString()});
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add Demo announcement", e);
            throw new DataException("Failed to add Demo announcement\n" + DataUtil.getErrorString(e));
        }
        return d;
    }

    public  Team getTeamByID(Integer id) {
        
        Team t = em.find(Team.class, id);
        if (t == null) {
            log.log(Level.OFF, "Team not found by ID, is null");
        } else {
            log.log(Level.OFF, "Team  found by ID, is COOL!");
        }
        return t;
    }

    public  TeamMember getTeamMemberByID(Integer id) {
        
        TeamMember t = em.find(TeamMember.class, id);
        return t;
    }

    public  DemoAnnouncement getDemoAnnouncementByID(Integer id) {
        
        DemoAnnouncement t = em.find(DemoAnnouncement.class, id);
        return t;
    }
     final Logger log = Logger.getLogger(TeamUtil.class.getSimpleName());
}
