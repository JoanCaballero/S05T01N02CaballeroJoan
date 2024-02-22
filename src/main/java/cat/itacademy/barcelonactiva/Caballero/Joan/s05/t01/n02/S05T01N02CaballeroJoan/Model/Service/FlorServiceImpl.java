package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Service;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Domain.Flor;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Repository.FlorRepository;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Service.Utils.Conversion;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Service.Utils.UpdateCommand;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Service.Utils.Validation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlorServiceImpl implements FlorService{

    @Autowired
    private FlorRepository florRepository;

    @Override
    public FlorDTO toFlorDTO(Flor flor) {
        return Conversion.toFlorDTO(flor);
    }

    @Override
    public FlorDTO createFlor(FlorDTO florDTO) {
        Validation.validateFlorDB(florRepository.save(Conversion.DTOtoFlor(florDTO)));
        return florDTO;
    }

    @Override
    public FlorDTO updateFlor(int id, Flor flor) {
        return UpdateCommand.updateFlor(id, flor);
    }

    @Override
    public void deleteFlor(int id) {
        florRepository.deleteById(id);
    }

    @Override
    public FlorDTO getOneFlor(int id) {
        return toFlorDTO(getFlorById(id));
    }

    @Override
    public Flor getFlorById(int id) {
        return florRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Flor with ID: " + id + ". Not Found."));
    }

    @Override
    public List<FlorDTO> getAllFlors() {
        List<Flor> flors = florRepository.findAll();
        return flors.stream().map(this::toFlorDTO).collect(Collectors.toList());
    }
}
