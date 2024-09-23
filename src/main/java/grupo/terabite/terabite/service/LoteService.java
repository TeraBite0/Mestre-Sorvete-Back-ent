package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.Lote;
import grupo.terabite.terabite.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LoteService {

    @Autowired
    LoteRepository loteRepository;

    public List<Lote> listarLote() {
        List<Lote> lotes = loteRepository.findAll();
        if (lotes.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return lotes;
    }

    public Lote buscarPorId(Integer id) {
        Optional<Lote> lotesOpt = loteRepository.findById(id);
        if (lotesOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return lotesOpt.get();
    }

    public Lote criarLote(Lote novoLote) {
        novoLote.setId(null);
        return loteRepository.save(novoLote);
    }

    public Lote atualizarLote(Integer id, Lote lote) {
        if (!loteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        lote.setId(id);
        return loteRepository.save(lote);
    }

    public void deletarLote(Integer id) {
        if (!loteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        loteRepository.deleteById(id);
    }
}
