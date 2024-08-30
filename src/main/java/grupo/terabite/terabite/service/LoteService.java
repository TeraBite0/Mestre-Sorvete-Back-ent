package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.Lote;
import grupo.terabite.terabite.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteService {

    @Autowired
    LoteRepository loteRepository;

    public ResponseEntity<List<Lote>> listarLote(){
        List<Lote> lote = loteRepository.findAll();
        if(lote.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(lote);
    }

    public ResponseEntity<Lote> buscarPorId(Integer id) {
        Optional<Lote> notificacao = loteRepository.findById(id);
        if(notificacao.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(notificacao.orElse(null));
    }

    public ResponseEntity<Lote> adicionarLote(Lote novoLote){
        novoLote.setId(null);
        return ResponseEntity.status(201).body(loteRepository.save(novoLote));
    }

    public ResponseEntity<Lote> atualizarLote(Integer id, Lote lote){
        if(!loteRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        lote.setId(id);
        return ResponseEntity.status(200).body(loteRepository.save(lote));
    }

    public ResponseEntity<Void> deletarLote(Integer id){
        if(loteRepository.existsById(id)){
            loteRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
