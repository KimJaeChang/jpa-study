package kr.co.kjc.study.jpastudy.jpa.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcode;

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Address() {

    }
}
