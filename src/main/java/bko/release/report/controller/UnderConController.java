package bko.release.report.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/under_con")
public class UnderConController {
	private static final Logger logger = LoggerFactory.getLogger(UnderConController.class);
	@Value("${env.name}")
	private String env_name;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		model.addAttribute("env_name", env_name );
		logger.info("under con controller");

		return "under_con";
	}

}
