package kr.co.kjc.study.jpastudy.jpa.embedded.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ADDRESS")
@Data
public class AddressEntity {

    @Id
    @GeneratedValue
    private long id;

    private EmbeddedAddress address;

    public AddressEntity() {

    }

    public AddressEntity(EmbeddedAddress address) {
        this.address = address;
    }

    public AddressEntity(String city, String street, String zipcod) {
        this.address = new EmbeddedAddress(city, street, zipcod);
    }
}
