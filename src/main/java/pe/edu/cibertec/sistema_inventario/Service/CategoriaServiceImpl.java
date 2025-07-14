package pe.edu.cibertec.sistema_inventario.Service;

import pe.edu.cibertec.sistema_inventario.Models.Categoria;
import pe.edu.cibertec.sistema_inventario.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public List<Categoria> listar() { return repo.findAll(); }
    public Categoria guardar(Categoria categoria) { return repo.save(categoria); }
    public Categoria actualizar(Long id, Categoria categoria) {
        Categoria existente = repo.findById(id).orElseThrow();
        existente.setNombre(categoria.getNombre());
        existente.setDescripcion(categoria.getDescripcion());
        return repo.save(existente);
    }
    public void eliminar(Long id) { repo.deleteById(id); }
}

