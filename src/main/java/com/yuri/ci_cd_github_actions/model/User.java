package com.yuri.ci_cd_github_actions.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;

}
