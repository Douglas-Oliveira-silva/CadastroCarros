package devDouglas.java.CadastroCarros.mapper;

import devDouglas.java.CadastroCarros.dto.CarroDTO;
import devDouglas.java.CadastroCarros.model.CarroModel;
import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

    public CarroModel toModel(CarroDTO dto){

        CarroModel carroModel = new CarroModel();

        carroModel.setId(dto.getId());
        carroModel.setModelo(dto.getModelo());
        carroModel.setMarca(dto.getMarca());
        carroModel.setAno(dto.getAno());
        carroModel.setCor(dto.getCor());
        carroModel.setPlaca(dto.getPlaca());

        return carroModel;
    }

    public CarroDTO toDTO(CarroModel model){
        CarroDTO carroDTO = new CarroDTO();

        carroDTO.setId(model.getId());
        carroDTO.setModelo(model.getModelo());
        carroDTO.setMarca(model.getMarca());
        carroDTO.setAno(model.getAno());
        carroDTO.setCor(model.getCor());
        carroDTO.setPlaca(model.getPlaca());

        return carroDTO;

    }


}
