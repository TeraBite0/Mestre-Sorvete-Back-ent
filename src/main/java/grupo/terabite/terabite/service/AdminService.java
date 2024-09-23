package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.Admin;
import grupo.terabite.terabite.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public Boolean autorizar(Admin adm){
        return !adminRepository.findByEmailAndSenha(adm.getEmail(), adm.getSenha()).isEmpty();
    }

    public Void login(Admin adm){
        if(autorizar(adm)){
            throw new ResponseStatusException(HttpStatusCode.valueOf(200));
        } else {
            throw new ResponseStatusException(HttpStatusCode.valueOf(401));
        }
    }

    public Admin mudarSenha(Admin adm, String senha){
        if(autorizar(adm)){
            adm.setId(1);
            adm.setSenha(senha);
            return adminRepository.save(adm);
        } else {
            throw new ResponseStatusException(HttpStatusCode.valueOf(403));
        }
    }
}