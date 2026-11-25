import java.util.Scanner;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Main {
    
    public static void main(String[] args) throws Exception {
        Locale ptBr = new Locale.Builder().setLanguage("pt").setRegion("BR").build(); // define o locale para português do Brasil
        LocalDate currentDate = LocalDate.now(); // obtem data atual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // formata a data para o padrão brasileiro
        System.out.println("Data atual: " + currentDate.format(formatter));
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Welcome to DebtFlow!");
        System.out.println("=====================");
        System.out.println("");
        scanner.useLocale(ptBr);
        System.out.println("Qual a descrição da dívida?");
        String description = scanner.nextLine();
        System.out.println("Qual o credor da dívida?");
        String creditor = scanner.nextLine();
        System.out.println("Qual o valor da dívida?");
        double debtValue = scanner.nextDouble();
        System.out.println("Qual o número de parcelas?");
        int installments = scanner.nextInt();
        System.out.println("Quando será o vencimento da primeira parcela? (dd/MM/yyyy)");
        LocalDate firstInstallmentDate = LocalDate.parse(scanner.next(), formatter);
        scanner.close();
        

        // validação de entrada de dados
        if (installments < 1 || debtValue < 1) {
            System.out.println("O número de parcelas deve ser maior que 0 e o valor da dívida deve ser positivo.");
        } else {
            double installmentValue = debtValue % installments;
            System.out.printf("Descrição: %s\nCredor: %s\nValor: R$ %.2f\nParcelas: %d\n", description, creditor, debtValue, installments);
            System.out.printf("O valor de cada parcela será de R$ %.2f%n", installmentValue);

            // exibe o valor de cada parcela
            
            for (int i = 1; i <= installments; i++){
                firstInstallmentDate = firstInstallmentDate.plusMonths(1); // adiciona 1 mês à data da primeira parcela
                System.out.printf("Parcela %d - R$ %.2f - vencimento: %s%n", i, installmentValue, firstInstallmentDate.format(formatter));
            }
        }
        
        
    }
}
