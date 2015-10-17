package com.codephobia.domain.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by waldo on 2015-10-17.
 */
@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
}
