package main.entity;

import jakarta.persistence.*;
import lombok.*;
import main.enums.StadyFormat;
@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @SequenceGenerator(name = "course_gen", sequenceName = "course_seq", allocationSize = 1)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @Column
    private int prise;
    @Enumerated(EnumType.STRING)
    private StadyFormat stadyFormat;


    public Course(String courseName, int prise, StadyFormat stadyFormat) {
        this.courseName = courseName;
        this.prise = prise;
        this.stadyFormat = stadyFormat;
    }
}
