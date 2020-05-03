package com.guilines.store.repository;

import java.util.List;

import com.guilines.store.model.WorkoutModel;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface WorkoutsRepository extends MongoRepository<WorkoutModel, String>{
    WorkoutsRepository findBy_id(ObjectId _id);

    @Query("{ 'name' : ?0 }")
    List<WorkoutModel> findByWorkoutName(String name);
}