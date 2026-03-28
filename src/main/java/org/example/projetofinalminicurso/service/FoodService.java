package org.example.projetofinalminicurso.service;

import lombok.NonNull;
import org.example.projetofinalminicurso.dto.FoodRequestDTO;
import org.example.projetofinalminicurso.entities.Food;
import org.example.projetofinalminicurso.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> listAll(){
        return foodRepository.findAll()
                .stream()
                .collect(Collectors.toList());

    }

    public void deleteById(@NonNull Long id){
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("food not found with id " + id));
        foodRepository.delete(food);
    }

    public void saveFood(FoodRequestDTO data){
        Food foodData = new Food();
        foodData.setTitle(data.title());
        foodData.setPrice(data.price());
        foodData.setImage(data.image());

        foodRepository.save(foodData);
    }

    public void updateFood(Long id, FoodRequestDTO data){
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        food.setTitle(data.title());
        food.setPrice(data.price());
        food.setImage(data.image());

        foodRepository.save(food);
    }
}
