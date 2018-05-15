package com.ericardo.toDo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericardo.toDo.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
	public List<Task> findByTaskName(String taskName);
}
