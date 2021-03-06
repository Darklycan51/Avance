package pe.isil.mghHoteles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.isil.mghHoteles.model.*;
import pe.isil.mghHoteles.repository.*;

import java.time.LocalDate;

@Slf4j
@SpringBootApplication
public class MghHotelesApplication implements CommandLineRunner {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PagoRepository pagoRepository;
    @Autowired
    HabitacionRepository habitacionRepository;
    @Autowired
    AlojamientoRepository alojamientoRepository;
    @Autowired
    FotoRepository fotoRepository;
    @Autowired
    ReservaRepository reservaRepository;

    public static void main(String[] args) {
        SpringApplication.run(MghHotelesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Reserva reserva = new Reserva();
        reserva.setCantidadDePersonas(3);
        reserva.setFechaIngreso(LocalDate.of(19,7,15));
        reserva.setFechaSalida(LocalDate.of(19,10,30));
        reserva.setComentarios("");
        reservaRepository.save(reserva);
        log.info("success saving reserva");

        Pago pago = new Pago();
        pago.setTipo("Efectivo");
        pago.setTotal(1500);
        pago.setReserva(reserva);
        pagoRepository.save(pago);
        log.info("success saving pago");

        Alojamiento alojamiento = new Alojamiento();
        alojamiento.setNombre("Hotel las Flores");
        alojamiento.setNumeroDeHabitaciones(30);
        alojamiento.setTipo("Hotel Turistico");
        alojamiento.setValoracion(5);
        alojamiento.setUbigeo(11);
        alojamiento.setCodAlojamiento("ALO01");
        alojamientoRepository.save(alojamiento);
        log.info("success saving alojamiento");

        Habitacion habitacion = new Habitacion();
        habitacion.setDescripcion("Habitación Ejecutiva");
        habitacion.setTipo(3);
        habitacion.setNumero("5");
        habitacion.setPrecio("1500 dolares");
        habitacion.setCodHabitacion("HAB01");
        habitacion.setAlojamiento(alojamiento);
        habitacion.setReserva(reserva);
        habitacionRepository.save(habitacion);
        log.info("success saving habitacion");

        Usuario usuario = new Usuario();
        usuario.setNombres("Jeremy");
        usuario.setApellidos("Tornero");
        usuario.setContrasena("1234");
        usuario.setEmail("jeremy@gmail.com");
        usuario.setCodUsuario("USU01");
        usuario.setReserva(reserva);
        usuarioRepository.save(usuario);
        log.info("success saving usuario");

    }
}
