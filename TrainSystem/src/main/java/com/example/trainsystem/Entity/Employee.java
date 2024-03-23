package com.example.trainsystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String name;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "JobPosition_id")

   private JobPosition jobPosition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Department_id")
   private Department department;

}
