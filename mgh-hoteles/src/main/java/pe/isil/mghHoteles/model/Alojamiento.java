package pe.isil.mghHoteles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Alojamiento implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alojamiento_generator")
    @SequenceGenerator(name = "alojamiento_generator", sequenceName = "alojamiento_seq")
    @Id
    private Integer idAlojamiento;
    private String nombre;
    private Integer valoracion;
    private String tipo;
    private String codAlojamiento;
    private Integer numeroDeHabitaciones;
    private Integer ubigeo;

    @OneToMany(mappedBy = "alojamiento", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Habitacion> habitaciones = new ArrayList<>();
    @OneToMany(mappedBy = "alojamiento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Foto> fotos = new ArrayList<>();

    public void addHabitacion(Habitacion hab){
        hab.setAlojamiento(this);
        this.habitaciones.add(hab);
    }

    public void removeHabitacion(Habitacion hab){
        hab.setAlojamiento(null);
        this.habitaciones.remove(hab);
    }
    public void addFoto(Foto foto){
        foto.setAlojamiento(this);
        this.fotos.add(foto);
    }

    public void removeFoto(Foto foto){
        foto.setAlojamiento(null);
        this.fotos.remove(foto);
    }

    @Override
    public String toString(){
        return "Id: "+idAlojamiento;
    }
}
