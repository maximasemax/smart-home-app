package com.smart.house.app.repository;

import com.smart.house.app.entity.SmartDeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartDeviceTypeRepository extends JpaRepository<SmartDeviceType, Long> {
}
