package devDouglas.java.CadastroCarros.controller;

import devDouglas.java.CadastroCarros.dto.CarroDTO;
import devDouglas.java.CadastroCarros.service.CarroService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


public class CarroWebController {

    private final CarroService carroService;

    public CarroWebController(CarroService carroService) {
        this.carroService = carroService;
    }

    // 1. listar carros

    @GetMapping
    public String listarCarros(Model model) {
        model.addAttribute("carros", carroService.ListarCarros());
        return "listar"; // listar.html
    }

    // 2. Mostrar formulário de criação

    @GetMapping("/criar")
    public String mostrarFormularioCriar(Model model){
        model.addAttribute("carro", new CarroDTO());
        return "criar"; //criar.html//
    }

    // 3. Processar formulário de criação
    @PostMapping("/criar")
    public String criarCarro(@ModelAttribute("carro") CarroDTO carroDTO) {
        return "redirect:/web/carros";
    }

    // 4. Mostrar formulário de edição
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model){
        CarroDTO carro = carroService.ListarCarrosPorId(id);
        model.addAttribute("carro", carro);
        return "editar"; //editar.html
    }





}
