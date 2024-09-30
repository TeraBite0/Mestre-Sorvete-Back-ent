package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.Perda;
import grupo.terabite.terabite.entity.Tipo;
import grupo.terabite.terabite.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TipopService {

    @Autowired
    private TipoRepository repository;

    public List<Tipo> listarTipo(){
        List<Tipo> tipos = repository.findAll();
        if(tipos.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return tipos;
    }

    public Tipo criarTipo(Tipo novoTipo){
        return repository.save(novoTipo);
    }
}
