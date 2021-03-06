package pe.isil.mghplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pago implements Serializable {
    private Integer idPago;
    private String tipo;
    private Integer total;

    @Override
    public String toString(){
        return "Id: "+idPago;
    }
}
