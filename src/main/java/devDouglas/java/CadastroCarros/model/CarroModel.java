package devDouglas.java.CadastroCarros.model;


import jakarta.persistence.*;
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

   @Id
   @GeneratedValue
   @Column(name="id")
   private Long id;

   @Column(name="modelo")
   private String modelo;

   @Column(name="marca")
   private String marca;

   @Column(name="ano")
   private int ano;

   @Column(name="coe")
   private String cor;

   @Column(unique = true)
   private String placa;

}



