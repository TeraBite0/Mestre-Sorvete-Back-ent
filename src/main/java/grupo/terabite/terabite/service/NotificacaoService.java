package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.Notificacao;
import grupo.terabite.terabite.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public List<Notificacao> listarNotificacoes() {
        List<Notificacao> notificacoes = notificacaoRepository.findAll();
        if (notificacoes.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return notificacoes;
    }

    public Notificacao buscarPorId(Integer id) {
        Optional<Notificacao> notificacoesOpt = notificacaoRepository.findById(id);
        if (notificacoesOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return notificacoesOpt.get();
    }

    public Notificacao criarNotificacao(Notificacao novaNotificacao) {
        novaNotificacao.setId(null);
        return notificacaoRepository.save(novaNotificacao);
    }

    public Notificacao atualizarNotificacao(Integer id, Notificacao notificacao) {
        if (!notificacaoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        notificacao.setId(id);
        return notificacaoRepository.save(notificacao);
    }

    public void deletarNotificacao(Integer id) {
        if (!notificacaoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        notificacaoRepository.deleteById(id);
    }
}
