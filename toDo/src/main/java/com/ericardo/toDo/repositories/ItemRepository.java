package com.ericardo.toDo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericardo.toDo.models.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
