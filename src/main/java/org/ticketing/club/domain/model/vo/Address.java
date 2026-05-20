package org.ticketing.club.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String city;
    private String district;
    private String detail;

    public Address(String city, String district, String detail) {
        validate(city, district, detail);
        this.city = city;
        this.district = district;
        this.detail = detail;
    }

    private void validate(String city, String district, String detail) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("도시는 필수입니다.");
        }
        if (district == null || district.isBlank()) {
            throw new IllegalArgumentException("구/군은 필수입니다.");
        }
        if (detail == null || detail.isBlank()) {
            throw new IllegalArgumentException("상세주소는 필수입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address that)) return false;
        return Objects.equals(city, that.city) &&
                Objects.equals(district, that.district) &&
                Objects.equals(detail, that.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, district, detail);
    }
}