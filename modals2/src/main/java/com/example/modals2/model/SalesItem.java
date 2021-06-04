package com.example.modals2.model;

import java.sql.Date;
import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="SalesItem")
public class SalesItem {

    @Id
    @SequenceGenerator(name = "seq1", sequenceName = "seq1", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "title")
    private String title;

    @NonNull
    @Column(name = "text")
    private String text;

    @Column(name = "price")
    private float price;

    @NonNull
    //@Temporal(TemporalType.DATE)
    @Column(name = "date_val")
    private Date date;
}
