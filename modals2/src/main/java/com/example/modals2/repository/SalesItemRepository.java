package com.example.modals2.repository;

import com.example.modals2.model.Filter;
import com.example.modals2.model.SalesItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface SalesItemRepository extends JpaRepository<SalesItem, Long>, JpaSpecificationExecutor<SalesItem> {

    // More politely would create SalesItemRepositoryImpl class
    default List<SalesItem> findAllByFilter(Filter filter) {
        return findAll(SalesItemSpecifications.specificationsFromFilter(filter));
    }

    default List<SalesItem> findAllByFilters(List<Filter> filters) {
        return findAll(SalesItemSpecifications.specificationsFromFilters(filters));
    }
}
