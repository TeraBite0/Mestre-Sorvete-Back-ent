package grupo.terabite.TeraBite.Controller;

import grupo.terabite.TeraBite.Entity.Sorvete;
import grupo.terabite.TeraBite.Repository.SorveteRepository;
import grupo.terabite.TeraBite.Service.SorveteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sorvete")
public class SorveteController {

    @Autowired
    private SorveteService service;

    @GetMapping
    public List<Sorvete> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Sorvete buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Sorvete adicionarSorvete(@RequestBody Sorvete sorvete) {
        return service.adicionarSorvete(sorvete);
    }


    @PutMapping("/{id}")
    public Sorvete atualizarSorvete(@PathVariable Integer id, @RequestBody Sorvete sorveteAtualizado) {
        return service.atualizarSorvete(id, sorveteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarSorvete(@PathVariable Integer id) {
        service.deletarSorvete(id);
    }
}
