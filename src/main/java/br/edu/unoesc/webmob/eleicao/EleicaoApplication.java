package br.edu.unoesc.webmob.eleicao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unoesc.webmob.eleicao.model.Candidato;
import br.edu.unoesc.webmob.eleicao.model.Cargo;
import br.edu.unoesc.webmob.eleicao.model.Eleitor;
import br.edu.unoesc.webmob.eleicao.model.Partido;
import br.edu.unoesc.webmob.eleicao.model.Voto;
import br.edu.unoesc.webmob.eleicao.service.impl.CandidatoServiceImpl;
import br.edu.unoesc.webmob.eleicao.service.impl.EleitorServiceImpl;
import br.edu.unoesc.webmob.eleicao.service.impl.PartidoServiceImpl;
import br.edu.unoesc.webmob.eleicao.service.impl.VotoServiceImpl;

@SpringBootApplication
public class EleicaoApplication implements CommandLineRunner {

	// injeção de dependência do repositório
	@Autowired
	private CandidatoServiceImpl candidatoService;
	@Autowired
	private EleitorServiceImpl eleitorService;
	@Autowired
	private PartidoServiceImpl partidoService;
	@Autowired
	private VotoServiceImpl votoService;

	public static void main(String[] args) {
		SpringApplication.run(EleicaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("POS WEB - Java - Atividade 2");
		
		// criando um novo partido
     	//Partido p = new Partido(null, "Partido muito ruim", "PMR");
     	Partido p = new Partido(null, "Partido Honesto", "PH");
     	
     	// salvando o partido no banco de dados
     	partidoService.salvar(p);
     		
     	System.out.println("salvou o partido");
     				
     	List<Partido> part = partidoService.listar();
     	System.out.println("Lista de partidos:");
     	for(int i = 0; i < part.size(); i++){
     	    System.out.println(part.get(i).getSigla());
     	}

		// criando um novo candidato
		Candidato c = new Candidato();
		c.setCargo(Cargo.PRESIDENTE);
		c.setNome("Fulano da Silva");
		c.setCpf(12345l);
		c.setPartido(p);
		

		// salvando o candidato no banco de dados
		candidatoService.salvar(c);
		
		System.out.println("salvou o candidato");
		
		Candidato candidato = candidatoService.buscarPorCodigo(2);
		System.out.println("O nome do candidato cadastrado é: " + candidato.getNome());

		// buscando o candidato por Cpf
		List<Candidato> candidatos =
		candidatoService.listarPorCPF(12345l);
		System.out.println("O candidato relativo ao CPF informado é: " + candidatos.get(0).getCodigoRegistro()
		+ " - " + candidatos.get(0).getNome());
			
		// criando um novo eleitor
		Eleitor e = new Eleitor();
		e.setNumeroTitulo(55463164l);
		e.setNome("Marta Santos");
		e.setNomeMae("Cecilia Santos");
		e.setSecao(Short.parseShort("30"));
		e.setZonaEleitoral(Short.parseShort("9"));

		// salvando o eleitor no banco de dados
        eleitorService.salvar(e);
        
        System.out.println("salvou o eleitor");
        
        List<Eleitor> elei = eleitorService.listarPorNome("Marta Santos");
        System.out.println("O número do título do eleitor " + elei.get(0).getNome() +  
        " é " + elei.get(0).getNumeroTitulo());
     	
     	// criando um novo voto
     	Voto v = new Voto();
     	v.setUrna(145l);
     	Date date = new Date();
     	v.setData(date);
     	v.setCandidato(c);
     	v.setEleitor(e);
     	
     	// salvando o voto no banco de dados
     	votoService.salvar(v);
     		
     	System.out.println("salvou o voto");
     				
     	List<Voto> voto = votoService.dadosGrid();
     	for(int i = 0; i < voto.size(); i++){
     		System.out.println("O eleitor " + voto.get(i).getEleitor().getNome() +
     		" votou na urna " + voto.get(i).getUrna());
     	}
     	
	}
}
