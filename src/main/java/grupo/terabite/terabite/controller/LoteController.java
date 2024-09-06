package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.Lote;
import grupo.terabite.terabite.service.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/lotes")
public class LoteController {

    @Autowired
    LoteService service;

    @GetMapping
    public ResponseEntity<List<Lote>> listarLote() {
        return service.listarLote();
    }

    @GetMapping("/ordenados")
    public ResponseEntity<List<Lote>> listarLoteOrdenado(@RequestParam(defaultValue = "dtVencimento") String ordenarPor) {
        ResponseEntity<List<Lote>> response = service.listarLote();
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            List<Lote> lotes = new ArrayList<>(response.getBody());
            insertionSort(lotes, getComparator(ordenarPor));
            return ResponseEntity.ok(lotes);
        }
        return response;
    }

    private void insertionSort(List<Lote> lotes, Comparator<Lote> comparator) {
        int n = lotes.size();
        for (int i = 1; i < n; ++i) {
            Lote key = lotes.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(lotes.get(j), key) > 0) {
                lotes.set(j + 1, lotes.get(j));
                j = j - 1;
            }
            lotes.set(j + 1, key);
        }
    }

    private Comparator<Lote> getComparator(String ordenarPor) {
        switch (ordenarPor.toLowerCase()) {
            case "dtvencimento":
                return Comparator.comparing(Lote::getDtVencimento);
            case "valorlote":
                return Comparator.comparing(Lote::getValorLote);
            case "dtpedido":
                return Comparator.comparing(Lote::getDtPedido);
            case "dtentrega":
                return Comparator.comparing(Lote::getDtEntrega);
            case "qtdprodutoscomprados":
                return Comparator.comparing(Lote::getQtdProdutoComprado);
            default:
                return Comparator.comparing(Lote::getDtVencimento);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Lote> adicionarLote(@RequestBody Lote novoLote) {
        return service.adicionarLote(novoLote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lote> atualizarLote(@PathVariable Integer id, @RequestBody Lote loteAtualizado) {
        return service.atualizarLote(id, loteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLote(@PathVariable Integer id) {
        return service.deletarLote(id);
    }
}