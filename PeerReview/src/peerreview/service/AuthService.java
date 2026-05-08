package peerreview.service;

import peerreview.dao.UserDAO;
import peerreview.dao.UserDAOImpl;
import peerreview.model.User;

public class AuthService {

    private UserDAO userDAO;

    public AuthService() {

        userDAO =
                new UserDAOImpl();
    }

    public void register(

            String nom,

            String email,

            String motDePasse,

            String role
    ) {

        User user =
                new User();

        user.setNom(nom);

        user.setEmail(email);

        user.setMotDePasse(
                motDePasse
        );

        user.setRole(role);

        boolean result =
                userDAO.register(user);

        if (result) {

            System.out.println(
                    "Compte cree avec succes."
            );

        } else {

            System.out.println(
                    "Erreur inscription."
            );
        }
    }

    public User login(

            String email,

            String motDePasse
    ) {

        return userDAO.login(
                email,
                motDePasse
        );
    }
}