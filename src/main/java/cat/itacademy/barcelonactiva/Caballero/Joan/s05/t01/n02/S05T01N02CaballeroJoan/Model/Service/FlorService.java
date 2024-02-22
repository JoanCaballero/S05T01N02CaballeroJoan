package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Service;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Domain.Flor;

import java.util.List;

public interface FlorService {
    FlorDTO toFlorDTO(Flor flor);
    FlorDTO createFlor(FlorDTO florDTO);
    FlorDTO updateFlor(int id, Flor flor);
    void deleteFlor(int id);
    FlorDTO getOneFlor(int id);
    Flor getFlorById(int id);
    List<FlorDTO> getAllFlors();
}
