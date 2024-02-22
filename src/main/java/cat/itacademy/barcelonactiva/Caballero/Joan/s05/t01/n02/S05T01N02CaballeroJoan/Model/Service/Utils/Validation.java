package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Service.Utils;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Domain.Flor;

public class Validation {

    public static void validateFlorDB(Flor flor){
        if(flor == null || flor.getNomFlor() == null || flor.getPaisFlor() == null){
            throw new IllegalArgumentException("Invalid flor data");
        }
    }

    public static void validateFlor(Flor flor){
        if(flor == null || flor.getPk_FlorID() == null || flor.getNomFlor() == null || flor.getPaisFlor() == null){
            throw new IllegalArgumentException("Invalid flor data.");
        }
    }

}
