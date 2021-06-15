package com.abb.repository;

import com.abb.entity.Release;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ReleaseRepository extends CrudRepository<Release, Long> {
}