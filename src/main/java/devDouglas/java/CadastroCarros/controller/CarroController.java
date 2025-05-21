package devDouglas.java.CadastroCarros.controller;


import devDouglas.java.CadastroCarros.service.CarroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("/teste")
    public String boasVindas(){
        return "Rota de teste";
    }



}
