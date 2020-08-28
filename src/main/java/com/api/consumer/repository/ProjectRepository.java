package com.api.consumer.repository;

import com.api.consumer.model.Record;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Record, Long> {

}
