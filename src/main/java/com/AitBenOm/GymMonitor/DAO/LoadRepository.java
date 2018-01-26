package com.AitBenOm.GymMonitor.DAO;

import com.AitBenOm.GymMonitor.entities.Charge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadRepository extends JpaRepository<Charge,Long> {
}
