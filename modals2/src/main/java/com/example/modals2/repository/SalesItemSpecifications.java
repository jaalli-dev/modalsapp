package com.example.modals2.repository;

import com.example.modals2.model.Filter;
import com.example.modals2.model.SalesItem;
import com.example.modals2.model.SubFilter;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Date;
import java.text.MessageFormat;
import java.util.List;

public final class SalesItemSpecifications {

    // Ugly boilerplate
    public static Specification<SalesItem> textContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("text"), contains(expression));
    }
    public static Specification<SalesItem> titleContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("title"), contains(expression));
    }
    public static Specification<SalesItem> textBegins(String expression) {
        return (root, query, builder) -> builder.like(root.get("text"), beginsWith(expression));
    }
    public static Specification<SalesItem> titleBegins(String expression) {
        return (root, query, builder) -> builder.like(root.get("title"), beginsWith(expression));
    }
    public static Specification<SalesItem> textEnds(String expression) {
        return (root, query, builder) -> builder.like(root.get("text"), endsWith(expression));
    }
    public static Specification<SalesItem> titleEnds(String expression) {
        return (root, query, builder) -> builder.like(root.get("title"), endsWith(expression));
    }
    public static Specification<SalesItem> textEquals(String expression) {
        return (root, query, builder) -> builder.equal(root.get("text"), expression);
    }
    public static Specification<SalesItem> titleEquals(String expression) {
        return (root, query, builder) -> builder.equal(root.get("title"), expression);
    }
    public static Specification<SalesItem> dateIsBefore(Date date) {
        return (root, query, builder) -> builder.lessThan(root.<Date>get("date"), date);
    }
    public static Specification<SalesItem> dateIsAfter(Date date) {
        return (root, query, builder) -> builder.greaterThan(root.<Date>get("date"), date);
    }
    public static Specification<SalesItem> priceIsLess(float price) {
        return (root, query, builder) -> builder.lessThan(root.get("price"), price);
    }
    public static Specification<SalesItem> priceIsMore(float price) {
        return (root, query, builder) -> builder.greaterThan(root.get("price"), price);
    }

    public static Specification<SalesItem> specificationsFromFilter(Filter filter) {
        Specification<SalesItem> spec = Specification.where(null);
        float price = 0;

        for (SubFilter each : filter.getSubfilters()) {
            // Ugly switch
            if (isNumeric(each.getText())) {
                price = Float.parseFloat(each.getText());
            }

            switch (each.getType()) {
                case 1:
                    spec = spec.and(titleContains(each.getText()));
                    break;
                case 2:
                    spec = spec.and(textContains(each.getText()));
                    break;
                case 3:
                    spec = spec.and(titleBegins(each.getText()));
                    break;
                case 4:
                    spec = spec.and(textBegins(each.getText()));
                    break;
                case 5:
                    spec = spec.and(titleEnds(each.getText()));
                    break;
                case 6:
                    spec = spec.and(textEnds(each.getText()));
                    break;
                case 7:
                    spec = spec.and(titleEquals(each.getText()));
                    break;
                case 8:
                    spec = spec.and(textEquals(each.getText()));
                    break;
                case 9:
                    spec = spec.and(priceIsLess(price));
                    break;
                case 10:
                    spec = spec.and(priceIsMore(price));
                    break;
                case 11:
                    spec = spec.and(each.getDate() == null ? null : dateIsBefore(each.getDate()));
                    break;
                case 12:
                    spec = spec.and(each.getDate() == null ? null : dateIsAfter(each.getDate()));
                    break;
            }
        }

        return spec;
    }

    public static Specification<SalesItem> specificationsFromFilters(List<Filter> filters) {
        Specification<SalesItem> spec = Specification.where(null);
        for (Filter each : filters) {
            spec = spec.and(specificationsFromFilter(each));
        }
        return spec;
    }

    private static String contains(String expression) {
        return MessageFormat.format("%{0}%", expression);
    }
    private static String beginsWith(String expression) {
        return MessageFormat.format("{0}%", expression);
    }
    private static String endsWith(String expression) {
        return MessageFormat.format("%{0}", expression);
    }
    private static boolean isNumeric(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c < 48 || c > 57) { // ASCII numbers
                return false;
            }
        }
        return true;
    }
}
