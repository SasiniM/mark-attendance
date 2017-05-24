package org.dialog.hack.repository;

import org.dialog.hack.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by sasini on 5/24/17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}
