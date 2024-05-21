package com.example.adoption.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.context.annotation.Profile;

@Entity //Comunicagte to JPA into the database
@Table(name="animal")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor //Not null
@NoArgsConstructor
@Getter
@Setter
@Profile("prod")
public class JPAAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_id_seq")
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "adopter_id")
    private JPAAdopter jpaAdopter;
    @NonNull
    private String name;
    @NonNull
    private String breed;
    @NonNull
    private Integer age;
    @NonNull
    private String type;

}
