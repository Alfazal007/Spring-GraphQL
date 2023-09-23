package com.multitable.graphql.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name="course"
)
public class Courses {
    @Id
    @SequenceGenerator(
            name = "course_generator",
            sequenceName = "course_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_generator"
    )
    private Long courseId;

    private String name;
    private String platform;
    @OneToOne(
            mappedBy = "course", cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private Teacher teacher;
}
