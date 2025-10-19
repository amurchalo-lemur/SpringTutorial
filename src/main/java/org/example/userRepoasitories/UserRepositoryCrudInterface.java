package org.example.userRepoasitories;

import org.example.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryCrudInterface extends CrudRepository<User, Long> {


    @Query("select * from public.user a where a.name = :name")
    List<User> findByName(@Param("name") String name);


}
