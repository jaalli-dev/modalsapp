package com.example.modals2.model;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SubFilter")
public class SubFilter {

    @Id
    @SequenceGenerator(name = "seq3", sequenceName = "seq3", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq3")
    @Column(name = "id")
    private long id;

    @Column(name = "filter_type")
    private int type; // 1 ... 12 - see SalesItemSpecifications.specificationsFromFilters

    @Column(name = "text")
    private String text;

    @Column(name = "date_val")
    private Date date; // Hacky and not nice
}
