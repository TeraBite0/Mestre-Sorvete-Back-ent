package grupo.terabite.TeraBite.Service;

import grupo.terabite.TeraBite.Entity.Lote;
import grupo.terabite.TeraBite.Repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteService {

    @Autowired
    LoteRepository loteRepository;

    public List<Lote> listarTodos(){return loteRepository.findAll();}
    public Lote buscarPorId(Integer id){
        Optional<Lote> lote = loteRepository.findById(id);
        return lote.orElse(null);
    }
    public Lote adicionarLote(Lote lote){return loteRepository.save(lote);}

    public Lote atualizarLote(Integer id, Lote lote){
        if(loteRepository.existsById(id)){
            lote.setId(id);
            return loteRepository.save(lote);
        } else{return null;}
    }

    public Boolean deletarLote(Integer id){
        if(loteRepository.existsById(id)){
            loteRepository.deleteById(id);
        }
        return !loteRepository.existsById(id);
    }
}
