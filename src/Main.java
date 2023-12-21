import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        loopCalcularNotas();
    }

    private static void loopCalcularNotas() {
        Scanner s = new Scanner(System.in);
        String continuarCalcularMedia;

        do {
            Double nota1 = salvarNota(1);
            Double nota2 = salvarNota(2);
            Double nota3 = salvarNota(3);
            Double nota4 = salvarNota(4);

            Double mediaDasNotas = calcularMedia(nota1, nota2, nota3, nota4);

            situacaoDoAluno(mediaDasNotas);

            System.out.println("Deseja calcular a media das notas de mais algum aluno? 'S' para sim/ 'N' para nao");
            continuarCalcularMedia = s.next();

            if (continuarCalcularMedia.equalsIgnoreCase("S")) {
                System.out.println("-----------------------------------------");
            }
        } while (continuarCalcularMedia.equalsIgnoreCase("S"));

        s.close();
    }

    private static void situacaoDoAluno(Double mediaDasNotas) {
        if (mediaDasNotas >= 7) {
            System.out.println("A media do aluno e: " + mediaDasNotas);
            System.out.println("O aluno esta aprovado");
        } else if (mediaDasNotas >= 5) {
            System.out.println("A media do aluno e: " + mediaDasNotas);
            System.out.println("O aluno esta em recuperacao");
        } else {
            System.out.println("A media do aluno e: " + mediaDasNotas);
            System.out.println("O aluno esta reprovado");
        }
    }

    private static Double calcularMedia(Double nota1, Double nota2, Double nota3, Double nota4) {
        double soma = nota1 + nota2 + nota3 + nota4;

        return soma / 4;
    }

    private static Double salvarNota(int numeroNota) {
        String notaString;
        double nota;

        do {
            notaString = lerNota(numeroNota);
            nota = converterNota(notaString);

            if (nota > 10 || nota < 0) {
                System.out.println("Nota invalida, por favor digite uma nota entre 0 e 10");
            }
        } while (nota > 10 || nota < 0);

        return nota;
    }

    private static String lerNota(int numeroNota) {
        Scanner s = new Scanner(System.in);
        System.out.print("Digite a nota " + numeroNota + " do aluno: ");
        return s.nextLine();
    }

    private static double converterNota(String notaString) {
        try {
            notaString = notaString.replace(",", ".");
            return Double.parseDouble(notaString);
        } catch (NumberFormatException e) {
            return -1.0;
        }
    }
}