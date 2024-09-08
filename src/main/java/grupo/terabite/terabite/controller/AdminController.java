package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.Admin;
import grupo.terabite.terabite.repository.AdminRepository;
import grupo.terabite.terabite.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService service;

    // PROVISORIO
    @Autowired
    AdminRepository repository;
    private void cadastro(){
        if(repository.findAll().isEmpty()){
            repository.save(new Admin(1, "email@email.email", "senha"));
        }
    }
    //

    @PostMapping
    public ResponseEntity<Void> login(@RequestBody Admin adm){
        //PROVISORIO
        cadastro();

        return service.login(adm);
    }
}
