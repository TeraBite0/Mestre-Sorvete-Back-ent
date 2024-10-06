package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.Venda;
import grupo.terabite.terabite.service.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService service;

    @Operation(summary = "Lista todas as vendas feitas", description = "Retorna uma lista de vendas")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida, vendas listadas"),
            @ApiResponse(responseCode = "204", description = "Operação bem-sucedida, sem vendas"),
            @ApiResponse(responseCode = "401", description = "Erro de requisição, Não autorizado")
    })
    public ResponseEntity<List<Venda>> listarVenda() {
        return ResponseEntity.ok(service.listarVenda());
    }

    @Operation(summary = "Busca uma venda pelo ID", description = "Retorna uma venda com base no seu ID")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida, venda listadas"),
            @ApiResponse(responseCode = "401", description = "Erro de requisição, Não autorizado"),
            @ApiResponse(responseCode = "404", description = "Nenhuma venda encontrada")
    })
    public ResponseEntity<Venda> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarVendaPorId(id));
    }

    @Operation(summary = "Registra uma venda", description = "Retorna a venda registrada")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação bem-sucedida, venda registrada"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição, Parâmetros inválidos"),
            @ApiResponse(responseCode = "401", description = "Erro de requisição, Não autorizado")
    })
    public ResponseEntity<Venda> criarVenda(@RequestBody Venda novoVenda) {
        return ResponseEntity.status(201).body(service.criarVenda(novoVenda));
    }

    @Operation(summary = "Atualiza uma venda pelo ID", description = "Retorna a venda atualizada")
    @PatchMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida, venda atualizada"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição, Parâmetros inválidos"),
            @ApiResponse(responseCode = "401", description = "Erro de requisição, Não autorizado"),
            @ApiResponse(responseCode = "404", description = "Nenhum produto encontrado")
    })
    public ResponseEntity<Venda> atualizarVenda(@PathVariable Integer id, @RequestBody Venda atualizarVenda) {
        return ResponseEntity.ok(service.atualizarVenda(id, atualizarVenda));
    }

    @Operation(summary = "Deleta uma venda pelo ID", description = "Retorna sucesso para a exclusão")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Operação bem-sucedida, venda deletada"),
            @ApiResponse(responseCode = "401", description = "Erro de requisição, Não autorizado"),
            @ApiResponse(responseCode = "404", description = "Nenhum produto encontrado"),
    })
    public ResponseEntity<Venda> deletarVenda(@PathVariable Integer id) {
        service.deletarVenda(id);
        return ResponseEntity.noContent().build();
    }
}
