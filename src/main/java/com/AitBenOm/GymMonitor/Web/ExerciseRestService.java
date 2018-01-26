package com.AitBenOm.GymMonitor.Web;

import com.AitBenOm.GymMonitor.DAO.ExerciseRepository;
import com.AitBenOm.GymMonitor.DAO.ProgramRepository;
import com.AitBenOm.GymMonitor.DAO.TestRepo;
import com.AitBenOm.GymMonitor.entities.Exercise;
import com.AitBenOm.GymMonitor.entities.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

public class ExerciseRestService {

    @Autowired
    private ExerciseRepository exerciseRepository;

@RequestMapping(value = "/MyExercises", method = RequestMethod.GET)
    public List<Exercise> getExercises(@RequestParam(name = "idProgram") int idProgram){
    return exerciseRepository.getExercisesByProgram(idProgram);
}


}
