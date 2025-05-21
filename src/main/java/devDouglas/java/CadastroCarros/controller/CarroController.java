package devDouglas.java.CadastroCarros.controller;


import devDouglas.java.CadastroCarros.dto.CarroDTO;
import devDouglas.java.CadastroCarros.service.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o carro por Id", description = "Essa rota lista o carro pelo seu Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado")
    })
    public ResponseEntity<?> ListarCarrosPorId(@PathVariable long id){
        CarroDTO carro = carroService.ListarCarrosPorId(id);

        if (carro != null){
            return ResponseEntity.ok(carro);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro com o ID: " + id + " Não existe nos nossos registros");
        }
    }

    //Alterar Dados dos carro
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o carro pelo Id", description = "Essa rota altera um carro pelo seu Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro alterado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado, não foi possível alterar")
    })
    public ResponseEntity<?> alterarCarroPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter (description = "usuário manda os dados do carro para ser atualizado no corpo da requisição")
            @RequestBody CarroDTO carroAtualizado){

        CarroDTO alterarCarro = carroService.AtualizarCarro(id, carroAtualizado);

        if (alterarCarro != null){
            return ResponseEntity.ok(alterarCarro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro com o Id: " + id + " não existe em nossos registros");
        }

    }

}
