package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.Notificacao;
import grupo.terabite.terabite.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public ResponseEntity<List<Notificacao>> listarNotificacoes() {
        List<Notificacao> notificacoes = notificacaoRepository.findAll();
        if (notificacoes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(notificacoes);
    }

    public ResponseEntity<Notificacao> buscarPorId(Integer id) {
        Optional<Notificacao> notificacao = notificacaoRepository.findById(id);
        if (notificacao.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(notificacao.orElse(null));
    }

    public ResponseEntity<Notificacao> adicionarNotificacao(Notificacao novaNotificacao) {
        novaNotificacao.setId(null);
        return ResponseEntity.status(201).body(notificacaoRepository.save(novaNotificacao));
    }

    public ResponseEntity<Notificacao> atualizarNotificacao(Integer id, Notificacao notificacao) {
        if (!notificacaoRepository.existsById(id)) {
            return ResponseEntity.status(404).build();
        }
        notificacao.setId(id);
        return ResponseEntity.status(200).body(notificacaoRepository.save(notificacao));
    }

    public ResponseEntity<Void> deletarNotificacao(Integer id) {
        if (notificacaoRepository.existsById(id)) {
            notificacaoRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
