package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.DTO;

import jakarta.persistence.Column;

public class FlorDTO {
    private Integer pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor;

    public FlorDTO(){
    }

    public FlorDTO(Integer id, String nomFlor, String paisFlor, String tipusFlor){
        this.pk_FlorID = id;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
        this.tipusFlor = tipusFlor;
    }

    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public String getNomFlor() {
        return nomFlor;
    }

    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    public String getTipusFlor(){
        return tipusFlor;
    }

    public void setTipusFlor(String tipusFlor){
        this.tipusFlor = tipusFlor;
    }
}
