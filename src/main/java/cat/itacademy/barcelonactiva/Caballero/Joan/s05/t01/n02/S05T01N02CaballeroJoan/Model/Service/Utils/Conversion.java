package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Service.Utils;

import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Domain.Flor;

import java.util.Arrays;
import java.util.List;

public class Conversion {

    private static final List<String> paisos = Arrays.asList("Àustria", "Bèlgica", "Bulgària", "Croàcia", "República de Xipre", "República Txeca", "Dinamarca", "Estònia", "Finlàndia", "França", "Alemanya", "Grècia", "Hongria", "Irlanda", "Itàlia", "Letònia", "Lituània", "Luxemburg", "Malta", "Països Baixos", "Polònia", "Portugal", "Romania", "Eslovàquia", "Eslovènia", "Espanya", "Suècia");

    public static FlorDTO toFlorDTO(Flor flor){
        Validation.validateFlor(flor);
        return createDTO(flor);
    }

    private static FlorDTO createDTO(Flor flor){
        Integer id = flor.getPk_FlorID();
        String nom = flor.getNomFlor();
        String pais = flor.getPaisFlor();
        String tipus = setTipusFlor(flor.getPaisFlor());
        return new FlorDTO(id, nom, pais, tipus);
    }

    private static String setTipusFlor(String paisFlor){
        if(paisos.contains(paisFlor)){
            return "UE";
        }else{
            return "Fora UE";
        }
    }

    public static Flor DTOtoFlor(FlorDTO florDTO){
        Integer id = florDTO.getPk_FlorID();
        String nom = florDTO.getNomFlor();
        String pais = florDTO.getPaisFlor();
        return new Flor(id, nom, pais);
    }
}
