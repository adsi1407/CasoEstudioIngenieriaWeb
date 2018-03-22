package co.edu.udea.iw.DAO.IMPL;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.edu.udea.iw.DAO.CiudadDAO;
import co.edu.udea.iw.DAO.UsuarioDAO;
import co.edu.udea.iw.DTO.Ciudad;
import co.edu.udea.iw.DTO.Rol;
import co.edu.udea.iw.DTO.Usuario;
import co.edu.udea.iw.EXCEPTION.ClassException;

class UsuarioDAOImplTest {

	@Test
	void obtenerUsuarioTest() {
		UsuarioDAO usuario=null;
		List<Usuario> listaUsuarios=null;
			
		try {
			usuario= new UsuarioDAOImpl();
			listaUsuarios=usuario.obtener();
			assertTrue(listaUsuarios.size()>0);
			
			for (int i = 0; i < listaUsuarios.size(); i++) {
				String nombre = listaUsuarios.get(i).getNombres();
				Rol rol = listaUsuarios.get(i).getRol();
				System.out.println(nombre + rol.getNombre());
			}
			
			
		}catch(ClassException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	void guardarUsuarioTest() {
		UsuarioDAO usuarioDao=null;
		Usuario usuario=new Usuario();
		Rol rol = new Rol();
		
		try {
			rol.setCodigo("ADM");
			rol.setNombre("Administrador");
			usuario.setNombres("David");
			usuario.setApellidos("Santacoloma");
			usuario.setLogin("david");
			usuario.setContrasena("123");
			usuario.setRol(rol);
			usuarioDao = new UsuarioDAOImpl();
			usuarioDao.insertar(usuario);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
