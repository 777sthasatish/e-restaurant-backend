package com.cotiviti.erestaurantbackend.drivenadapter.adapter;

import com.cotiviti.erestaurantbackend.domain.model.TableModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.TableRepoPort;
import com.cotiviti.erestaurantbackend.drivenadapter.mapper.TableMapper;
import com.cotiviti.erestaurantbackend.drivenadapter.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class TableAdapter implements TableRepoPort {

    private final TableRepository tableRepository;
    private final TableMapper tableMapper = Mappers.getMapper(TableMapper.class);

    @Override
    public List<TableModel> getAll() {
        return tableMapper.toModels(tableRepository.findAll());
    }
}
