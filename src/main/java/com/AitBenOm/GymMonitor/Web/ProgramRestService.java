package com.AitBenOm.GymMonitor.Web;

import com.AitBenOm.GymMonitor.DAO.ProgramRepository;
import com.AitBenOm.GymMonitor.DAO.TestRepo;
import com.AitBenOm.GymMonitor.entities.Program;
import com.AitBenOm.GymMonitor.entities.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

public class ProgramRestService {

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private TestRepo testRepo;

@RequestMapping(value = "/MyPrograms", method = RequestMethod.GET)
    public List<Program> getPrograms(   @RequestParam(name = "idUser") int idUser){
    return programRepository.getProgramsByUser(idUser);
}


}
