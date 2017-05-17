package service;


import daos.TransaccionesManager;
import daos.UsuarioDAO;
import domain.Usuario;
import exceptions.DAOException;
import exceptions.ServiceException;
/**
 * Servicio para usuarios de la escuela de informatica
 * @author Pc
 *
 */
public class ServiceUsuario {
	
	/**
	 * Recupera un usuario de la base de datos solo se necesita su email
	 * @param usuario usuario con el email
	 * @return usuario completo
	 * @throws ServiceException
	 */
	public Usuario recuperarUsuario(Usuario usuario) throws ServiceException{
		TransaccionesManager trans = null;

		try {
			trans = new TransaccionesManager();
			UsuarioDAO usuarioDAO = trans.getUsuarioDAO();
			usuario = usuarioDAO.recuperarUsuario(usuario);


			trans.closeCommit();
		} catch (DAOException e) {
			try{
				trans.closeRollback();
			}catch (DAOException e1){
				throw new ServiceException(e.getMessage(),e1);//Error interno
			}

			if(e.getCause()==null){
				throw new ServiceException(e.getMessage());//Error Lógico
			}else{

				throw new ServiceException(e.getMessage(),e);//Error interno
			}

		}
		return usuario;
	}
	
	/**
	 * Inserta un usario validado a la base de datos
	 * @param usuario
	 * @throws ServiceException
	 */
	public void insertarUsuario(Usuario usuario) throws ServiceException{
		TransaccionesManager trans = null;
		try {

			trans = new TransaccionesManager();
			UsuarioDAO usuarioDAO = trans.getUsuarioDAO();
			usuarioDAO.insertarUsuario(usuario);


			trans.closeCommit();
		} catch (DAOException e) {
			try{
				trans.closeRollback();
			}catch (DAOException e1){
				throw new ServiceException(e.getMessage(),e1);//Error interno
			}

			if(e.getCause()==null){
				throw new ServiceException(e.getMessage());//Error Lógico
			}else{

				throw new ServiceException(e.getMessage(),e);//Error interno
			}

		}
	}
	

}
