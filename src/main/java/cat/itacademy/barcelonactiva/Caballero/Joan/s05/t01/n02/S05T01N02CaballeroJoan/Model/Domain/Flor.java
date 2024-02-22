package cat.itacademy.barcelonactiva.Caballero.Joan.s05.t01.n02.S05T01N02CaballeroJoan.Model.Domain;

import jakarta.persistence.*;

@Entity
@Table(name= "flor")
public class Flor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pk_FlorID;
    @Column
    private String nomFlor;
    @Column
    private String paisFlor;

    public Flor(){
    }

    public Flor(Integer id, String nomFlor, String paisFlor){
        this.pk_FlorID = id;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
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
}
