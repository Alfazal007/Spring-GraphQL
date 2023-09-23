package com.multitable.graphql.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name="student"
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_generator",
            sequenceName = "student_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_generator"
    )
    private Long studentId;
    private String name;


    @ManyToOne
    @JoinColumn(name = "teacher_id",
            referencedColumnName = "teacherId")
    @JsonBackReference
    private Teacher teacher;
}
