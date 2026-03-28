package org.example.projetofinalminicurso.controller;

import org.example.projetofinalminicurso.dto.FoodRequestDTO;
import org.example.projetofinalminicurso.entities.Food;
import org.example.projetofinalminicurso.repository.FoodRepository;
import org.example.projetofinalminicurso.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/get")
    public ResponseEntity<List<Food>> listFoods(){
        List<Food> foods = foodService.listAll();
        return new ResponseEntity<List<Food>>(foods, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
     try{
         foodService.deleteById(id);
         return ResponseEntity.noContent().build();
     }catch (RuntimeException e){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
     }
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody FoodRequestDTO data){
        try {
            foodService.saveFood(data);
            return ResponseEntity.status(HttpStatus.CREATED).body("Food successfully registered.");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error saving food: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody FoodRequestDTO data){
        try{
            foodService.updateFood(id, data);
            return ResponseEntity.ok().body("Food updated successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
