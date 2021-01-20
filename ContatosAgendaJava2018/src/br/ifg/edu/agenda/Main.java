package br.ifg.edu.agenda;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// criando um novo objeto Agenda
		Agenda agenda = new Agenda();

		// Mostra menu da agenda
		for (int i = 0; i >= 0; i++) {
			int a = Integer.parseInt(JOptionPane.showInputDialog(
					"+ ESCOLHA UMA AÇÃO: +\n" + " 1 - BUSCAR CONTATO\n 2 - LISTA DE CONTATOS\n 3 - ADICIONAR CONTATO\n "
							+ "4 - EDITAR CONTATO\n 5 - REMOVER CONTATO\n 6 - SAIR"));
			switch (a) {
			case 1:
				agenda.buscaContato();
				break;
			case 2:
				agenda.mostraContatos();
				break;
			case 3:
				agenda.criaContato();
				break;
			case 4:
				agenda.editarContato();
				break;
			case 5:
				agenda.removerContato();
			}
			if (a >= 6) {
				break;
			}
		}
	}
}
