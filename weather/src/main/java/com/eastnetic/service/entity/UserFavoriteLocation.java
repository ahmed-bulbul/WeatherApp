package com.eastnetic.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "user_favorite_location")
public class UserFavoriteLocation extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="fav_location_seq_gen")
    @SequenceGenerator(name="fav_location_seq_gen", sequenceName="user_favorite_location_seq", allocationSize = 1)

    private Long id;

    @JoinColumn(name = "USER_ID")
    @ManyToOne
    private User user;

    private Long locationId;
    private String locationDetails;
    private Double latitude;
    private Double longitude;
}
