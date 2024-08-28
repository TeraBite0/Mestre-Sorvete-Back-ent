package grupo.terabite.TeraBite.Controller;

import grupo.terabite.TeraBite.Entity.Notificacao;
import grupo.terabite.TeraBite.Entity.Produto;
import grupo.terabite.TeraBite.Service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {
    @Autowired
    private NotificacaoService service;

    @GetMapping
    public List<Notificacao> listarTodas(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Notificacao buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Notificacao adicionarNotificacao(@RequestBody Notificacao notificacao){return service.adicionarNotificacao(notificacao);}

    @PutMapping("/id")
    public Notificacao atualizarNotificacao(@PathVariable Integer id ,@RequestBody Notificacao notificacao){ return service.atualizarNotificacao(id, notificacao);}

    @DeleteMapping("/id")
    public String deletarNotificacao(@PathVariable Integer id){
        return service.deletarNotificacao(id) ? "Notificação deletada com sucesso": "Notificação não encontrada ou Falha ao deletar";
    }
}
