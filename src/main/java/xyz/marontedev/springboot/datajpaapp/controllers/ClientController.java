package xyz.marontedev.springboot.datajpaapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import xyz.marontedev.springboot.datajpaapp.models.entity.Client;
import xyz.marontedev.springboot.datajpaapp.models.service.IServiceClient;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("client")
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private IServiceClient clientService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("title", "Client list");
        model.addAttribute("customers",clientService.findAll());
        return "list";
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET )
    public String create(Map<String, Object> model){
        Client client = new Client();
        model.put("client",client);
        model.put("title","Client form");
        return "form";
    }
    @PostMapping("/create")
    public String save(@Valid Client client, BindingResult result, Model model, SessionStatus status){
        if(result.hasErrors()) {
            //se pasa client a la vista por autómatico como si se añadiera la anotación
            // modelatributte con el mismo nombre de la clase
            model.addAttribute("title","Client form");
            return "form";
        }
        clientService.save(client);
        status.setComplete();
        return "redirect:/client/list";
    }
    @GetMapping("/form/{id}")
    public String edit(@PathVariable(value = "id") Long id, Map <String,Object> model){
        Client client;
        if (id > 0){
            client = clientService.findOne(id);
        } else {
            return "redirect:/client/list";
        }
        model.put("client", client);
        model.put("title","Edit client " + client.getName());
        return "form";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        if(id > 0){
            clientService.delete(id);
        }
        return "redirect:/client/list";
    }
}
