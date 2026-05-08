package peerreview.controller;

import peerreview.model.User;
import peerreview.service.AuthService;
import peerreview.util.InputHelper;

public class AuthController {

    private AuthService authService;

    public AuthController() {

        authService =
                new AuthService();
    }

    public void register() {

        System.out.println();

        System.out.println(
                "===== REGISTER ====="
        );

        String nom =
                InputHelper.lireString(
                        "Nom : "
                );

        String email =
                InputHelper.lireString(
                        "Email : "
                );

        String motDePasse =
                InputHelper.lireString(
                        "Mot de passe : "
                );

        String role =
                InputHelper.lireString(
                        "Role (ETUDIANT/ENSEIGNANT) : "
                );

        authService.register(

                nom,

                email,

                motDePasse,

                role
        );
    }

    public User login() {

        System.out.println();

        System.out.println(
                "===== LOGIN ====="
        );

        String email =
                InputHelper.lireString(
                        "Email : "
                );

        String motDePasse =
                InputHelper.lireString(
                        "Mot de passe : "
                );

        User user =
                authService.login(
                        email,
                        motDePasse
                );

        if (user != null) {

            System.out.println(
                    "Connexion reussie."
            );

            return user;

        } else {

            System.out.println(
                    "Email ou mot de passe incorrect."
            );
        }

        return null;
    }
}