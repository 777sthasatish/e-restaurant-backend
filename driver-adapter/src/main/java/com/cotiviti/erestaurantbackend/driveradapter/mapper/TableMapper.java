package com.cotiviti.erestaurantbackend.driveradapter.mapper;

import com.cotiviti.erestaurantbackend.domain.model.TableModel;
import com.cotiviti.erestaurantbackend.driveradapter.dto.TableDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TableMapper {
    List<TableDTO> toDTOs(List<TableModel> tableModels);
}
