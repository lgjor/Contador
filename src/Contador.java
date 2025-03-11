import java.util.Scanner;
/**
 * A classe Contador realiza a contagem de números dentro de um intervalo especificado pelo usuário.
 * Ela solicita dois parâmetros inteiros e, se o segundo parâmetro for maior que o primeiro,
 * realiza a contagem e imprime os números dentro do intervalo.
 * Caso contrário, lança uma exceção informando que o segundo parâmetro deve ser maior que o primeiro.
 */
public class Contador {

    /**
     * Construtor padrão da classe Contador.
     */
    public Contador() {
        // Construtor padrão vazio
    }

    /**
     * Exceção personalizada lançada quando o segundo parâmetro não é maior que o primeiro.
     */
	static class ParametrosInvalidosException extends Exception {
		@Override
        public String getMessage(){
            return "O segundo parâmetro deve ser maior que o primeiro";
        }
	}

    /**
     * Método principal que inicia a execução do programa.
     * Solicita ao usuário dois parâmetros inteiros e chama o método {@link #contar(int, int)} para realizar a contagem.
     * Se a exceção {@link ParametrosInvalidosException} for lançada, imprime a mensagem de erro.
     *
     * @param args Os argumentos da linha de comando (não utilizados neste programa).
     */
	public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        try {
            System.out.print("Digite o primeiro parâmetro: ");
            int parametroUm = terminal.nextInt();
            System.out.print("Digite o segundo parâmetro: ");
            int parametroDois = terminal.nextInt();
            //validar se parametroUm é MAIOR que parametroDois e lançar a exceção
            try {
                //chamando o método contendo a lógica de contagem
                contar(parametroUm, parametroDois);
            } catch (ParametrosInvalidosException exception) {
                //imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
                System.out.println(exception.getMessage());
            }
        } finally {
            // fechar o Scanner
            terminal.close();
        }
	}

    /**
     * Valida se o primeiro parâmetro é menor que o segundo parâmetro.
     *
     * @param parametroUm O primeiro parâmetro inteiro.
     * @param parametroDois O segundo parâmetro inteiro.
     * @return true se o primeiro parâmetro for menor que o segundo, false caso contrário.
     */
    static boolean validarParametros(int parametroUm, int parametroDois ) {
		if (parametroUm < parametroDois) {
			return true;
		}
		else {
			return false;
		}
		
	}

    /**
     * Realiza a contagem dos números dentro do intervalo especificado pelos parâmetros.
     * Lança a exceção {@link ParametrosInvalidosException} se o primeiro parâmetro não for menor que o segundo.
     *
     * @param parametroUm O primeiro parâmetro inteiro.
     * @param parametroDois O segundo parâmetro inteiro.
     * @throws ParametrosInvalidosException Se o segundo parâmetro não for maior que o primeiro.
     */
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		//validar se parametroUm é MAIOR que parametroDois e lançar a exceção
		if ( !validarParametros(parametroUm, parametroDois) )
            throw new ParametrosInvalidosException();
        int contagem = parametroDois - parametroUm;
        //realizar o for para imprimir os números com base na variável contagem
		for (int i=0; i < contagem; i++)
            System.out.println("Imprimindo o número " + (i+1));
    }
}