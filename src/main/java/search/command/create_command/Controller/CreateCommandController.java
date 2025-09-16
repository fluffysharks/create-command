package search.command.create_command.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import search.command.create_command.form.createCommandForm;

@Controller
public class CreateCommandController {

    @RequestMapping(value = "/createTwitterCommand", method = RequestMethod.GET)
    public String init(Model model, createCommandForm form) {
        model.addAttribute("form", form);
        return "createCommand";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String displayCommand(Model model, createCommandForm form) {
        StringBuilder command = new StringBuilder();
        command.append("form:" + form.getUserName());
        model.addAttribute("command", command);
        return "createCommand";
    }

}
