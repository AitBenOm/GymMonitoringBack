package com.AitBenOm.GymMonitor.DAO;

import com.AitBenOm.GymMonitor.entities.Exercise;
import com.AitBenOm.GymMonitor.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise,Long> {
}
