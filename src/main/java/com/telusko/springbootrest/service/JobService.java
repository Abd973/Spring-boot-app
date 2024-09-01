package com.telusko.springbootrest.service;

import com.telusko.springbootrest.model.JobPost;
import com.telusko.springbootrest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost)
    {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs()
    {
        return repo.findAll();
    }

    public JobPost getJobPost(int postId) {
        return repo.findById(postId).orElse(null);
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<String> techs = new ArrayList<>(Arrays.asList("Python", "Java"));
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
        new JobPost(1, "Java Developer", "any thing..", 5, techs),
        new JobPost(2, "Python Developer", "any thing..", 3, techs)
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
