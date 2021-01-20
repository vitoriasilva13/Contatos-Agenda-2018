
package br.ifg.edu.agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

import br.ifg.edu.agenda.contato.Contato;

public class Agenda implements AgendaInterface {

	private static final String NO_CONTENT = "AINDA NÃO HÁ CONTATOS CADASTRADOS";
	//ArrayList para contatos
	private ArrayList<Contato> contatos = new ArrayList<Contato>();

	//Método que cria contato
	@Override
	public void criaContato() {
		Contato contato = new Contato();
		//se não houver contatos id do contato será 1 senão será o id do último contato + 1
		if (contatos.isEmpty()) {
			contato.setId(1);
		} else {
			contato.setId(contatos.get(contatos.size() - 1).getId() + 1);
		}
		contato.setNome(JOptionPane.showInputDialog("Nome: ").toUpperCase());
		contato.setNumero(JOptionPane.showInputDialog("Número: "));
		contato.setEmail(JOptionPane.showInputDialog("Email: "));
		contatos.add(contato);
	}

	//Método que mostra a lista de contatos
	@Override
	public void mostraContatos() {
		ordenaPorNome(getContatos());
		System.out.println("\n[ID] [NOME] [NÚMERO] [E-MAIL]");
		for (int i = 0; i < contatos.size(); i++) {
			System.out.println(contatos.get(i));
		}
		System.out.println("--------------------------------");
	}

	//Método que busca contatos na lista de contatos
	@Override
	public void buscaContato() {
		if (contatos.isEmpty()) {
			System.out.println(NO_CONTENT);
		} else {
			String n = JOptionPane.showInputDialog("NOME DO CONTATO:").toUpperCase();
			System.out.println("\nRESULTADOS DA BUSCA:");
			for (int i = 0; i < contatos.size(); i++) {
				if (contatos.get(i).getNome().equals(n)) {
					System.out.println(contatos.get(i));
				}
			}
			System.out.println("--------------------------------");
		}
	}

	//Método que busca e remove contatos na lista de contatos
	@Override
	public void removerContato() {
		if (contatos.isEmpty() == false) {
			mostraContatos();
			int n = Integer.parseInt(JOptionPane.showInputDialog("ID DO CONTATO:"));
			for (int i = 0; i < contatos.size(); i++) {
				if (contatos.get(i).getId() == n) {
					System.out.println("CONTATO  " + contatos.get(i).getNome() + "  REMOVIDO");
					contatos.remove(i);
				}
			}
		} else {
			System.out.println(NO_CONTENT);
		}
	}

	//Método que ordena alfabeticamente os contatos na lista
	public static void ordenaPorNome(ArrayList<Contato> contatos) {
		Collections.sort(contatos, new Comparator<Contato>() {
			@Override
			public int compare(Contato o1, Contato o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
	}

	//Método que edita contatos na lista de contatos
	@Override
	public void editarContato() {
		if (contatos.isEmpty() == false) {
			mostraContatos();
			int n = Integer.parseInt(JOptionPane.showInputDialog("ID DO CONTATO:"));
			for (int i = 0; i < contatos.size(); i++) {
				if (contatos.get(i).getId() == n) {
					int a = Integer.parseInt(JOptionPane
							.showInputDialog("O QUE DESEJA EDITAR?\n" + " 1 - NOME\n 2 - NÚMERO\n 3 - " + "EMAIL"));
					switch (a) {
					case 1:
						contatos.get(i).setNome(JOptionPane.showInputDialog("NOVO NOME:").toUpperCase());
						break;
					case 2:
						contatos.get(i).setNumero(JOptionPane.showInputDialog("NOVO NÚMERO:"));
						break;
					case 3:
						contatos.get(i).setEmail(JOptionPane.showInputDialog("NOVO EMAIL:"));
						break;
					}
				}
			}
		} else {
			System.out.println(NO_CONTENT);
		}
	}

	/**
	 * @return the contatos
	 */
	public ArrayList<Contato> getContatos() {
		return contatos;
	}

	/**
	 * @param contatos
	 *            the contatos to set
	 */
	public void setContatos(ArrayList<Contato> contatos) {
		this.contatos = contatos;
	}
}
