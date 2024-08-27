package grupo.terabite.TeraBite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import grupo.terabite.TeraBite.Entity.Sorvete;
import grupo.terabite.TeraBite.Repository.SorveteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SorveteService {

    @Autowired
    private SorveteRepository sorveteRepository;

    public List<Sorvete> listarTodos() {
        return sorveteRepository.findAll();
    }

    public Sorvete buscarPorId( Integer id) {
        Optional<Sorvete> sorvete = sorveteRepository.findById(id);
        if(sorvete.isPresent()){
            return sorvete.get();
        }
        return null;
    }

    public Sorvete adicionarSorvete(Sorvete sorvete) {
        Sorvete novoSorvete = sorveteRepository.save(sorvete);
        return novoSorvete;
    }

    public Sorvete atualizarSorvete( Integer id,  Sorvete sorveteAtualizado) {
        if(sorveteRepository.existsById(id)){
            sorveteAtualizado.setId(id);
            return sorveteRepository.save(sorveteAtualizado);
        }
        return null;
//        throw new RuntimeException("Sorvete com ID " + id + " não encontrado.");
    }

    public void deletarSorvete( Integer id) {
        if (sorveteRepository.existsById(id)) {
            sorveteRepository.deleteById(id);
        }
    }
}
