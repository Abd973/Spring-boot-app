package com.telusko.springbootrest;

import com.telusko.springbootrest.model.JobPost;
import com.telusko.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;


    @GetMapping(path = "jobPosts", produces = {"application/json"})
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("jobPosts/{postId}")
    public JobPost getJobPost(@PathVariable int postId) {
        return service.getJobPost(postId);
    }


    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword) {
         return service.search(keyword);
    }


    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJobPost(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJobPost(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
        return "Deleted Job Post Id: " + service.getJobPost(postId).getPostId();
    }


    @GetMapping("load")
    public String load()
    {
        service.load();

        return "success";
    }
}
