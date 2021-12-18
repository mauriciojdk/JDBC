package com.mauriciojdk;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        MovieDAO dao = new MovieDAO();

        System.out.println("---------- MENU ----------");
        System.out.println("1 - Listar filmes");
        System.out.println("2 - Adicionar novo filme");
        System.out.println("3 - Atualizar um filme");
        System.out.println("4 - Remover um filme");
        System.out.println("5 - Sair");
        System.out.println("---------------------------");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                ArrayList<Movie> data = (ArrayList<Movie>) dao.findAll();
                for (Movie movie : data) {
                    System.out.println("Id: " + movie.getId());
                    System.out.println("Name: " + movie.getName());
                }
                break;
            case 2:
                System.out.println("Insira o nome: ");
                String name = scanner.next();
                dao.adicionar(new Movie(name));
                break;
            case 3:
                System.out.println("Indique o id: ");
                Integer id = scanner.nextInt();

                Movie movieExists = dao.findById(id);

                if (movieExists != null) {
                    System.out.println("Digite o novo nome do filme: ");
                    String movieName = scanner.next();

                    Movie movieNew = new Movie(movieExists.getId(), movieName);
                    dao.atualizar(movieExists, movieNew);
                } else {
                    System.out.println("Não existe ");
                }
                break;
            case 4:
                System.out.println("Insira o id: ");
                Integer idDelete = scanner.nextInt();

                Movie movieExistDelete = dao.findById(idDelete);

                if (movieExistDelete != null) {
                    dao.remover(movieExistDelete);
                } else {
                    System.out.println("ID inexistente ");
                }

                break;
            default:
                System.out.println("Opção invalida");
        }


    }
}
