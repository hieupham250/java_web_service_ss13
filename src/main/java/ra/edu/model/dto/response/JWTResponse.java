package ra.edu.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JWTResponse {
    private String username;
    private String email;
    private Boolean status;
    private Boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;
    private String token;
}
