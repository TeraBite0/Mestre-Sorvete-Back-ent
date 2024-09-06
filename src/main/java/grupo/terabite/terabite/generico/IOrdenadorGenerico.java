package grupo.terabite.terabite.generico;

import java.util.List;
import java.util.Optional;

public interface IOrdenadorGenerico<T extends Comparable<T>> {

    Optional<List<T>> ordenarMaximo(List<T> items);
}
