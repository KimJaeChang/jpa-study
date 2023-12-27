package kr.co.kjc.study.jpastudy.jpql.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Embeddable
public class JpqlAddress {

    private String city;
    private String street;
    private String zipcode;

    public JpqlAddress(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public JpqlAddress() {

    }
}
