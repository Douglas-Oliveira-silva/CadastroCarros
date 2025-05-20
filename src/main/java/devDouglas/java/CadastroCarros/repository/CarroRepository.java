package devDouglas.java.CadastroCarros.repository;

import devDouglas.java.CadastroCarros.model.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CarroRepository extends JpaRepository<CarroModel, Long> {

}
