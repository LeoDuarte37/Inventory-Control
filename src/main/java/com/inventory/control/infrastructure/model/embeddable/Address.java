package com.inventory.control.infrastructure.model.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Address {

    @Column(name = "country")
    private String country;

    @Column(name = "state_name")
    private String state;

    @Column(name = "zip_code")
    private String zipcode;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "street")
    private String street;

    @Column(name = "building_number")
    private String buildingNumber;

    @Column(name = "unit_number")
    private int unitNumber;
}
