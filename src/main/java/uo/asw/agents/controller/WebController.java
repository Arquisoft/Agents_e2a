package uo.asw.agents.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import uo.asw.agents.util.Check;
import uo.asw.dbManagement.CitizenDAO;
import uo.asw.dbManagement.model.Agent;

@Controller
public class WebController {

	/**
	 * Devuelve la pagina de incio login
	 * 
	 * @param model
	 * @return pagina log HTML
	 */
	@RequestMapping(value = { "/", "/portal" }, method = RequestMethod.GET)
	public String showView(Model model) {
		return "log";
	}

	@Autowired
	private CitizenDAO cc;

	/**
	 * Recibe los datos de login del usuario, busca si exite ese usuario y en caso
	 * de exitir pasa a la siguiente página que muestra la informacion en caso
	 * contrario muestra la página de error
	 * 
	 * @param session
	 *            mantiene la sesion
	 * @param login
	 *            nombre del login
	 * @param password
	 *            contresena del usuario
	 * @param model
	 * @return view si exito, error si fracaso
	 */
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String showInfo(HttpSession session, @RequestParam String login, @RequestParam String password,
			@RequestParam String kind, Model model) {
		Agent c = null;
		if (login != null && password != null && kind != null) {
			c = cc.getAgent(login, password, kind);
			System.out.println(c);
			if (c != null) {
				session.setAttribute("agent", c);
				model.addAttribute("resultado", "Bienvenid@ " + c.getNombre());
				return "view";
			}
		}
		System.out.println(c);
		return "error";

	}

	/**
	 * Acceso a la página que modifica los datos del usuario
	 * 
	 * @return changeInfo html para modificar datos del usuario
	 */
	@RequestMapping(value = "/changeInfo", method = RequestMethod.GET)
	public String changeInfo() {
		return "changeInfo";
	}

	/**
	 * Cambia la contrasena de un usuario, siempre que e usuario este en sesion, la
	 * contrasena antigua se igual que la contrasena de parametro y la nueva
	 * contrasena no sea vacia
	 * 
	 * @param session
	 *            scope
	 * @param password
	 *            contrasena antigua
	 * @param newPassword
	 *            contrasena nueva
	 * @param model
	 * @return pagina siguiente
	 */
	@RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
	public String changePassword(HttpSession session, @RequestParam String password, @RequestParam String newPassword,
			Model model) {
		Agent c = (Agent) session.getAttribute("agent");
		System.out.println(c);
		System.out.println(password);
		System.out.println(newPassword);
		if (c != null) {
			System.out.print("Yo entro aqui");
			if (c.getContraseña().equals(password) && !newPassword.isEmpty()) {
				c.setContraseña(newPassword);
				cc.updateInfo(c);
				model.addAttribute("resultado", "Contrasena actualizada correctamente");
				return "view";
			}
			return "errorContrasena";
		}
		return "error";

	}

	/**
	 * Modifica el email del usuario en sesión, comprueba que el email es correcto
	 * segun un patron y muestra el resultado sobre el HTML view, o redirige a la
	 * pagina de error en caso de que no se encuentre el usuario en sesion
	 * 
	 * @param session
	 *            objeto session del usuario registrado
	 * @param email
	 *            nuevo email de usuario
	 * @param model
	 * @return view si el usuario esta registrado, error si el usuario no esta
	 *         registrado
	 */
	@RequestMapping(value = "/changeEmail", method = RequestMethod.POST)
	public String changeEmail(HttpSession session, @RequestParam String email, Model model) {
		Agent c = (Agent) session.getAttribute("agent");
		if (c != null) {
			if (!email.isEmpty() && Check.validateEmail(email)) {
				c.setEmail(email);
				cc.updateInfo(c);
				model.addAttribute("resultado", "Email actualizado correctemente a: " + email);
			} else {
				model.addAttribute("resultado", "El email no es valido, no actualizado a: " + email);
			}
			return "view";
		}
		return "error";
	}
}