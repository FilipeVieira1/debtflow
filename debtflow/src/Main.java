import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Welcome to DebtFlow!");
        System.out.println("=====================");
        System.out.println("");
        System.out.println("Qual o seu nome?");
        String name = scanner.nextLine();
        System.out.println("Qual o valor da dívida?");
        double debtValue = scanner.nextDouble();
        System.out.println("Qual o número de parcelas?");
        int parcelas = scanner.nextInt();
        System.out.println("Olá " + name + ", o valor da sua dívida é de R$" + debtValue + " e será parcelada em " + parcelas + " vezes.");
        float valorParcela = (float) debtValue / parcelas;
        System.out.println("O valor de cada parcela será de R$" + valorParcela);
        scanner.close();
    }
}
