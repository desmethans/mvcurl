package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Client;
import be.vdab.repositores.ClientRepository;

@Controller
@RequestMapping("/")
public class IndexController {
	private final ClientRepository clientRepository;
	@Autowired
	public IndexController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
		clientRepository.save(new Client("Joe"));
	}

	@RequestMapping
	public ModelAndView index() {
		return new ModelAndView("WEB-INF/JSP/index.jsp").addObject(clientRepository.findOne(1L));
	}
	
	@RequestMapping("{id}")
	public ModelAndView viaHyperlink(long id) {
		return new ModelAndView("WEB-INF/JSP/index.jsp").addObject(clientRepository.findOne(id));
	}
}
