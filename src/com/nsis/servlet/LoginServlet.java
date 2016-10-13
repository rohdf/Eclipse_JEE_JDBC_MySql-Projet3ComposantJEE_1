package com.nsis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsis.bean.ExceptionBean;
import com.nsis.bean.loginBean;
import com.nsis.dao.LoginDao;
import com.nsis.dto.LoginDTO;
import com.nsis.exception.LoginException;
import com.nsis.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // on récupère les valeurs des deux champs du formulaire de la page de login
	    String login = request.getParameter("identifiant");
	    String password = request.getParameter("motdepasse");
	   
	   // on vérifie qu'ils ont bien été remplis
	   if(!login.isEmpty() && !password.isEmpty()) {
		   		LoginService service = new LoginService();
		   		LoginDTO dto = null;
		   		try {
					dto = service.checkUserPassword(login, password);
				} catch (LoginException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.getSession().setAttribute("exception", createExceptionBean(e.getLocalizedMessage()));
				}
		   		  
	       
	             // ... et on le stocke dans la session courante.
		   		if(dto != null)
	             request.getSession().setAttribute("user", createLoginBean(dto));
	             
	             RequestDispatcher rd=request.getRequestDispatcher("Bienvenue.jsp");    
	             rd.forward(request,response);    
  
	        
	    
	   } else {
	    // Si l'utilisateur n'a pas rempli les deux champs du formulaire, il est renvoyé sur la page index.html
	    response.sendRedirect("index.html");
	   }
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // on récupère les valeurs des deux champs du formulaire de la page de login
		  String login = request.getParameter("identifiant");
		  String password = request.getParameter("motdepasse");
		  
		  // on vérifie qu'ils ont bien été remplis
		  if(!login.isEmpty() && !password.isEmpty()) {

		   // on créé un objet User pour conserver les informations de l'utilisateur...
		   loginBean currentUser = new loginBean();
		   currentUser.setLogin(login);
		   currentUser.setPassword(password);
		   
		   //... et on le stocke dans la session courante.
		   request.getSession().setAttribute("user", currentUser);
		   
		   // Enfin, on redirige les données vers la page bienvenue.jsp
		   request.getRequestDispatcher("Bienvenue.jsp").forward (request, response);
		   
		  } else {
		   // Si l'utilisateur n'a pas rempli les deux champs du formulaire, il est renvoyé sur la page index.html
		   response.sendRedirect("index.html");
		  }
	}
	
	public loginBean createLoginBean(LoginDTO loginDTO){
		loginBean bean = new loginBean();
		bean.setLogin(loginDTO.getLogin());
		bean.setPassword(loginDTO.getPassword());
		return bean;
	}
	private ExceptionBean createExceptionBean(String message) {
		ExceptionBean bean = new ExceptionBean();
		bean.setMessage(message);
		return bean;
	}

}
