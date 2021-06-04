package com.example.modals2.model;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Filter")
public class Filter {

    @Id
    @SequenceGenerator(name = "seq2", sequenceName = "seq2", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "title")
    private String title;

/*    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="SubFilter",
            joinColumns=@JoinColumn(name = "id",
                    referencedColumnName = "id"))*/
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "filter_id")
    List<SubFilter> subfilters = new ArrayList<>();

}
