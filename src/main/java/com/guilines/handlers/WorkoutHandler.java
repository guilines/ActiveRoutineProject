package com.guilines.handlers;

import java.util.List;
import java.util.function.Predicate;

import javax.validation.Valid;

import com.guilines.store.model.WorkoutModel;
import com.guilines.store.repository.WorkoutsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class WorkoutHandler {
    private final static String NO_DATA_FOUND = "No data found";
    private final static String GENERIC_ERROR = "Generic Error";
    @Autowired
    private WorkoutsRepository repository;

    public List<WorkoutModel> getAllWorkouts() {
        return repository.findAll();
    }

	public WorkoutModel getWorkout(String name) throws Exception {
        List<WorkoutModel> workoutsList = repository.findByWorkoutName(name);
        if (workoutsList.size() > 0) {
            return workoutsList.get(0);
        }
        throw new Exception(NO_DATA_FOUND);
        
    }
    
    private void nameShouldBeUnique(WorkoutModel uniqueModel) {
        List<WorkoutModel> workoutsList = repository.findByWorkoutName(uniqueModel.getName());
        if (workoutsList.size() > 1) {
            workoutsList
            .stream()
            .filter(Predicate.not(uniqueModel::equals))
            .forEach(workout -> repository.deleteById(workout.get_id().toString()));
        }
    }

	public WorkoutModel addWorkout(@Valid WorkoutModel workoutModel) throws Exception {
		try {
            WorkoutModel oldWorkoutModel = this.getWorkout(workoutModel.getName());
            oldWorkoutModel.setName(workoutModel.getName());
            this.nameShouldBeUnique(oldWorkoutModel);
            return repository.save(oldWorkoutModel);

        } catch (Exception e) {
            if (NO_DATA_FOUND.equals(e.getMessage())) {
                return repository.save(workoutModel);
            } else {
                throw new Exception(GENERIC_ERROR);
            }
        }
	}

}