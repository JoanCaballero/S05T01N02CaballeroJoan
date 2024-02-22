package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Controllers;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Domain.Flor;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Service.FlorService;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Service.Utils.Conversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")
public class FlorController {

    @Autowired
    private FlorService florService;

    @PostMapping("/add")
    public ResponseEntity<FlorDTO> florAdd(@RequestBody Flor flor){
        return new ResponseEntity<>(florService.createFlor(Conversion.toFlorDTO(flor)), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FlorDTO> florUpdate(@PathVariable Integer id, @RequestBody Flor flor){
        return new ResponseEntity<>(florService.updateFlor(id, flor), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> florDelete(@PathVariable Integer id){
        florService.deleteFlor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDTO> florGetOne(@PathVariable Integer id){
        FlorDTO florDTO = florService.getOneFlor(id);
        return new ResponseEntity<>(florDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDTO>> florGetAll(){
        List<FlorDTO> flores = florService.getAllFlors();
        return new ResponseEntity<>(flores, HttpStatus.OK);
    }
}

