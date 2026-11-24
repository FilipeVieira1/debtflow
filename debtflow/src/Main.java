import java.util.Scanner;

public class Main {
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
        System.out.println(description + " - " + creditor + " - R$" + debtValue + " - " + installments + " parcelas");
        float installmentValue = (float) debtValue / installments;
        System.out.printf("O valor de cada parcela será de R$", installmentValue);
        scanner.close();
    }
}
