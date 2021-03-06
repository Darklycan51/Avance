package pe.isil.mghHoteles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reserva implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_generator")
    @SequenceGenerator(name = "reserva_generator", sequenceName = "reserva_seq")
    @Id
    private  Integer idReserva;
    private  String comentarios;
    private  LocalDate fechaIngreso;
    private  LocalDate fechaSalida;
    private  Integer cantidadDePersonas;

    @OneToOne(mappedBy = "reserva", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Usuario usuario;
    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pago> pagos = new ArrayList<>();
    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Habitacion> habitaciones = new ArrayList<>();

    public void addPago(Pago pago){
        pago.setReserva(this);
        this.pagos.add(pago);
    }

    public void removePago(Pago pago){
        pago.setReserva(null);
        this.pagos.remove(pago);
    }

    public void addHabitaciones(Habitacion hab){
        hab.setReserva(this);
        this.habitaciones.add(hab);
    }

    public void removeHabitacion(Habitacion hab){
        hab.setReserva(null);
        this.habitaciones.remove(hab);
    }

    @Override
    public String toString(){
        return "Id: "+idReserva;
    }
}
