package com.lowes3.osp.dao;

import com.lowes3.osp.entity.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends CrudRepository<Survey,Integer> {}
