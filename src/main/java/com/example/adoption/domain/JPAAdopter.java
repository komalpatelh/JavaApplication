package com.example.adoption.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Profile;

@Entity //Comunicagte to JPA into the database
@Table(name="adopter")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor //Not null
@NoArgsConstructor
@Getter
@Setter
@Profile("prod")
//fields
public class JPAAdopter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adopter_id_seq")
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String email;
}
