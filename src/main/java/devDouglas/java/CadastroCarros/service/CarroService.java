package devDouglas.java.CadastroCarros.service;

import devDouglas.java.CadastroCarros.mapper.CarroMapper;
import devDouglas.java.CadastroCarros.repository.CarroRepository;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    private final CarroRepository carroRepository;
    private CarroMapper carroMapper;

    public CarroService(CarroRepository carroRepository, CarroMapper carroMapper) {
        this.carroRepository = carroRepository;
        this.carroMapper = carroMapper;
    }




}
