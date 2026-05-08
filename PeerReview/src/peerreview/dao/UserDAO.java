package peerreview.dao;

import peerreview.model.User;

public interface UserDAO {

    boolean register(
            User user
    );

    User login(

            String email,

            String motDePasse
    );
}