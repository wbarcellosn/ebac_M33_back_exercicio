package com.wbarcellos;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.wbarcellosn.dao.AcessorioDAO;
import com.wbarcellosn.dao.CarroDAO;
import com.wbarcellosn.dao.IGenericDAO;
import com.wbarcellosn.dao.MarcaDAO;
import com.wbarcellosn.entities.Acessorio;
import com.wbarcellosn.entities.Carro;
import com.wbarcellosn.entities.Marca;

public class CarroTeste {

	private IGenericDAO<Carro> carroDao;
	private IGenericDAO<Marca> marcaDao;
	private IGenericDAO<Acessorio> acessDao;
	
	public CarroTeste() {
		carroDao = new CarroDAO();
		marcaDao = new MarcaDAO();
		acessDao = new AcessorioDAO();
	}
	
	@Test
	public void testeCadastrar() {
		
		Marca honda = new Marca();
        honda.setNome("Honda");
        honda = marcaDao.cadastrar(honda);
        
        assertNotNull(honda);

        Marca renault = new Marca();
        renault.setNome("Renault");
        renault = marcaDao.cadastrar(renault);
        
        assertNotNull(renault);
        
        // Criando os acessórios
        Acessorio radio = new Acessorio();
        radio.setNome("Rádio");
        radio = acessDao.cadastrar(radio);
        
        assertNotNull(radio);

        Acessorio arCondicionado = new Acessorio();
        arCondicionado.setNome("Ar condicionado");
        arCondicionado = acessDao.cadastrar(arCondicionado);
        
		assertNotNull(arCondicionado);

        Acessorio vidroEletrico = new Acessorio();
        vidroEletrico.setNome("Vidro elétrico");
        vidroEletrico = acessDao.cadastrar(vidroEletrico);
        
		assertNotNull(vidroEletrico);


        Acessorio bancoCouro = new Acessorio();
        bancoCouro.setNome("Banco de couro");
        bancoCouro = acessDao.cadastrar(bancoCouro);
        
		assertNotNull(bancoCouro);

		
        
        Carro carro1 = new Carro();
        carro1.setModelo("Civic");
        carro1.setAno(2020);
        carro1.setMarca(honda);
        carro1.setAcessorios(new HashSet<>(Set.of(radio, arCondicionado)));
        carro1 = carroDao.cadastrar(carro1);
        
		assertNotNull(carro1);
		assertNotNull(carro1.getId());


        Carro carro2 = new Carro();
        carro2.setModelo("Fit");
        carro2.setAno(2018);
        carro2.setMarca(honda);
        carro2.setAcessorios(new HashSet<>(Set.of(radio, vidroEletrico, bancoCouro)));
        carro2 = carroDao.cadastrar(carro2);
        
		assertNotNull(carro2);
		assertNotNull(carro2.getId());

        Carro carro3 = new Carro();
        carro3.setModelo("Sandero");
        carro3.setAno(2023);
        carro3.setMarca(renault);
        carro3.setAcessorios(new HashSet<>(Set.of(arCondicionado, vidroEletrico)));
        carro3 = carroDao.cadastrar(carro3);
        
		assertNotNull(carro3);
		assertNotNull(carro3.getId());

	}
}
