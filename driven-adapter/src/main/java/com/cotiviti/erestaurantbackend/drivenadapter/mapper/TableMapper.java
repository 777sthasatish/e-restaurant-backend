package com.cotiviti.erestaurantbackend.drivenadapter.mapper;

import com.cotiviti.erestaurantbackend.domain.model.TableModel;
import com.cotiviti.erestaurantbackend.drivenadapter.entity.Table;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TableMapper {
    List<TableModel> toModels (List<Table> tables);
}
