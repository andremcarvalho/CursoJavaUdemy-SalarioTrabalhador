package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.enums.NivelTrabalho;
import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Trabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // para trabalhar com a data do contrato

		System.out.print("Entre com o nome do departamento: ");
		String departamentoNome = sc.nextLine();
		System.out.println("Entre com os dados do trabalhador:");
		System.out.print("Nome: " );
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nível: " );
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Salário Base: " );
		double salarioBase = sc.nextDouble();
		
		//Apos adquirir as informações instanciamos o trabalhador para associar os dados digitados a classe trabalhador
		
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalho.valueOf(nivelTrabalhador), salarioBase, new Departamento (departamentoNome) );
		
		System.out.print("Quantos contratos para o trabalhador? ");
		int nContrato = sc.nextInt();
		
		for (int i=1 ; i<= nContrato ; i++) {
			System.out.println("Entre com os dados do contrato #"+i);
			System.out.print("Data: (DD/MM/AAAA): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Duração do contrato (horas):  ");
			int horas = sc.nextInt();
			
			// instanciar contrato apos adquirir as informações
			
			ContratoHora contrato = new ContratoHora(dataContrato, valorHora, horas);
			
			// Associar o contrato ao trabalhador
			trabalhador.adicionaContrato(contrato);		
			
		}
		
		System.out.println("");
		System.out.print("Entre com o mês e o ano para calcular a renda (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt (mesAno.substring(0,2)); // converte a string com indice 0 e 1+1 em numero usando wrapper Integer.parseInt para converter string em numero inteiro
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("");
		System.out.println("Nome: "+ trabalhador.getNome());
		System.out.println("Departamento: "+ trabalhador.getDepartamento().getNome());
		System.out.println("Renda para "+mesAno+ " :"+ String.format ("%.2f",trabalhador.renda(ano, mes)));
		
		
		
		sc.close();
	}

}
