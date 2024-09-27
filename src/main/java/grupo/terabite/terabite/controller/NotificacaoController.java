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

    @PostMapping
    public ResponseEntity<Notificacao> criarNotificacao(@RequestBody Notificacao novaNotificacao) {
        return ResponseEntity.ok(service.criarNotificacao(novaNotificacao));
    }
}
