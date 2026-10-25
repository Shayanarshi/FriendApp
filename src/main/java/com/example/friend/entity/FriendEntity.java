package com.example.friend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FRIEND")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FriendEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  Long phoneNumber;

    private Long friendNumber;

    private  String friendName;
    
}
