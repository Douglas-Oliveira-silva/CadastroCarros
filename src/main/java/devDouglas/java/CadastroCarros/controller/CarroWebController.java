package devDouglas.java.CadastroCarros.controller;

import devDouglas.java.CadastroCarros.dto.CarroDTO;
import devDouglas.java.CadastroCarros.service.CarroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/carros")
public class CarroWebController {

    private final CarroService carroService;

    public CarroWebController(CarroService carroService) {
        this.carroService = carroService;
    }

    // 1. Listar carros
    @GetMapping
    public String listarCarros(Model model) {
        model.addAttribute("carros", carroService.ListarCarros());
        return "listar"; // listar.html
    }

    // 2. Mostrar formulário de criação
    @GetMapping("/criar")
    public String mostrarFormularioCriar(Model model){
        model.addAttribute("carro", new CarroDTO());
        return "formulario"; // reutilizando formulario.html
    }

    // 3. Processar formulário de criação
    @PostMapping("/criar")
    public String criarCarro(@ModelAttribute("carro") CarroDTO carroDTO) {
        carroService.criarCarro(carroDTO);  // Assumindo método de serviço para criar
        return "redirect:/web/carros";
    }

    // 4. Mostrar formulário de edição
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model){
        CarroDTO carro = carroService.ListarCarrosPorId(id);
        model.addAttribute("carro", carro);
        return "formulario"; // reutilizando formulario.html
    }

    // 5. Processar formulário de edição
    @PostMapping("/editar/{id}")
    public String editarCarro(@PathVariable Long id, @ModelAttribute("carro") CarroDTO carroDTO){
        carroService.AtualizarCarro(id, carroDTO);
        return "redirect:/web/carros";
    }

    // 6. Deletar carro
    @GetMapping("/deletar/{id}")
    public String deletarCarro(@PathVariable Long id){
        carroService.deletarCarroPorId(id);
        return "redirect:/web/carros";
    }

    // 7. Detalhar carro
    @GetMapping("/detalhe/{id}")
    public String mostrarDetalheCarro(@PathVariable Long id, Model model) {
        CarroDTO carro = carroService.ListarCarrosPorId(id);
        model.addAttribute("carro", carro);
        return "detalhe";
    }
}
