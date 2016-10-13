package com.nsis.service;

import com.nsis.bo.LoginBo;
import com.nsis.dao.LoginDao;
import com.nsis.dto.LoginDTO;
import com.nsis.exception.LoginException;

public class LoginService {
      private LoginDao unDao = new LoginDao();
 
      public LoginDTO checkUserPassword(String identifiant, String motDePasse) throws LoginException {
            LoginBo login = unDao.findByLogin(identifiant);

            // Si le login est trouvé, on vérifie le mot de passe associé
            if (login != null)
                  if (login.getMotDePasse().equals(motDePasse))
                        return createDTO(login);
                  else
                        throw new LoginException("Mot de passe erroné");
            else
                  throw new LoginException("Identifiant inconnu");
      }

	private LoginDTO createDTO(LoginBo login) {
		return new LoginDTO(login);
	}
      
      
       
}