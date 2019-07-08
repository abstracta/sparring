package us.abstracta.sparring.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import us.abstracta.sparring.issues.Issue;
import us.abstracta.sparring.issues.impl.AcceptCountIssue;
import us.abstracta.sparring.issues.impl.BadSqlDAO;
import us.abstracta.sparring.issues.impl.MaxThreadsIssue;
import us.abstracta.sparring.issues.impl.MemoryLeakIssue;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class IssueController {

    private List<Issue> issues;

    public IssueController(){
        issues= new ArrayList<>();
        issues.add(new BadSqlDAO());
        issues.add(new MemoryLeakIssue());
        issues.add(new MaxThreadsIssue());
        issues.add(new AcceptCountIssue());
    }

    /* get all issues */
    @CrossOrigin(origins = "*")
    @GetMapping("/issues")
    public List<Issue> getIssues() {
        return issues;

    }

    /* get all active issues*/
    @CrossOrigin(origins = "*")
    @GetMapping("/issues/active")
    public List<Issue> getActiveIssues() {
        List<Issue> activeIssues= new ArrayList();
        for (Issue issue : issues) {
            if (issue.isOn()){
             activeIssues.add(issue);
            }
        }
        return activeIssues;
    }


    /* get all common inactive issues */
    @CrossOrigin(origins = "*")
    @GetMapping("/issues/inactive/common")
    public List<Issue> getCommonInactiveIssues() {
        List<Issue> commonInactiveIssues= new ArrayList();
        for (Issue issue : issues) {
            if (!issue.isOn() && !issue.hasInput()){
                commonInactiveIssues.add(issue);
            }
        }
        return commonInactiveIssues;
    }

    /* get all input inactive issues */
    @CrossOrigin(origins = "*")
    @GetMapping("/issues/inactive/input")
    public List<Issue> getInputInactiveIssues() {
        List<Issue> inputInactiveIssues= new ArrayList();
        for (Issue issue : issues) {
            if (!issue.isOn() && issue.hasInput()){
                inputInactiveIssues.add(issue);
            }
        }
        return inputInactiveIssues;
    }

    /* set an issue on */
    @CrossOrigin(origins = "*")
    @PutMapping("/issues/{id}/active")
    public boolean setIssueOn(@PathVariable("id") String id) {
        for (Issue issue : issues) {
            if (id.equals(issue.getName())){
                issue.setOn();
            }
        }
        return true;
    }

    /* set an issue on */
    @CrossOrigin(origins = "*")
    @PutMapping("/issues/{id}/active/{input}")
    public boolean setInputIssueOn(@PathVariable("id") String id, @PathVariable("input") String input) {
        for (Issue issue : issues) {
            if (id.equals(issue.getName())){
                issue.setOn(input);
            }
        }
        return true;
    }

    /* set an issue off */
    @CrossOrigin(origins = "*")
    @PutMapping("/issues/{id}/inactive")
    public boolean setIssueOff(@PathVariable("id") String id) {
        for (Issue issue : issues) {
            if (id.equals(issue.getName())){
                issue.setOff();
            }
        }
        return true;
    }

    /* set an issue off */
    @CrossOrigin(origins = "*")
    @PostMapping("/restart")
    public boolean restart() {
        final String uri = "http://web:8080/restart";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(uri, null, String.class);
        return true;
    }

}
