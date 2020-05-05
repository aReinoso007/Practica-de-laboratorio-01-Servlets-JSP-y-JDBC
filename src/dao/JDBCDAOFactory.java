package dao;

import ec.edu.usp.controlador.*;

public class JDBCDAOFactory extends DAOFactory{

	@Override
	public void createTables() {
		this.getUsuarioDAO().createTable();
		this.getTelefonoDAO().createTable();
	}
	
	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return  new JDBCUsuarioDAO();
	}

	@Override
	public TelefonoDAO getTelefonoDAO() {
		// TODO Auto-generated method stub
		return new JDBCTelefonoDAO();
	}


}