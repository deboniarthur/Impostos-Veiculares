import java.util.Scanner;

public class Carro {

    //atributos
    String placa;
    String modelo;
    int anoFab;
    int imposto;
    static int totalisentos;
    static int totalimpostos;
    static int anoAtual = 2023;

    //metodo
    public static int calc_imposto(int anoFab, int anoAtual) {
        int anosDe_uso = anoAtual - anoFab;
        if (anosDe_uso == 0) {
            totalimpostos = totalimpostos + 500;
            return 500;
        }
        else if (anosDe_uso <= 4) {
            totalimpostos = totalimpostos + 500 - (anosDe_uso * 100);
            return 500 - (anosDe_uso * 100);
        }
        else if (anosDe_uso >= 5 && anosDe_uso < 9) {
            totalimpostos = totalimpostos + 100;
            return 100;
        }
        else {
            totalisentos = totalisentos + 1;
            return 0;
        }
    }
    public static void main(String[] args){
        //variável para continuar o ciclo
        String continuar = "S";
        Scanner dados = new Scanner(System.in);
        System.out.println("Olá, essa é minha calculadora de impostos veiculares em Java");

        while(continuar.equalsIgnoreCase("S")) {

            System.out.println("Digite a placa do carro: ");
            String placa = dados.next();

            System.out.println("Digite o modelo do carro:");
            String modelo = dados.next();

            System.out.println("Digite o ano da fabricação;");
            int anoFab = dados.nextInt();


            int imposto = calc_imposto(anoFab, anoAtual);

            System.out.println("O imposto a ser pago pelo " + modelo + " é " + imposto + " reais ");
            System.out.println("O total de carros isentos de imposto é: " + totalisentos);
            System.out.println("O total de imposto a ser pago é: " + totalimpostos);

            //continua ou fecha o ciclo e acaba o programa
            System.out.println("Deseja calcular o imposto para outro carro? (S/s para Sim ou outra tecla qualquer para Sair): ");
            continuar = dados.next();

        }
    }
}