package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.Admin;
import grupo.terabite.terabite.repository.AdminRepository;
import grupo.terabite.terabite.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Realiza o login de adm", description = "Valida credenciais de login e autoriza o usuário")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autorizado, Login realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Login não autorizado, Parâmetros inválidos"),
            @ApiResponse(responseCode = "401", description = "Login não autorizado, Credênciais inválidas")
    })
    public ResponseEntity<Admin> login(@RequestBody Admin adm){
        //PROVISORIO
        cadastro();
        service.login(adm);
        return ResponseEntity.noContent().build();
    }

    /*
    @Operation(summary = "Atualiza a senha da conta adm", description = "Atualiza a senha de adm e retorna caso seja autorizado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida, Senha atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de requisição, parâmetros inválidosht")
    })
     */
}