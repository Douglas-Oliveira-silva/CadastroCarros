package devDouglas.java.CadastroCarros.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
   private Long id;

   @Column(name="modelo")
   @NotBlank(message = " O Modelo é obrigatório")
   private String modelo;

   @Column(name="marca")
   @NotBlank(message = "A Marca é obrigatória")
   private String marca;

   @Column(name="ano")
   @Min(value = 1886, message = "Ano inválido") // 1886 = ano do primeiro carro)
   private int ano;

   @Column(name="cor")
   @NotBlank(message = "A cor é obrigatória")
   private String cor;

   @Column(unique = true)
   @Pattern(regexp = "[A-Z]{3}-?\\d{4}", message = "Placa no formato inválido")
   private String placa;

   private String imagemUrl;

}



