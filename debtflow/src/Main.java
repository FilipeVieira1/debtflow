import java.util.Scanner;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Main {
    Locale ptBr = new Locale.Builder().setLanguage("pt").setRegion("BR").build(); // define a localidade para pt-BR (teclado)
    public static void main(String[] args) throws Exception {
        LocalDate currentDate = LocalDate.now(); // obtem data atual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // formata a data para o padrão brasileiro
        System.out.println("Data atual: " + currentDate.format(formatter));
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
