package com.example.demo.service;

import com.example.demo.entity.Authentication;
import com.example.demo.entity.Users;
import com.example.demo.models.ResponseObject;
import com.example.demo.models.User;
import com.example.demo.models.dto.AuthDTO;
import com.example.demo.repository.AuthenticationRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.utilities.EncryptionHelper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private UsersRepository usersRepository;

    public ResponseObject addUser(Authentication authentication) throws Exception {
        authentication.setPassword(EncryptionHelper.encrypt(authentication.getPassword()));
        try {
            authenticationRepository.save(authentication);
        } catch (Exception e) {
            return new ResponseObject("duplicate", "username already exists", "null");
        }

        return new ResponseObject("success", "user added successfully", "null");
    }

    public ResponseObject authenticate(User user) throws Exception {
        ResponseObject response = new ResponseObject();

        Authentication recAuthObject = authenticationRepository.findByUsername(user.getUsername());
        if(recAuthObject==null) {
            response.setStatus("failure");
            response.setMessage("user not found");
            response.setToken("null");
        } else {
            String decPassword = EncryptionHelper.decrypt(recAuthObject.getPassword());
            if(decPassword.equals(user.getPassword())) {
                response.setStatus("success");
                response.setMessage("user login successful");
                response.setToken("Bearer abcd-sample-token-xyz");
            } else {
                response.setStatus("failure");
                response.setMessage("password not matching");
                response.setToken("null");
            }
        }
        return response;
    }

    public ResponseObject update(AuthDTO authDTO) {

        ResponseObject response = new ResponseObject();
        Users user = null;

        Authentication recAuthObject = authenticationRepository.findByUsername(authDTO.getUsername());
        if(recAuthObject==null) {
            response.setStatus("failure");
            response.setMessage("user not found");
            response.setToken("null");
        } else {
            Optional<Users> usersOptional = usersRepository.findById(authDTO.getUserId());
            if(usersOptional.isPresent()) {
                user = usersOptional.get();
                recAuthObject.setUser(user);
                authenticationRepository.save(recAuthObject);

                response.setStatus("success");
                response.setMessage("user update successful");
                response.setToken("null");
            } else {
                response.setStatus("failure");
                response.setMessage("user not found");
                response.setToken("null");
            }
        }

        return response;
    }
}
