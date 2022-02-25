package com.ecommerce.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="countries")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="iso3")
    private String iso3;
    @Column(name="numeric_code")
    private String numeric_code;
    @Column(name="iso2")
    private String iso2;
    @Column(name="phonecode")
    private String phoneCode;
    @Column(name="capital")
    private String capital;
    @Column(name="currency")
    private String currency;
    @Column(name="currency_symbol")
    private String currency_symbol;
    @Column(name="tld")
    private String tld;
    @Column(name="_native")
    private String _native;
    @Column(name="region")
    private String region;
    @Column(name="subregion")
    private String subregion;
    @Column(name="timezones")
    private String timezones;
    @Column(name="translations")
    private String translations;
    @Column(name="latitude")
    private BigDecimal latitude;
    @Column(name="longitude")
    private BigDecimal longitude;
    @Column(name="emoji")
    private String emoji;
    @Column(name="emojiU")
    private String emojiU;
    @Column(name="created_at")
    private Date created_at;
    @Column(name="updated_at")
    private Date updated_at;
    @Column(name="flag")
    private Short flag;
    @Column(name="wiki")
    private String wiki;

    @OneToMany(mappedBy = "countries")
    private List<State> states;

}
