package com.guilines.store.model;

import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class WorkoutModel {
    @Id
    public ObjectId _id;

    public String name;

    public WorkoutModel() {
    }

    public WorkoutModel(ObjectId id, String name) {
        this._id = id;
        this.name = name;
    }

    public ObjectId get_id() {
        return this._id;
    }

    public void set_id(ObjectId id) {
        this._id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkoutModel _id(ObjectId id) {
        this._id = id;
        return this;
    }

    public WorkoutModel name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WorkoutModel)) {
            return false;
        }
        WorkoutModel workout = (WorkoutModel) o;
        return Objects.equals(_id, workout._id) && Objects.equals(name, workout.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + get_id() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }


}