package com.springsecurityjwt.jwtutils;

import com.springsecurityjwt.model.JwtRequestModel;
import com.springsecurityjwt.model.JwtResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private JwtUserDetailService userDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenManager tokenManager;


    @PostMapping("/login")
    public ResponseEntity<?> createToken(@RequestBody JwtRequestModel requestModel) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestModel.getUsername(), requestModel.getPassword())
            );
        } catch (DisabledException e) {
            throw new Exception("User_Disable", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid_Credentials", e);
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(requestModel.getUsername());
        System.out.println(userDetails);
        final String jwtToken = tokenManager.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));

    }
}
