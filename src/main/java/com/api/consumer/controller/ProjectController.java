package com.api.consumer.controller;

import com.api.consumer.model.Record;
import com.api.consumer.model.Stats;
import com.api.consumer.model.Repositories;
import com.api.consumer.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProjectController {

    @Value("${get.stats}")
    private String statsSuffix;

    @Value("${search.url}")
    private String searchUrl;

    @Value("${get.repository}")
    private String getRepositoryPrefix;

    @Autowired
    private ProjectRepository repository;

    private final String pageNumber = "&page=1";
    private final String numberPerPage = "&per_page=10";

    @GetMapping("/index")
    public String index(Model model) {
        List<Record> records = getProjectRecords();
        model.addAttribute("records", records);
        return "index";
    }


    @RequestMapping("/search")
    public String searchProject(@RequestParam(value = "projectName", required = true) String projectName, Model model) {
        RestTemplate restTemplate = new RestTemplate();

        System.out.println("search " + getRepositoryPrefix + searchUrl + projectName + pageNumber + numberPerPage);
        Repositories results = restTemplate.getForObject(
                searchUrl + projectName + pageNumber + numberPerPage, Repositories.class);

        List<Record> records = getProjectRecords();
        model.addAttribute("projects", results.getProjectList());
        model.addAttribute("records", records);
        return "index";
    }

    @GetMapping("/getDetails/{owner}/{name}")
    public String getProjectDetails(@PathVariable("owner") String owner,
                                    @PathVariable("name") String projectName,
                                    Model model) {

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("get details for:  /" +owner+"/"+projectName + statsSuffix);

        List<Stats> stats = restTemplate.getForObject(
                getRepositoryPrefix + owner+"/"+projectName + statsSuffix, List.class);

        List<Record> records = getProjectRecords();
        model.addAttribute("records", records);

        model.addAttribute("owner", owner);
        model.addAttribute("project", projectName);
        model.addAttribute("stats", stats);

        return "index";
    }

    @GetMapping("/save/{owner}/{name}")
    public String saveForLater(@PathVariable("owner") String owner,
                               @PathVariable("name") String projectName,
                               Model model) {

        repository.save(new Record(owner, projectName));

        return "redirect:/index";
    }

    @GetMapping("/getProjectRecords")
        public String getProjectRecords(Model model) {
            List<Record> records = getProjectRecords();
            model.addAttribute("records", records);

        return "index";
    }

    private List<Record> getProjectRecords() {
        return (List<Record>) repository.findAll();
    }
}