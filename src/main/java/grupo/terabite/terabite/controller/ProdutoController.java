package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.dto.create.ProdutoCreateDTO;
import grupo.terabite.terabite.entity.Produto;
import grupo.terabite.terabite.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    //@GetMapping
    //@Operation(summary = "Lista todos produtos", description = "Retorna uma lista com todos os produtos")
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(service.listarProduto());
    }
    @Operation(summary = "Busca um produto pelo ID", description = "Retorna um produto com base no seu ID")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida, produto retornado"),
            @ApiResponse(responseCode = "404", description = "Nenhum produto encontrado"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição, parâmetros inválidos")
    })
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Busca produtos, com um filtro opcional", description = "Retorna todos os produtos, ou retorna produtos conforme nome e/ou marca passados. Parâmetros: nomeProduto (Opcional), nomeMarca (Opcional)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida, produtos retornados"),
            @ApiResponse(responseCode = "204", description = "Operação bem-sucedida, sem produtos"),
            @ApiResponse(responseCode = "404", description = "Nenhum produto encontrado"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição, parâmetros inválidos")
    })
    public ResponseEntity<List<Produto>> listarComFiltro( @RequestParam(required = false) String nomeProduto,
                                                          @RequestParam(required = false) String nomeMarca){
        if(nomeMarca == null && nomeProduto == null){
            return listarTodos();
        }

        return null;
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação bem-sucedida, produto criado"),
            @ApiResponse(responseCode = "404", description = "Nenhum produto encontrado"),
    })
    @Operation(summary = "Cria um produto", description = "Retorna o produto criado caso sucesso na criação")
    public ResponseEntity<ProdutoCreateDTO> criarProduto(@RequestBody ProdutoCreateDTO produtoCreateDTO) {
        return ResponseEntity.status(201).body(service.criarProduto(produtoCreateDTO));
    }

    @PatchMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação bem-sucedida, produto criado"),
            @ApiResponse(responseCode = "404", description = "Nenhum produto encontrado"),
            @ApiResponse(responseCode = "409", description = "Produto duplicado"),
    })
    @Operation(summary = "Atualiza um produto", description = "Retorna o produto atualizado caso sucesso na criação")
    public ResponseEntity<ProdutoCreateDTO> atualizarProduto(@RequestBody ProdutoCreateDTO produtoCreateDTO) {
        return ResponseEntity.ok(service.criarProduto(produtoCreateDTO));
    }

}
