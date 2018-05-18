package com.ericardo.toDo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericardo.toDo.models.Item;
import com.ericardo.toDo.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository _iR;
	
	public void create(Item item) {
		_iR.save(item);
	}
	
	public Item find(Long id) {
		return (Item) _iR.findOne(id);
	}
	
	public void update(Item item) {
		_iR.save(item);
	}
	
	public void destroy(Long id) {
		_iR.delete(id);
	}
	
	public ArrayList<Item> all(){
		return (ArrayList<Item>) _iR.findAll();
	}
	
}
