package com.example.modals2.repository;

import com.example.modals2.model.Filter;
import org.springframework.data.jpa.domain.Specification;

public class FilterSpecifications {

    public static Specification<Filter> idEquals(long id) {
        return (root, query, builder) -> builder.equal(root.get("id"), id);
    }

    public static Specification<Filter> specificationsFromIds(long[] ids) {
        Specification<Filter> spec = Specification.where(idEquals(ids[0]));
        for (int i = 1; i < ids.length; i++) {
            spec = spec.or(idEquals(ids[i]));
        }
        return spec;
    }
}
