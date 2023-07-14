package br.com.assados.CTR;

import br.com.assados.dao.BackupDAO;

/**
 * Classe para conecatar ao backupDAO
 */
public class BackupCTR {
	BackupDAO backupDAO = new BackupDAO();

	/**
	 * Função para realizar backup no backupDAO
	 */
	public void confirmaBackup() {
		try {
			this.backupDAO.confirmaBackup();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	/**
	 * Função para restaurar backup no backupDAO
	 */
	public void confirmaRestaurarBackup() {
		try {
			this.backupDAO.confirmaRestaurarBackup();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

}
