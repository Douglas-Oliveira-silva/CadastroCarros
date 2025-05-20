package devDouglas.java.CadastroCarros.repository;

import devDouglas.java.CadastroCarros.model.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarroModel, Long> {

}
