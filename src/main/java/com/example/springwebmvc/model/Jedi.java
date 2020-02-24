package com.example.springwebmvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter @NoArgsConstructor
public class Jedi {

    @Id
    @Column(name = "jedi_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "jedi_name")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters")
    private String name;

    @Column(name = "jedi_last_name")
    @Size(max = 20, message = "Last name must not have more than 20 letters")
    private String lastName;

    public Jedi(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
