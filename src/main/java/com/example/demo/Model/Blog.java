package com.example.demo.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String Title;

    @NotEmpty
    @Column(columnDefinition = " varchar(20) not null check (category='health' or 'education' or 'programming')")
    private String category;

    @NotEmpty
    @Size(max = 300, message = " should be String mix 300 letters")
    @Column(columnDefinition = "varchar(20) not null")
    private String body;

    @NotEmpty
    @Column(columnDefinition = "boolean defualt false")
    private boolean isPublished=false;
}
