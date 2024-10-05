package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.dto.create.PerdaCreateDTO;
import grupo.terabite.terabite.dto.create.ProdutoCreateDTO;
import grupo.terabite.terabite.dto.mapper.PerdaMapper;
import grupo.terabite.terabite.dto.mapper.ProdutoMapper;
import grupo.terabite.terabite.dto.response.PerdaResponseDTO;
import grupo.terabite.terabite.entity.Perda;
import grupo.terabite.terabite.service.PerdaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perdas")
public class PerdaController {

    @Autowired
    private PerdaService perdaService;

    @GetMapping
    public ResponseEntity<List<PerdaResponseDTO>> listarPerda() {
        List<Perda> perdas = perdaService.listarPerda();
        if(perdas.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(perdas.stream().map(PerdaMapper::toResponsePerda).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerdaResponseDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(PerdaMapper.toResponsePerda(perdaService.buscarPerdaPorId(id)));
    }

    @PostMapping
    public ResponseEntity<PerdaResponseDTO> criarPerda(
            @RequestBody @Valid PerdaCreateDTO perdaCreateDTO) {
            return ResponseEntity.created(null).body(
                    PerdaMapper.toResponsePerda(
                            perdaService.criarPerda(
                                    PerdaMapper.toCrearPerda(perdaCreateDTO),
                                    perdaCreateDTO.getNome())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perda> atualizarPerda(@PathVariable Integer id, @RequestBody Perda atualizarPerda) {
        return ResponseEntity.ok(perdaService.atualizarPerda(id, atualizarPerda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Perda> deletarPerda(@PathVariable Integer id) {
        perdaService.deletarPerda(id);
        return ResponseEntity.noContent().build();
    }
}
