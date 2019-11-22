package br.com.treinamento.ultracar.Treinamento.servicos;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import br.com.treinamento.ultracar.Treinamento.entidades.Cep;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.CepDTO;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.ExternalCepDTO;
import br.com.treinamento.ultracar.Treinamento.repositorios.CepRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CepService {

	@Autowired
	private CepRepository repositorio;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Cep salvarCep(CepDTO cepDTO) {
		Cep cep = Cep.builder().build();
		BeanUtils.copyProperties(cepDTO, cep);
		return this.repositorio.save(cep);
	}
	
	public Cep findOne(Long id) {
		return this.repositorio.getOne(id);
	}
	
	public Cep findByNumero(Integer numero) {
		Cep cep = Cep.builder().numero(numero).build();
		Example<Cep> filtro = Example.of(cep, ExampleMatcher.matchingAny());
		return this.repositorio.exists(filtro) ? this.repositorio.findByNumero(numero) : findByNumeroExternal(numero);
	}
	
	private Cep findByNumeroExternal(Integer numero) {
		String url = "http://cep.republicavirtual.com.br/web_cep.php?cep=" + numero + "&formato=jsonp";
		ExternalCepDTO dto = this.restTemplate.getForObject(url, ExternalCepDTO.class);
		
		/*Example<Endereco> filtro = Example.of(Endereco.builder().logradouro(dto.getLogradouro()).build(),
				ExampleMatcher.matchingAny().withIgnoreCase());
		Optional<Endereco> match = this.enderecoService.findOne(filtro);
		
		Endereco endereco = match.isPresent() ? match.get() : Endereco.builder().build();
		
		Cep cep = Cep.builder()
				.numero(numero)
				.build();*/
		return null;
	}
	
}
