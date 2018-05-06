package uo.asw.agents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import uo.asw.agents.service.ChangeInfoService;

@Controller
public class ChangeInfoController extends AbstractController {

	@Autowired
	private ChangeInfoService changeInfoService;

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
	public String changePassword(@RequestParam String password, @RequestParam String newPassword, Model model) {
		if (getAgente() != null
				&& getAgente().getPassword()
						.equals(changeInfoService.encripta(getAgente().getUsername(), password, getAgente().getKind()))
				&& !newPassword.isEmpty()) {
			getAgente().setPassword(
					changeInfoService.encripta(getAgente().getUsername(), newPassword, getAgente().getKind()));
			changeInfoService.updateAgent(getAgente());
			return "ok";
		}
		return "error";
	}
}
