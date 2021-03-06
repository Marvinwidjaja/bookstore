package com.ecommerce.test.dao;

import com.ecommerce.test.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RepositoryRestResource
public interface StateRepository extends JpaRepository<State,Integer> {
    List<State> findByCountriesCode(@Param("code") String code);
}
