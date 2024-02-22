package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Service.Utils;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Domain.Flor;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Repository.FlorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UpdateCommand {

    private static FlorRepository florRepository;

    @Autowired
    public UpdateCommand(FlorRepository florRepository){
        UpdateCommand.florRepository = florRepository;
    }
    public static FlorDTO updateFlor(int id, Flor flor){
        Flor oldFlor = getOldFlor(id);
        Flor newFlor = updateOldFlor(oldFlor, flor);
        return Conversion.toFlorDTO(saveFlor(newFlor));
    }

    private static Flor getOldFlor(Integer id){
        Optional<Flor> oldFlor = florRepository.findById(id);
        if(oldFlor.isPresent()){
            return oldFlor.get();
        }else{
            throw new EntityNotFoundException("Flor amb ID: " + id + ". No trobada.");
        }
    }

    private static Flor updateOldFlor(Flor oldFlor, Flor newFlor){
        oldFlor.setNomFlor(newFlor.getNomFlor());
        oldFlor.setPaisFlor(newFlor.getPaisFlor());
        return oldFlor;
    }

    private static Flor saveFlor(Flor flor){return florRepository.save(flor);}
}
