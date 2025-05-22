package devDouglas.java.CadastroCarros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

    private Long id;
    private String modelo;
    private String marca;
    private int ano;
    private String cor;
    private String placa;
    private String imagemUrl;

}
