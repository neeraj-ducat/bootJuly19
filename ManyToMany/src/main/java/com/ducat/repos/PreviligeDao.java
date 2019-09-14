package com.ducat.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Previlige;
@Repository
public interface PreviligeDao extends CrudRepository<Previlige, Integer>
{

}
