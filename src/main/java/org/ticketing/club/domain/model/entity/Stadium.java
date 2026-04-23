package org.ticketing.club.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.iimsa.common.domain.BaseEntity;
import org.ticketing.club.domain.model.vo.Address;

import java.util.UUID;

@Entity
@Table(name = "p_stadium")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stadium extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String name;

    @Embedded
    private Address address;

    @Builder(access = AccessLevel.PRIVATE)
    private Stadium(String name, Address address) {
        validate(name, address);
        this.name = name;
        this.address = address;
    }

    public static Stadium create(String name, Address address) {
        return Stadium.builder()
                .name(name)
                .address(address)
                .build();
    }

    public void update(String name, Address address) {
        validate(name, address);
        this.name = name;
        this.address = address;
    }

    public void delete(String deletedBy) {
        super.delete(deletedBy);
    }

    private void validate(String name, Address address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("경기장 이름은 필수입니다.");
        }
        if (address == null) {
            throw new IllegalArgumentException("주소는 필수입니다.");
        }
    }
}