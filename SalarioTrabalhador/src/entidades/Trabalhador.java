package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidade.enums.NivelTrabalho;

public class Trabalhador {
	
	//atributos
	private String nome;
	private NivelTrabalho nivel;
	private Double salarioBase;
	
	//associa��es
	private Departamento departamento;
	private List <ContratoHora> contratos = new ArrayList<>(); // a lista come�a vazia ...<>()  os metodos adcional e ou removem contratos
	// lista...pois a classe ContratoHora tem varios atributos
	// ja vai ser instanciada por padr�o na classe 
	
	//construtores
	public Trabalhador () {
		
	}

	
// ao criar o construtor n�o pode conter atributos listas
	public Trabalhador(String nome, NivelTrabalho nivel, Double salarioBase, Departamento departamento) {
	    this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public NivelTrabalho getNivel() {
		return nivel;
	}


	public void setNivel(NivelTrabalho nivel) {
		this.nivel = nivel;
	}


	public Double getSalarioBase() {
		return salarioBase;
	}


	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public List<ContratoHora> getContratos() {
		return contratos;
	}
	
	// n�o pode possuir o construtor setList <contrato>  pois n�op odera possuir mais de uma lista de contratos apenas uma onde ser�o removidos e incluidos contratos


	//m�todos
	// metodos e de fazer e desfazer a associa��o do contrato com um trabalhador
	public void adicionaContrato (ContratoHora contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato (ContratoHora contrato) {
		contratos.remove(contrato);
	}
	
	
	public Double renda (Integer ano, Integer mes) {
		
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (ContratoHora c: contratos) {
			cal.setTime(c.getData());//data do contrato como a data do calend�rio
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);  //o mes do calendar come�a com zero
						
			if (ano==c_ano && mes==c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;	
	
	}
	

}
