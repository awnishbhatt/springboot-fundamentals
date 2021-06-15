package com.abb.web;

import com.abb.entity.Application;
import com.abb.entity.Release;
import com.abb.entity.Ticket;
import com.abb.exception.ApplicationNotFoundException;
import com.abb.service.ApplicationService;
import com.abb.service.ReleaseService;
import com.abb.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController //@controller @ResponseBody (serializes the o/p into the http response as json)
@RequestMapping("tza")
public class TzaController {
    private ApplicationService applicationService;
    private TicketService ticketService;
    private ReleaseService releaseService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setReleaseService(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> retrieveApplications(Model model){
        List<Application> apps = applicationService.listApplications();
        return new ResponseEntity<>(apps, HttpStatus.OK);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<Application>(applicationService.findApplication(id), HttpStatus.OK);
        } catch (ApplicationNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application Not Found");
        }
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> retrieveTickets(Model model){
        List<Ticket> tickets = ticketService.listTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/releases")
    public ResponseEntity<List<Release>> retrieveReleases(Model model){
        List<Release> releases = releaseService.listReleases();
        return new ResponseEntity<>(releases, HttpStatus.OK);
    }
}