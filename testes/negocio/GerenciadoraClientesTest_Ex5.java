package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais opera��es
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
 * 
 * @author José Robert
 * @date 25/08/2019
 */
public class GerenciadoraClientesTest_Ex5 {

	private GerenciadoraClientes gerClientes;

	/**
	 * Teste b�sico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author José Robert
	 * @date 25/018/2019
	 */
	@Test
	public void testPesquisaCliente() {

		/* ========== Montagem do cen�rio ========== */
		
		// criando alguns clientes
		int idCLiente01 = 1;
		int idCLiente02 = 2;
		Cliente cliente01 = new Cliente(idCLiente01, "José Robert", 23, "joserobert@gmail.com",1, true);
		Cliente cliente02 = new Cliente(idCLiente02, "Ruth de França", 22, "ruthfranca@gmail.com",2, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);

		/* ========== Execu��o ========== */
		Cliente cliente = gerClientes.pesquisaCliente(idCLiente01);
		
		/* ========== Verifica��es ========== */
		assertThat(cliente.getId(), is(idCLiente01));
		
	}
	
	/**
	 * Teste b�sico da remo��o de um cliente a partir do seu ID.
	 * 
	 * @author José Robert
	 * @date 25/08/2019
	 */
	@Test
	public void testRemoveCliente() {

		/* ========== Montagem do cen�rio ========== */
		
		// criando alguns clientes
		int idCLiente01 = 1;
		int idCLiente02 = 2;
		Cliente cliente01 = new Cliente(idCLiente01, "José Robert", 23, "joserobert@gmail.com",1, true);
		Cliente cliente02 = new Cliente(idCLiente02, "Ruth de França", 22, "ruthfranca@gmail.com",2, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/* ========== Execu��o ========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);
		
		/* ========== Verifica��es ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCLiente02));
		
	}
	
}
