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
    public ResponseEntity<List<Notificacao>> listarNotificacoes() {
        return ResponseEntity.ok(service.listarNotificacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Notificacao> criarNotificacao(@RequestBody Notificacao novaNotificacao) {
        return ResponseEntity.ok(service.criarNotificacao(novaNotificacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacao> atualizarNotificacao(@PathVariable Integer id, @RequestBody Notificacao notificacaoAtualizada) {
        return ResponseEntity.ok(service.atualizarNotificacao(id, notificacaoAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Notificacao> deletarNotificacao(@PathVariable Integer id) {
        service.deletarNotificacao(id);
        return ResponseEntity.noContent().build();
    }
}
