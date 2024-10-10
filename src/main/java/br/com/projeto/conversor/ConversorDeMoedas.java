package br.com.projeto.conversor;

import br.com.projeto.api.ApiClient;
import br.com.projeto.modelo.TaxasDeCambio;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class ConversorDeMoedas {

    public static void main(String[] args) {
        try {
            ApiClient apiClient = new ApiClient();
            JsonObject taxasJson = apiClient.obterTaxasDeCambio();

            TaxasDeCambio taxas = new TaxasDeCambio(
                    taxasJson.get("EUR").getAsDouble(),
                    taxasJson.get("BRL").getAsDouble(),
                    taxasJson.get("GBP").getAsDouble(),
                    taxasJson.get("JPY").getAsDouble(),
                    taxasJson.get("AUD").getAsDouble(),
                    taxasJson.get("CAD").getAsDouble()
            );

            Scanner scanner = new Scanner(System.in);

            System.out.println("Selecione a moeda de origem:");
            System.out.println("1. Dólar Americano");
            System.out.println("2. Euro");
            System.out.println("3. Real Brasileiro");
            System.out.println("4. Libra Esterlina");
            System.out.println("5. Iene Japonês");
            System.out.println("6. Dólar Australiano");
            System.out.println("7. Dólar Canadense");

            System.out.println("-");
            int origem = scanner.nextInt();

            System.out.println("Selecione a moeda de destino:");
            System.out.println("1. Dólar Americano");
            System.out.println("2. Euro");
            System.out.println("3. Real Brasileiro");
            System.out.println("4. Libra Esterlina");
            System.out.println("5. Iene Japonês");
            System.out.println("6. Dólar Australiano");
            System.out.println("7. Dólar Canadense");

            System.out.println("-");
            int destino = scanner.nextInt();

            System.out.print("Digite o valor: ");
            double valor = scanner.nextDouble();

            double taxaOrigem = 1;
            double taxaDestino = 1;

            taxaOrigem = switch (origem) {
                case 2 -> taxas.getEurRate();
                case 3 -> taxas.getBrlRate();
                case 4 -> taxas.getGbpRate();
                case 5 -> taxas.getJpyRate();
                case 6 -> taxas.getAudRate();
                case 7 -> taxas.getCadRate();
                default -> 1;
            };

            taxaDestino = switch (destino) {
                case 2 -> taxas.getEurRate();
                case 3 -> taxas.getBrlRate();
                case 4 -> taxas.getGbpRate();
                case 5 -> taxas.getJpyRate();
                case 6 -> taxas.getAudRate();
                case 7 -> taxas.getCadRate();
                default -> 1;
            };

            double valorConvertido = valor * (taxaDestino / taxaOrigem);

            System.out.println("Valor convertido: " + String.format("%.2f", valorConvertido));

        } catch (Exception e) {
            System.out.println("Erro ao obter as taxas de câmbio: " + e.getMessage());
        }
    }
}