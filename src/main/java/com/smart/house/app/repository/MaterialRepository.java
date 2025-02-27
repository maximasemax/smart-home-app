package com.smart.house.app.repository;

import com.smart.house.app.entity.Material;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MaterialRepository extends JpaRepository<Material, Long> {

    Optional<Material> findByName(String name);


}
