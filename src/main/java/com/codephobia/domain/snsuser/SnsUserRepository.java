package com.codephobia.domain.snsuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by waldo on 2015-10-17.
 */

@Repository
public interface SnsUserRepository extends JpaRepository<SnsUser, Integer> {

}
