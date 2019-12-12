package com.dental.app.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException { //servlet controlador, gestiona peticiones del usuario
		
		SessionFlashMapManager sessionFlashMapManager = new SessionFlashMapManager();
		FlashMap flashmap = new FlashMap();
		flashmap.put("succes", "Bienvenid@ " + authentication.getName()); //apunta al tag success
		sessionFlashMapManager.saveOutputFlashMap(flashmap, request, response);

		if(authentication!= null) {
			logger.info("El usuario " + authentication.getName() + " ha iniciado sesión con éxito");
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	
	
	

}
