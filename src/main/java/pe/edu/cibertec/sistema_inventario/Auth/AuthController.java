package pe.edu.cibertec.sistema_inventario.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping(value = "login" )
    public String login (){
        return "login";
    }

    @PostMapping(value = "register" )
    public String register (){
        return "register";
    }


}
