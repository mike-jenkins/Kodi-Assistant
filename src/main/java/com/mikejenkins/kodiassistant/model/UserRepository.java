package com.mikejenkins.kodiassistant.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * @author Mike Jenkins
 * @version x.x, 12/15/2016
 * @since x.x
 */
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
