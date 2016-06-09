package Util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {

	public static void adicionarMensagemSucesso(String _msg)
	{
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, _msg, _msg);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		contexto.addMessage(null, msg);
	}
	
	public static void adicionarMensagemErro(String _msg)
	{
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, _msg, _msg);
		
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		contexto.addMessage(null, msg);
	}
}
