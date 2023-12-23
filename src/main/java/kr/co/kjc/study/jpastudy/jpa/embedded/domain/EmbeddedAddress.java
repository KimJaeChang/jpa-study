package kr.co.kjc.study.jpastudy.jpa.embedded.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Embeddable
public class EmbeddedAddress {

    private String city;
    private String street;
    private String zipcode;

    public EmbeddedAddress(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public EmbeddedAddress() {

    }
}
