package Repository;

import Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByStockActualLessThanEqual(int stockMinimo);
    List<Producto> findByCategoriaId(Long categoriaId);
}