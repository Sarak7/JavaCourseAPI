package org.example.mappers;
import org.example.dto.JobsDto;
import org.example.dto.EmployeesDto;
import org.example.models.Employees;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    EmployeesDto toEmpDto(Employees employee);

    Employees toModel(EmployeesDto dto);

}
