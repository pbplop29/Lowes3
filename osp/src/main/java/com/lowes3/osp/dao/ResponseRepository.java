package com.lowes3.osp.dao;

import com.lowes3.osp.entity.Response;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Integer> {}
