package com.casemodul04.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String username;
    private String password;
    private String fullname;
    private String phonenumber;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;


}
