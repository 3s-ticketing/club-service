package org.ticketing.club.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.ticketing.common.domain.BaseEntity;
import org.ticketing.common.exception.BadRequestException;
import org.ticketing.club.domain.exception.StadiumExceptionMessage;
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
        if (this.deletedAt != null) {
            throw new BadRequestException(StadiumExceptionMessage.ALREADY_DELETED);
        }
        super.delete(deletedBy);
    }

    private void validate(String name, Address address) {
        if (name == null || name.isBlank()) {
            throw new BadRequestException(StadiumExceptionMessage.EMPTY_NAME);
        }
        if (name.length() > 50) {
            throw new BadRequestException(StadiumExceptionMessage.INVALID_NAME);
        }
        if (address == null) {
            throw new BadRequestException(StadiumExceptionMessage.EMPTY_ADDRESS);
        }
    }
}