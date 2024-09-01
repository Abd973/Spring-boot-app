package com.telusko.springbootrest.repo;

import com.telusko.springbootrest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    public List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}








//List<String> techs = new ArrayList<>(Arrays.asList(
//        "Python", "Java"
//));
//List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//        new JobPost(1, "Java Developer", "any thing..", 5, techs),
//        new JobPost(2, "Python Developer", "any thing..", 3, techs)
//));
//
//
//public void addJob(JobPost job) {
//    jobs.add(job);
//    System.out.println(jobs);
//}
//
//public List<JobPost> getJobs() {
//    return jobs;
//}
//
//public JobPost getJobPost(int postId) {
//    for (JobPost jobPost : jobs) {
//        if (jobPost.getPostId() == postId)
//            return jobPost;
//    }
//    return null;
//}
//
//public void updateJob(JobPost jobPost) {
//    for (JobPost jobPost1 : jobs) {
//        if (jobPost1.getPostId() == jobPost.getPostId()) {
//            jobPost1.setPostId(jobPost.getPostId());
//            jobPost1.setPostProfile(jobPost.getPostProfile());
//            jobPost1.setPostDesc(jobPost.getPostDesc());
//            jobPost1.setReqExperience(jobPost.getReqExperience());
//            jobPost1.setPostTechStack(jobPost.getPostTechStack());
//
//        }
//    }
//}
//
//public void deletJob(int postId) {
//    for (JobPost jobPost : jobs) {
//        if (jobPost.getPostId() == postId) {
//            jobs.remove(jobPost);
//        }
//    }
//}