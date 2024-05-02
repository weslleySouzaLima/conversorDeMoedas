package src.br.com.conversorDeMoedas.model;

import java.util.Scanner;

public class MenuOpcoes {
    private final Scanner scanner;

    public MenuOpcoes() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("""
                Menu de Opções:
                1) [USD] para [BRL]
                2) [EUR] para [BRL]
                3) [ARS] para [BRL]
                4) [BRL] para [USD]
                5) [BRL] para [EUR]
                6) [BRL] para [ARS]
                0) Sair
                """);
    }

    public void executar() {
        boolean executarMenu = true;
        while (executarMenu) {
            exibirMenu();
            System.out.println("Escolha uma opção para converter:");
            String opcao = scanner.next();
            switch (opcao) {
                case "1" -> converterMoeda("USD", "BRL");
                case "2" -> converterMoeda("EUR", "BRL");
                case "3" -> converterMoeda("ARS", "BRL");
                case "4" -> converterMoeda("BRL", "USD");
                case "5" -> converterMoeda("BRL", "EUR");
                case "6" -> converterMoeda("BRL", "ARS");
                case "0" -> {
                    System.out.println("Até logo!");
                    executarMenu = false;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    private void converterMoeda(String baseCode, String targetCode) {
        System.out.println("Informe um valor para conversão: ");
        try {
            double valor = scanner.nextDouble();
            ConverterMoedas converter = new ConverterMoedas(baseCode, targetCode, valor);
            HttpHandlers httpHandlers = new HttpHandlers(converter);
            System.out.println(httpHandlers.fazerRequisicao());
        } catch (Exception e) {
            System.out.println("Valor digitado é inválido... Utilize ',' para converter números decimais.");
            scanner.next();
        }
    }
}
