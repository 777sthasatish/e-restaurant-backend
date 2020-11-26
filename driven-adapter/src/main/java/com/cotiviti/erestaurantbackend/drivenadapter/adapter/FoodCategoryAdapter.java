package com.cotiviti.erestaurantbackend.drivenadapter.adapter;

import com.cotiviti.erestaurantbackend.domain.model.FoodCategoryModel;
import com.cotiviti.erestaurantbackend.domain.port.driven.FoodCategoryRepoPort;
import com.cotiviti.erestaurantbackend.drivenadapter.entity.FoodCategory;
import com.cotiviti.erestaurantbackend.drivenadapter.mapper.FoodCategoryMapper;
import com.cotiviti.erestaurantbackend.drivenadapter.repository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class FoodCategoryAdapter implements FoodCategoryRepoPort {

    private final FoodCategoryRepository foodCategoryRepository;
    private final FoodCategoryMapper foodCategoryMapper = Mappers.getMapper(FoodCategoryMapper.class);

    @Override
    public List<FoodCategoryModel> getAll() {
        return foodCategoryMapper.toModels(foodCategoryRepository.findAll());
    }

}
