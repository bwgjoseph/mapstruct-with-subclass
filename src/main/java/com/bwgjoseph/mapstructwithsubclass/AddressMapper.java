package com.bwgjoseph.mapstructwithsubclass;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION
    // nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface AddressMapper {
    @SubclassMapping(source = HomeAddressRequestDto.class, target = HomeAddressDO.class)
    @SubclassMapping(source = OfficeAddressRequestDto.class, target = OfficeAddressDO.class)
    AddressDO toDomainObject(AddressRequestDto addressDto);

    @SubclassMapping(source = HomeAddressDO.class, target = HomeAddressResponseDto.class)
    @SubclassMapping(source = OfficeAddressDO.class, target = OfficeAddressResponseDto.class)
    @Mapping(source = "auditable", target = ".")
    AddressResponseDto toDto(AddressDO addressDo);

    default GeoJsonPoint mapToGeoJsonPoint(Point location) {
        return new GeoJsonPoint(location.lng(), location.lat());
    }

    default Point mapToPoint(GeoJsonPoint location) {
        return new Point(location.x(), location.y());
    }

    default String mapCountry(CountryInput country) {
        return country.getInput();
    }

    default CountryInput mapCountryInput(String country) {
        return new CountryInput(country);
    }

    @InheritConfiguration(name = "toDto")
    // @Mapping(source = "country", target = "country", nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
    HomeAddressResponseDto toHomeDto(HomeAddressDO homeAddressDO);

    @InheritConfiguration(name = "toDto")
    OfficeAddressResponseDto toOfficeDto(OfficeAddressDO officeAddressDO);

    // @SubclassMapping(source = HomeAddressRequestDto.class, target = HomeAddressDO.class)
    // @SubclassMapping(source = OfficeAddressRequestDto.class, target = OfficeAddressDO.class)
    default AddressDO toUpdateDomainObject(AddressRequestDto addressRequestDto, @MappingTarget AddressDO addressDO) {
        if ( addressDO == null ) {
            return null;
        }

        if (addressDO instanceof HomeAddressDO) {
            return toUpdateHomeDomainObject((HomeAddressRequestDto) addressRequestDto, HomeAddressDO.builder() );
        }
        else if (addressDO instanceof OfficeAddressDO) {
            return toUpdateOfficeDomainObject((OfficeAddressRequestDto) addressRequestDto, OfficeAddressDO.builder() );
        }
        else {
            throw new IllegalArgumentException("Not all subclasses are supported for this mapping. Missing for " + addressDO.getClass());
        }
    }

    HomeAddressDO toUpdateHomeDomainObject(HomeAddressRequestDto homeAddressRequestDto, @MappingTarget HomeAddressDO.HomeAddressDOBuilder<?, ?> homeAddressDOBuilder);

    OfficeAddressDO toUpdateOfficeDomainObject(OfficeAddressRequestDto officeAddressRequestDto, @MappingTarget OfficeAddressDO.OfficeAddressDOBuilder<?, ?> officeAddressDOBuilder);
}
