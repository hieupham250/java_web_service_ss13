package ra.edu.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ra.edu.model.dto.request.UserLogin;
import ra.edu.model.dto.request.UserRegister;
import ra.edu.model.dto.response.JWTResponse;
import ra.edu.model.entity.Role;
import ra.edu.model.entity.User;
import ra.edu.repository.RoleRepository;
import ra.edu.repository.UserRepository;
import ra.edu.security.jwt.JWTProvider;
import ra.edu.security.principal.CustomUserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JWTProvider jwtProvider;
    @Autowired
    private AuthenticationManager authenticationManager;

    public User registerUser(UserRegister userRegister) {
        User user = User.builder()
                .username(userRegister.getUsername())
                .password(passwordEncoder.encode(userRegister.getPassword()))
                .email(userRegister.getEmail())
                .status(true)
                .enabled(true)
                .roles(mapRoleStringToRole(userRegister.getRoles()))
                .build();
        return userRepository.save(user);
    }

    public JWTResponse login(UserLogin userLogin) {
        Authentication authentication = null;
        try{
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(),userLogin.getPassword()));
        }catch(AuthenticationException e){
            log.error("Sai username hoac password!");
        }

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String token = jwtProvider.generateToken(userDetails.getUsername());

        return JWTResponse.builder()
                .username(userDetails.getUsername())
                .enabled(userDetails.isEnabled())
                .email(userDetails.getEmail())
                .authorities(userDetails.getAuthorities())
                .token(token)
                .build();
    }

    private List<Role> mapRoleStringToRole(List<String> roles) {
        List<Role> roleList = new ArrayList<>();

        if(roles!=null && !roles.isEmpty()){
            roles.forEach(role->{
                switch (role){
                    case "ROLE_ADMIN":
                        roleList.add(roleRepository.findByRoleName(role).orElseThrow(()-> new NoSuchElementException("Khong ton tai role_admin")));
                        break;
                    case "ROLE_USER":
                        roleList.add(roleRepository.findByRoleName(role).orElseThrow(()-> new NoSuchElementException("Khong ton tai role_user")));
                        break;
                    default:
                        roleList.add(roleRepository.findByRoleName("ROLE_USER").orElseThrow(()-> new NoSuchElementException("Khong ton tai user")));
                }
            });
        }else{
            roleList.add(roleRepository.findByRoleName("ROLE_USER").orElseThrow(()-> new NoSuchElementException("Khong ton tai role_user")));
        }
        return roleList;
    }
}