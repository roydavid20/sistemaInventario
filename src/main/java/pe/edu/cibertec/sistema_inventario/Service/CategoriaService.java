package pe.edu.cibertec.sistema_inventario.Service;

import pe.edu.cibertec.sistema_inventario.Models.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> listar();
    Categoria guardar(Categoria categoria);
    Categoria actualizar(Long id, Categoria categoria);
    void eliminar(Long id);
}

