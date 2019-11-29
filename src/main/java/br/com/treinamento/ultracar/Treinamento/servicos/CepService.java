package br.com.treinamento.ultracar.Treinamento.servicos;

import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import br.com.treinamento.ultracar.Treinamento.entidades.Bairro;
import br.com.treinamento.ultracar.Treinamento.entidades.Cep;
import br.com.treinamento.ultracar.Treinamento.entidades.Cidade;
import br.com.treinamento.ultracar.Treinamento.entidades.Endereco;
import br.com.treinamento.ultracar.Treinamento.entidades.Estado;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.CepDTO;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.ExternalCepDTO;
import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.TipoLocal;
import br.com.treinamento.ultracar.Treinamento.repositorios.CepRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CepService {

	@Autowired
	private CepRepository repositorio;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private BairroService bairroService;
	
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
		
		Cep cep = Cep.builder().numero(numero).build();
		
		Estado estado = Estado.builder().sigla(StringUtils.upperCase(dto.getUf())).build();
		estado = this.estadoService.checkAndSave(estado);
		
		Cidade cidade = Cidade.builder().nome(StringUtils.upperCase(dto.getCidade())).estado(estado).build();
		cidade = this.cidadeService.checkAndSave(cidade);
		
		Bairro bairro = Bairro.builder().nome(StringUtils.upperCase(dto.getBairro())).cidade(cidade).build();
		bairro = this.bairroService.checkAndSave(bairro);
		
		Endereco endereco = Endereco.builder().logradouro(StringUtils.upperCase(dto.getLogradouro()))
				.tipoLocal(TipoLocal.valueOf(StringUtils.upperCase(dto.getTipoLogradouro())))
				.bairros(new HashSet<>(Arrays.asList(bairro))).build();
		endereco = this.enderecoService.checkAndSave(endereco);
		
		cep.setEndereco(endereco);
		cep = this.repositorio.save(cep);
		return this.repositorio.findByNumero(cep.getNumero());
	}
	
}
