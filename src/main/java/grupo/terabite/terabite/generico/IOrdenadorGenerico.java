package grupo.terabite.terabite.generico;

import java.util.List;

public interface IOrdenadorGenerico<T extends Comparable<T>> {

    List<T> ordenarMaximo();
}
