package org.example.controller;

import org.example.dto.JobFilterDto;
import jakarta.ws.rs.core.MediaType;
import org.example.dao.JobsDAO;
import jakarta.ws.rs.*;

import org.example.models.Jobs;
import java.util.ArrayList;


@Path("/jobs")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

public class JobsController {

    JobsDAO dao = new JobsDAO();

    @GET
    public ArrayList<Jobs> SELECT_ALL_JOBS(
            @BeanParam JobFilterDto filter
            ) {

        try {
            return dao.SELECT_ALL_JOBS(filter.getMin_salary());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{job_id}")
    public Jobs SELECT_ONE_JOBS(@PathParam("job_id") int job_id) {

        try {
            return dao.selectJob(job_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("{job_id}")
    public void DELETE_JOB(@PathParam("job_id") int job_id) {

        try {
            dao.deleteJob(job_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @POST
    public void INSERT_JOB(Jobs job) {

        try {
            dao.insertJob(job);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{job_id}")
    public void UPDATE_JOB(@PathParam("job_id") int job_id, Jobs job) {

        try {
            job.setJob_id(job_id);
            dao.updateJob(job);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
