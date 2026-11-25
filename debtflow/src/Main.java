import java.util.Scanner;
import java.util.Locale;



public class Main {
    Locale ptBr = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Welcome to DebtFlow!");
        System.out.println("=====================");
        System.out.println("");
        System.out.println("Qual a descrição da dívida?");
        String description = scanner.nextLine();
        System.out.println("Qual o credor da dívida?");
        String creditor = scanner.nextLine();
        System.out.println("Qual o valor da dívida?");
        double debtValue = scanner.nextDouble();
        System.out.println("Qual o número de parcelas?");
        int installments = scanner.nextInt();
        if (installments < 1 || debtValue < 0) {
            System.out.println("O número de parcelas deve ser maior que 0 e o valor da dívida deve ser positivo.");
        } else {
            System.out.println("Descrição: " + description + "\nCredor: " + creditor + "\nValor: R$" + debtValue + "\nParcelas: " + installments);

            double installmentValue = (double) debtValue / installments;
            System.out.printf("O valor de cada parcela será de R$", installmentValue);
        }
        scanner.close();

    }
}
