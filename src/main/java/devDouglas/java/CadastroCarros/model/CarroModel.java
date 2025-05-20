package devDouglas.java.CadastroCarros.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_carros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CarroModel {

   private Long id;
   private String modelo;
   private String marca;
   private int ano;
   private String cor;
   private String placa;

}



