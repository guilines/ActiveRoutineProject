package com.guilines.controllers;

import javax.validation.Valid;

import com.guilines.handlers.WorkoutHandler;
import com.guilines.responses.GenericResponse;
import com.guilines.store.model.WorkoutModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController extends GenericController {
    final Logger LOGGER = LoggerFactory.getLogger(WorkoutController.class);

    @Autowired 
    private WorkoutHandler workoutHandler;

    private final String basePath = "/workout";

    @RequestMapping(basePath + "/get-all")
     GenericResponse getAll() {
        LOGGER.info("[GET] /get-all");
        return new GenericResponse().data(workoutHandler.getAllWorkouts());
    }

    @RequestMapping(basePath + "/{name}")
     GenericResponse get(@PathVariable final String name) throws Exception {
        LOGGER.info("[GET] ".concat(basePath).concat("/").concat(name));
        try {
            return new GenericResponse().data(workoutHandler.getWorkout(name));
        } catch(Exception e) {
            return new GenericResponse().isResponseOk(Boolean.FALSE).errorMsg(e.getMessage());
        }
    }

    @RequestMapping(value = basePath, method = RequestMethod.PUT)
     GenericResponse put(@Valid @RequestBody WorkoutModel workoutModel) {
        LOGGER.info("[PUT] workout/" + workoutModel.toString());
        try {
            return new GenericResponse().data(workoutHandler.addWorkout(workoutModel));
        } catch(Exception e) {
            return new GenericResponse().isResponseOk(Boolean.FALSE).errorMsg(e.getMessage());
        }
    }

    @RequestMapping(value = basePath, method = RequestMethod.POST)
     GenericResponse post() {
        LOGGER.info("[POST] workout/");
        return new GenericResponse().isResponseOk(Boolean.FALSE).errorMsg("NOT_IMPLEMENTED_YET");
    }

}