package istia.st.elections;

import java.util.ArrayList;
import java.util.List;

public class ElectionsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	// champs locaux
	private int code;
	private List<String> erreurs;
	
	public ElectionsException(){
		super();
	}
	
	public ElectionsException(int code, Throwable e){
		// parent
		super(e);
		
		// local
		this.code = code;
		this.erreurs = getErreursForException(e);
	}
	
	public ElectionsException(int code, String message, Throwable e){
		// parent
		super(message, e);
		
		// local
		this.code = code;
		this.erreurs = getErreursForException(e);
	}
	
	public ElectionsException(int code, String message) {
		// parent
		super(message);
		
		// local
		this.code = code;
		List<String> erreurs = new ArrayList<>();
		erreurs.add(message);
		this.erreurs = erreurs;
	}
	
	public ElectionsException(int code, List<String> erreurs) {
		// parent
		super();
		
		// local
		this.code = code;
		this.erreurs = erreurs;
	}
	
	// liste des messages d'erreur d'une exception
	private List<String> getErreursForException(Throwable th) {
		// on récupère la liste des messages d'erreur de l'exception
		Throwable cause = th;
		List<String> erreurs = new ArrayList<>();
		
		while (cause != null) {
			// on récupère le message seulement s'il est !=null et non blanc
			String message = cause.getMessage();
			if (message != null) {
				message = message.trim();
				if (message.length() != 0) {
					erreurs.add(message);
				}
			}
			
			// cause suivante
			cause = cause.getCause();
		}
		
		return erreurs;
	}

	// TODO: getters et setters
	
}
