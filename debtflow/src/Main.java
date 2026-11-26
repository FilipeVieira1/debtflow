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
        long debtValueInCents = Math.round(debtValue * 100); // converte o valor da dívida para centavos
        

        // validação de entrada de dados
        if (installments < 1 || debtValue <= 0) {
            System.out.println("O número de parcelas deve ser maior que 0 e o valor da dívida deve ser positivo.");
        } else {
            //TODO corrigir a distribuição de centavos, atualmente o valor da primeira é maior mas n sei como aplicar na tabela.
            long installmentValueInCents = debtValueInCents / installments;
            long rest = debtValueInCents % installments; // calcula o resto da divisão para distribuir os centavos restantes
            double installmentValue = installmentValueInCents / 100.0;
            System.out.printf("Descrição: %s\nCredor: %s\nValor: R$ %.2f\nParcelas: %d\n", description, creditor, debtValue, installments);
            System.out.printf("O valor de cada parcela será de R$ %.2f%n", installmentValue);
            double firstInstallment = installmentValue + (rest / 100.0); // adiciona o resto da divisão à primeira parcela
            System.out.printf("A primeira parcela será de R$ %.2f%n", firstInstallment);
            

            // exibe o valor de cada parcela
            
            for (int i = 1; i <= installments; i++){
                //TODO corrigir a data que é exibida em dias diferentes como 31 ou 28 que causa erro na exibição dos proximos meses.
                System.out.printf("Parcela %d - R$ %.2f - vencimento: %s%n", i, installmentValue, firstInstallmentDate.format(formatter));
                firstInstallmentDate = firstInstallmentDate.plusMonths(1); // adiciona 1 mês à data da primeira parcela
            }
        }
        
        
    }
}
