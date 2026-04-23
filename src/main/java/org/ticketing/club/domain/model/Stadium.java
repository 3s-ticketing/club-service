package org.ticketing.club.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.iimsa.common.domain.BaseEntity;

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

    @Column(nullable = false, length = 255)
    private String address;

    @Builder(access = AccessLevel.PRIVATE)
    private Stadium(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public static Stadium create(String name, String address) {
        validate(name, address);
        return Stadium.builder()
                .name(name)
                .address(address)
                .build();
    }

    public void update(String name, String address) {
        if (name != null) {
            validateName(name);
            this.name = name;
        }
        if (address != null) {
            validateAddress(address);
            this.address = address;
        }
    }

    public void deleteStadium(String deletedBy) {
        super.delete(deletedBy);
    }

    private static void validate(String name, String address) {
        validateName(name);
        validateAddress(address);
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("경기장 이름은 필수입니다.");
        }
    }

    private static void validateAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("경기장 주소는 필수입니다.");
        }
    }
}