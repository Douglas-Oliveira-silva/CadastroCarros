package devDouglas.java.CadastroCarros.service;

import devDouglas.java.CadastroCarros.dto.CarroDTO;
import devDouglas.java.CadastroCarros.mapper.CarroMapper;
import devDouglas.java.CadastroCarros.model.CarroModel;
import devDouglas.java.CadastroCarros.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    private final CarroRepository carroRepository;
    private CarroMapper carroMapper;

    public CarroService(CarroRepository carroRepository, CarroMapper carroMapper) {
        this.carroRepository = carroRepository;
        this.carroMapper = carroMapper;
    }

    // Criar novo carro
    public CarroDTO criarCarro(CarroDTO carroDTO){
        CarroModel carro = carroMapper.toModel(carroDTO);
        carro = carroRepository.save(carro);
        return carroMapper.toDTO(carro);
    }

    // Listar
    public List<CarroDTO> ListarCarros(){
        List<CarroModel> carros = carroRepository.findAll();
        return carros.stream()
                .map(carroMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Listar por ID
    public CarroDTO ListarCarrosPorId(long id){
        Optional<CarroModel> carroPorId = carroRepository.findById(id);
        return carroPorId.map(carroMapper::toDTO).orElse(null);
    }

    //Atualizar Carro
    public CarroDTO AtualizarCarro(Long id, CarroDTO carroDTO){
        Optional<CarroModel> carroExistente = carroRepository.findById(id);
        if (carroExistente.isPresent()){
            CarroModel carroAtualizado = carroMapper.toModel(carroDTO);
            carroAtualizado.setId(id);
            CarroModel carroSalvo = carroRepository.save(carroAtualizado);
            return carroMapper.toDTO(carroSalvo);
        }
        return null;
    }

    //deletar carro
    public void deletarCarroPorId(Long id){
        carroRepository.deleteById(id);
    }



}
