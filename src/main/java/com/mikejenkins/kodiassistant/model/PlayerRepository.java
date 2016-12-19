package com.mikejenkins.kodiassistant.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/13/2016
 * @since 0.1.0
 */

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer>{
}
