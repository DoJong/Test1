package com.codephobia.domain.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by benimario on 15. 10. 17..
 */
@Repository
public interface RequestApplyRepository extends JpaRepository<RequestApply, Long> {
}
