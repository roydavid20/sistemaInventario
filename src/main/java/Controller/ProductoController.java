package Controller;

import Models.Producto;
import Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin("*")
public class ProductoController {
    @Autowired
    private ProductoRepository repo;

    @GetMapping
    public List<Producto> listar() {
        return repo.findAll();
    }

    @GetMapping("/stock-minimo")
    public List<Producto> conStockMinimo() {
        return repo.findByStockActualLessThanEqual(0); // se puede cambiar dinámico
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return repo.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        Producto p = repo.findById(id).orElseThrow();
        // actualizar campos
        p.setNombre(producto.getNombre());
        p.setTipo(producto.getTipo());
        p.setStockActual(producto.getStockActual());
        p.setStockMinimo(producto.getStockMinimo());
        p.setCategoria(producto.getCategoria());
        return repo.save(p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

