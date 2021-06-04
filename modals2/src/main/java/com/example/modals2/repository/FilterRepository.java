package com.example.modals2.repository;

import com.example.modals2.model.Filter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FilterRepository extends JpaRepository<Filter, Long>, JpaSpecificationExecutor<Filter> {

    default List<Filter> findAllByIds(long[] ids) {
        return findAll(FilterSpecifications.specificationsFromIds(ids));
    }
}
