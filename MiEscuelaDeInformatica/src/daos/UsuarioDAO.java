package daos;

import java.sql.Connection;

public class UsuarioDAO {
	private static final String DB_ERR = "Error de la base de datos";

	public static final int ORACLE_DUPLICATE_PK = 1;
	private static final int ORACLE_DELETE_FK = 2292;
	private static final int ORACLE_FALLO_FK = 2291;
	
	private Connection con;

	public UsuarioDAO(Connection con) {
		this.con = con;
	}

}
