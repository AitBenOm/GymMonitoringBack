package com.AitBenOm.GymMonitor.Web;

import com.AitBenOm.GymMonitor.DAO.ExerciseRepository;
import com.AitBenOm.GymMonitor.DAO.LoadRepository;
import com.AitBenOm.GymMonitor.DAO.ProgramRepository;
import com.AitBenOm.GymMonitor.DAO.TestRepo;
import com.AitBenOm.GymMonitor.entities.Program;
import com.AitBenOm.GymMonitor.entities.Test;
import com.AitBenOm.GymMonitor.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

public class ProgramRestService {


    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private LoadRepository loadRepository;

    @Autowired
    private ProgramRepository programRepository;



@RequestMapping(value = "/MyProgram", method = RequestMethod.GET)
    public Program getProgram(   @RequestParam(name = "idProgram") int idProgram){
    return programRepository.getProgramsById(idProgram);
}
@RequestMapping(value = "/MyPrograms", method = RequestMethod.GET)
    public List<Program> getPrograms(   @RequestParam(name = "idUser") int idUser){
    return programRepository.getProgramsByUser(idUser);
}
@RequestMapping(value = "/Programs", method = RequestMethod.GET)
    public List<Program> getPrograms(  ){
    return programRepository.findAll();
}

    @RequestMapping(value = "/MyProgram/{id}", method = RequestMethod.PUT)
    public Program updateProgram(@PathVariable int idProgram,@RequestBody Program program){
        program.setIdProgram(idProgram);
        return  programRepository.save(program);
    }

    @RequestMapping(value = "/MyProgram", method = RequestMethod.POST)
    public Program saveContact(@RequestBody Program program){

        User user = new User("omar","ait benaissa","omar.benaissa@outlook.com","123456");

        program.setUser(user);
        programRepository.save(program);
        program.getExercises().get(0).setProgram(program);
        exerciseRepository.save( program.getExercises().get(0));
        program.getExercises().get(0).getCharges().get(0).setExercise(  program.getExercises().get(0));
        loadRepository.save(  program.getExercises().get(0).getCharges().get(0));

        return  programRepository.save(program);
    }

    @RequestMapping(value = "/MyProgram/{id}", method = RequestMethod.DELETE)
    public boolean deleteProgram(@PathVariable int idProgram){
        programRepository.delete((long) idProgram);
        return true;
    }


}
