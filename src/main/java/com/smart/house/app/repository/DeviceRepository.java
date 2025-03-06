package com.smart.house.app.repository;

import com.smart.house.app.entity.Material;
import com.smart.house.app.entity.SmartDevice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceRepository extends JpaRepository<SmartDevice, Long > {

    Optional<SmartDevice> findByName(String name);
}
