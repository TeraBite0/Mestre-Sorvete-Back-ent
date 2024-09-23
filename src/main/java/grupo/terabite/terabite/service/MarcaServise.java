package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.Marca;
import grupo.terabite.terabite.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServise {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listarMarca(){
        List<Marca> marcas = marcaRepository.findAll();
        if(marcas.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return marcas;
    }

    public Marca buscarMarcaPorId(Integer id){
        Optional<Marca> marcasOpt = marcaRepository.findById(id);
        if(marcasOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return marcasOpt.get();
    }

    public Marca criarMarca(Marca novaMarca){
        novaMarca.setId(null);
        return marcaRepository.save(novaMarca);
    }

    public Marca atualizarMarca(Integer id, Marca atualizarMarca){
        if(!marcaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        atualizarMarca.setId(null);
        return marcaRepository.save(atualizarMarca);
    }

    public void deletarMarca(Integer id){
        if(!marcaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        marcaRepository.deleteById(id);
    }
}
