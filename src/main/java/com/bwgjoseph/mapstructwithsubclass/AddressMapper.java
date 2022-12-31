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
)
public interface AddressMapper {
    @SubclassMapping(source = HomeAddressRequestDto.class, target = HomeAddressDO.class)
    @SubclassMapping(source = OfficeAddressRequestDto.class, target = OfficeAddressDO.class)
    AddressDO toDomainObject(AddressRequestDto addressDto);

    @SubclassMapping(source = HomeAddressDO.class, target = HomeAddressResponseDto.class)
    @SubclassMapping(source = OfficeAddressDO.class, target = OfficeAddressResponseDto.class)
    @Mapping(source = "auditable", target = ".")
    AddressResponseDto toDto(AddressDO addressDo);

    @InheritConfiguration(name = "toDto")
    HomeAddressResponseDto toHomeDto(HomeAddressDO homeAddressDO);

    @InheritConfiguration(name = "toDto")
    OfficeAddressResponseDto toOfficeDto(OfficeAddressDO officeAddressDO);

    @SubclassMapping(source = HomeAddressRequestDto.class, target = HomeAddressDO.class)
    @SubclassMapping(source = OfficeAddressRequestDto.class, target = OfficeAddressDO.class)
    AddressDO toUpdateDomainObject(AddressRequestDto addressRequestDto, @MappingTarget AddressDO.AddressDOBuilder<?, ?> addressDOBuilder);

    HomeAddressDO toUpdateHomeDomainObject(HomeAddressRequestDto homeAddressRequestDto, @MappingTarget HomeAddressDO.HomeAddressDOBuilder<?, ?> homeAddressDOBuilder);

    OfficeAddressDO toUpdateOfficeDomainObject(OfficeAddressRequestDto officeAddressRequestDto, @MappingTarget OfficeAddressDO.OfficeAddressDOBuilder<?, ?> officeAddressDOBuilder);
}
