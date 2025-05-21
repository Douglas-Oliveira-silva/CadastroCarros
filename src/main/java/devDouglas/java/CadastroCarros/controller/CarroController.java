package devDouglas.java.CadastroCarros.controller;


import devDouglas.java.CadastroCarros.dto.CarroDTO;
import devDouglas.java.CadastroCarros.service.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("/teste")
    @Operation(summary = "Mensagem de teste", description = "Este rota de teste autentica o endpoint para quem acessa ela")
    public String boasVindas(){
        return "Rota de teste";
    }

    // CRIAR
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo carro", description = "Essa rota cria um novo carro e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carro criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do carro"),
            @ApiResponse(responseCode = "500", description = "Erro na criação do carro, alguma chave foi violada")
    })
    public ResponseEntity<String> criarCarro(@RequestBody @Valid CarroDTO carro){
        CarroDTO novoCarro = carroService.criarCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Carro criado com sucesso " + novoCarro.getModelo() +  " (Id:) " + novoCarro.getId());
    }

    // LISTAR
    @GetMapping("/listar")
    @Operation(summary = "Listar carros", description = "Essa rota lista os carro que estão no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carro Listado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro para listar carros")
    })
    public ResponseEntity<List<CarroDTO>> listarCarros(){
        List<CarroDTO> carros = carroService.ListarCarros();
        return ResponseEntity.ok(carros);
    }

    // LISTAR POR ID






}
