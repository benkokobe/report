package bko.release.report.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/under_con")
public class UnderConController {
	@Value("${env.name}")
	private String env_name;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		model.addAttribute("env_name", env_name );

		return "under_con";
	}

}
