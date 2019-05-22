package com.adam.cms.dao;

import com.adam.cms.model.Customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer> {

	@Override
	List<Customer> findAll();
}
