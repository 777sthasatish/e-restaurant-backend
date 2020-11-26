package com.cotiviti.erestaurantbackend.domain.port.driver.service;

import com.cotiviti.erestaurantbackend.domain.model.TableModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.TableRepoPort;
import com.cotiviti.erestaurantbackend.domain.port.driver.TableUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TableService implements TableUseCase {

    private final TableRepoPort tableRepoPort;

    @Override
    public List<TableModel> getAll() {
        return tableRepoPort.getAll();
    }
}
