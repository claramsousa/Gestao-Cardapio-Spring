package org.example.projetofinalminicurso.repository;

import org.example.projetofinalminicurso.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{
}
