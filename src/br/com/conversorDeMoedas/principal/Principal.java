package src.br.com.conversorDeMoedas.principal;

import src.br.com.conversorDeMoedas.model.MenuOpcoes;

public class Principal {

    public static void main(String[] args) {

        MenuOpcoes menuOpcoes = new MenuOpcoes();
        menuOpcoes.exibirMenu();
        menuOpcoes.executar();
    }
}
