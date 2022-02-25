package com.ecommerce.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="states")
@Getter
@Setter
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country countries;
    @Column(name="country_code")
    private String code;
    @Column(name="fips_code")
    private String fips_code;
    @Column(name="iso2")
    private String iso2;
    @Column(name="type")
    private String type;
    @Column(name="latitude")
    private BigDecimal latitude;
    @Column(name="longitude")
    private BigDecimal longitude;
    @Column(name="created_at")
    private Date created_at;
    @Column(name="updated_at")
    private Date updated_at;
    @Column(name="flag")
    private Short flag;
    @Column(name="wiki")
    private String wiki;

}
