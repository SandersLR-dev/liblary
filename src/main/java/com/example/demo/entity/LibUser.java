package com.example.demo.entity;

import com.example.demo.role.LibUserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LibUser {
    @Id
    @GeneratedValue(
          strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private LocalDate dob;
    private LibUserRole libUserRole;



}
