package com.cotiviti.erestaurantbackend.domain.port;

import com.cotiviti.erestaurantbackend.domain.model.TableModel;

import java.util.List;

public interface TablePort {
    List<TableModel> getAll();
}
