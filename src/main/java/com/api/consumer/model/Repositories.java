package com.api.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repositories {

    private List<Project> items;

    public Repositories() {
        items = new ArrayList<>();
    }

    public List<Project> getProjectList() {
        return items;
    }

    public void setProjectList(List<Project> projectList) {
        this.items = projectList;
    }


}
