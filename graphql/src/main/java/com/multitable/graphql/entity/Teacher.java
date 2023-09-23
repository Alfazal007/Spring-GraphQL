package com.multitable.graphql.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name="teacher"
)
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_generator",
            sequenceName = "teacher_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_generator"
    )
    private Long teacherId;
    private String name;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "course_id"
    )
    @JsonBackReference
    private Courses course;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Student> students;
}
