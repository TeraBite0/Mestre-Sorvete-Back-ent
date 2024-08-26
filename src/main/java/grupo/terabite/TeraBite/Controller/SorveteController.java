package grupo.terabite.TeraBite.Controller;

import grupo.terabite.TeraBite.Entity.Sorvete;
import grupo.terabite.TeraBite.Repository.SorveteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sorvete")
public class SorveteController {

    @Autowired
    private SorveteRepository sorveteRepository;

    @GetMapping
    public List<Sorvete> listarTodos() {
        return sorveteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Sorvete buscarPorId(@PathVariable Integer id) {
        Optional<Sorvete> sorvete = sorveteRepository.findById(id);
        if(sorvete.isPresent()){
            return sorvete.get();
        }
        return null;
    }

    @PostMapping
    public Sorvete adicionarSorvete(@RequestBody Sorvete sorvete) {
        Sorvete novoSorvete = sorveteRepository.save(sorvete);
        return novoSorvete;
    }

    @PutMapping("/{id}")
    public Sorvete atualizarSorvete(@PathVariable Integer id, @RequestBody Sorvete sorveteAtualizado) {
        if(sorveteRepository.existsById(id)){
            sorveteAtualizado.setId(id);
            return sorveteRepository.save(sorveteAtualizado);
        }
        return null;
//        throw new RuntimeException("Sorvete com ID " + id + " não encontrado.");
    }

    @DeleteMapping("/{id}")
    public void deletarSorvete(@PathVariable Integer id) {
        if (sorveteRepository.existsById(id)) {
            sorveteRepository.deleteById(id);
        }
    }
}
