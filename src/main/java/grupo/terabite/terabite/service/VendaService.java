package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.Venda;
import grupo.terabite.terabite.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listarVenda(){
        List<Venda> vendas = vendaRepository.findAllByOrderByDtVendaDesc();
        if(vendas.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return vendas;
    }

    public Venda buscarVendaPorId(Integer id){
        Optional<Venda> vendasOpt = vendaRepository.findById(id);
        if(vendasOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return vendasOpt.get();
    }

    public Venda criarVenda(Venda novaVenda){
        novaVenda.setId(null);
        return vendaRepository.save(novaVenda);
    }

    public Venda atualizarVenda(Integer id, Venda atualizarVenda){
        if(!vendaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        atualizarVenda.setId(null);
        return vendaRepository.save(atualizarVenda);
    }

    public void deletarVenda(Integer id){
        if(!vendaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        vendaRepository.deleteById(id);
    }
}
