package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.Notificacao;
import grupo.terabite.terabite.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {
    @Autowired
    private NotificacaoService service;

    @GetMapping
    public ResponseEntity<List<Notificacao>> listarNotificacoes(){
        return service.listarNotificacoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Notificacao> adicionarNotificacao(@RequestBody Notificacao novaNotificacao){
        return service.adicionarNotificacao(novaNotificacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacao> atualizarNotificacao(@PathVariable Integer id ,@RequestBody Notificacao notificacaoAtualizada){
        return service.atualizarNotificacao(id, notificacaoAtualizada);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNotificacao(@PathVariable Integer id){
        return service.deletarNotificacao(id);
    }
}
