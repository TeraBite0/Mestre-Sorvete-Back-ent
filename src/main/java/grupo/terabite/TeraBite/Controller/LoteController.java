package grupo.terabite.TeraBite.Controller;

import grupo.terabite.TeraBite.Entity.Lote;
import grupo.terabite.TeraBite.Service.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lote")
public class LoteController {

    @Autowired
    LoteService service;

    @GetMapping
    public List<Lote> listarTodos(){return service.listarTodos();}

    @GetMapping("/id")
    public Lote buscarPorId(@PathVariable Integer id){return service.buscarPorId(id);}

    @PostMapping
    public Lote adicionarLote(@RequestBody Lote lote){return service.adicionarLote(lote);}

    @PutMapping("/id")
    public Lote atualizarLote(@PathVariable Integer id, @RequestBody Lote lote){return service.atualizarLote(id, lote);}

    @DeleteMapping("/id")
    public String deletarLote(@PathVariable Integer id){ return service.deletarLote(id) ? "Lote deletado com sucesso": "Lote não encontrado / Erro ao deletar lote";}
}
