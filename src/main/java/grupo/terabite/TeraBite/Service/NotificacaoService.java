package grupo.terabite.TeraBite.Service;

import grupo.terabite.TeraBite.Entity.Notificacao;
import grupo.terabite.TeraBite.Repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;
    public List<Notificacao> listarTodos() {
        return notificacaoRepository.findAll();
    }

    public Notificacao buscarPorId( Integer id) {
        Optional<Notificacao> notificacao = notificacaoRepository.findById(id);
        return notificacao.orElse(null);
    }

    public Notificacao adicionarNotificacao(Notificacao produto) {
        Notificacao novoNotificacao = notificacaoRepository.save(produto);
        return novoNotificacao;
    }

    public Notificacao atualizarNotificacao(Integer id, Notificacao notificacao){
        if(notificacaoRepository.existsById(id)){
            return notificacaoRepository.save(notificacao);
        } else {return null;}
    }

    public Boolean deletarNotificacao(Integer id){
        if(notificacaoRepository.existsById(id)){
            notificacaoRepository.deleteById(id);
            return !notificacaoRepository.existsById(id);
        } else {return false;}
    }
}
