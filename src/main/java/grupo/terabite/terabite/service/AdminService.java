package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.Admin;
import grupo.terabite.terabite.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public Boolean autorizar(Admin adm){
        return !adminRepository.findByEmailAndSenha(adm.getEmail(), adm.getSenha()).isEmpty();
    }

    public ResponseEntity<Void> login(Admin adm){
        if(autorizar(adm)){
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    public ResponseEntity<Admin> mudarSenha(Admin adm, String senha){
        if(autorizar(adm)){
            adm.setId(1);
            adm.setSenha(senha);
            return ResponseEntity.status(200).body(adminRepository.save(adm));
        } else {
            return ResponseEntity.status(403).build();
        }
    }
}
