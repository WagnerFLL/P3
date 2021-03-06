import java.util.Scanner;

public class GestaoDeRecursos {

	public static boolean verificar_user(String user, String[] users, String[] status, int n){

		for(int i = 0; i<n ; i++){
			if(user.equals(users[i])){
				if(status[i].equals("Em andamento")){
					System.out.println("Este usuário já possui uma alocação em andamento.");
					return true;
				}
			}
		}
		return false;
	}

	public static boolean verificar_cadastro(String[] users, int n, String nome){
		for(int i = 0 ; i<n ; i++){
			if(users[i].equals(nome))return true;
		}
		return false;
	}

	public static void main(String[] args) {

		System.out.println("[   Sistema de alocação   ]\n");

		Scanner readerInt = new Scanner(System.in);
		Scanner readerStr = new Scanner(System.in);

		int[] users = new int[100];

		int[] recurso = new int[100];
		int[] tipoRecurso = new int[100];
		String[] recursoData = new String[100];
		String[] recursoHoraInicio = new String[100];
		String[] recursoHoraTermino = new String[100];
		String[] recursoResponsavel = new String[100];
		String[] recursoStatus = new String[100];

		String[] alunos = new String[100];
		String[] pesquisadores = new String[100];
		String[] professores = new String[100];
		int n_alunos = 0;
		int n_professores = 0;
		int n_pesquisadores = 0;

		String[] recursoAtividadeTitulo = new String[100];
		int[] recursoAtividadeTipo = new int[100];
		String[] recursoAtividadeDescricao = new String[100];
		String[] recursoAtividadeMaterial = new String[100];

		int option = 0;
		int count = 0;
		while(true) {
			System.out.println(" =================================\n"
					+ "|\tEscolha uma da opções:\n"
					+ "|\t1 - Alocar recurso.\n"
					+ "|\t2 - Administrar alocações.\n"
					+ "|\t3 - Relatório acadêmico.\n"
					+ "|\t4 - Consultar alocação.\n"
					+ "|\t5 - Consultar usuário.\n"
					+ "|\t6 - Consultar recurso.\n"
					+ "|\t7 - Cadastrar usuário.\n"
					+ "|\t8 - Sair.");
			option = readerInt.nextInt();

			if(option == 1) {

				System.out.println("Nome do responsável:");
				String resp = readerStr.nextLine();

				int user_type;
				if(verificar_cadastro(alunos, n_alunos, resp))user_type = 1;
				else if(verificar_cadastro(professores, n_professores, resp))user_type = 2;
				else if(verificar_cadastro(pesquisadores, n_pesquisadores, resp))user_type = 3;
				else{
					System.out.println("Usuário ainda não cadastrado.");
					continue;
				}

				if(verificar_user(resp, recursoResponsavel, recursoStatus, count))
					continue;

				System.out.println("===========================\n"
						+ "\tQual o recurso?\n"
						+ "\t1 - Sala.\n"
						+ "\t2 - Laboratório.\n"
						+ "\t3 - Projetor.\n");
				int type = readerInt.nextInt();

				System.out.println("===========================\n"
						+ "\tQual a atividade?\n"
						+ "\t1 - Aula Tradicional.\n"
						+ "\t2 - Laboratório.\n"
						+ "\t3 - Apresentação.\n");
				int type_act = readerInt.nextInt();

				if(user_type == 2 && (type == 1 || type == 2)) {

					recursoResponsavel[count] = resp;
					recursoAtividadeTipo[count] = type_act;
					tipoRecurso[count] = type;
					users[count] = user_type;
					recursoStatus[count] = "Em andamento";
					System.out.println("Digite o número da sala/lab que deseja alocar:");
					recurso[count] = readerInt.nextInt();
					System.out.println("Digite a hora de início:");
					recursoHoraInicio[count] = readerStr.nextLine();
					System.out.println("Digite a hora de fim:");
					recursoHoraTermino[count] = readerStr.nextLine();
					System.out.println("Titulo da atividade:");
					recursoAtividadeTitulo[count] = readerStr.nextLine();
					System.out.println("Decrição da atividade:");
					recursoAtividadeDescricao[count] = readerStr.nextLine();
					System.out.println("Material:");
					recursoAtividadeMaterial[count] = readerStr.nextLine();
					System.out.println("Data:");
					recursoData[count] = readerStr.nextLine();
					System.out.println("Concluído. Alocação aguardando confirmação! \n [ID = "+count+"]");
					++count;

				}else if(type_act == 3) {

					recursoResponsavel[count] = resp;
					tipoRecurso[count] = type;
					users[count] = user_type;
					recursoStatus[count] = "Em andamento";
					System.out.println("Digite o número da projetor que deseja alocar:");
					recurso[count] = readerInt.nextInt();
					System.out.println("Digite a hora de início:");
					recursoHoraInicio[count] = readerStr.nextLine();
					System.out.println("Digite a hora de fim:");
					recursoHoraTermino[count] = readerStr.nextLine();
					System.out.println("Titulo da atividade:");
					recursoAtividadeTitulo[count] = readerStr.nextLine();
					System.out.println("Decrição da atividade:");
					recursoAtividadeDescricao[count] = readerStr.nextLine();
					System.out.println("Material:");
					recursoAtividadeMaterial[count] = readerStr.nextLine();
					System.out.println("Data:");
					recursoData[count] = readerStr.nextLine();
					System.out.println("Concluído. Alocação aguardando confirmação! \n [ID = "+count+"]");
					++count;

				}else{
					System.out.println("Este usuário não pode alocar recurso para esse tipo de atividade.");
				}
			}
			else if(option == 4) {
				System.out.println("Digite o ID do alocação:");
				int id = readerInt.nextInt();
				if(id > count){
					System.out.println("Alocação inexistente!");
					continue;
				}
				System.out.print("Recurso: ");
				if(tipoRecurso[id] == 1)System.out.println("Sala "+recurso[id]);
				else if(tipoRecurso[id] == 2)System.out.println("Laboratório "+recurso[id]);
				else if(tipoRecurso[id] == 3)System.out.println("Projetor 00"+recurso[id]);
				System.out.println("Título: "+recursoAtividadeTitulo[id]);
				System.out.println("Responsável: "+recursoResponsavel[id]);
				System.out.println("Status: "+recursoStatus[id]);
				System.out.println("Data: "+recursoData[id]);
				System.out.println("Decrição da atividade: "+recursoAtividadeDescricao[id]);
				System.out.println("Horário:"+recursoHoraInicio[id]+" - "+recursoHoraTermino[id]);

			}
			else if(option == 3) {

				int aula = 0,lab = 0, apresentacao = 0;
				int concluido = 0, andamento = 0, alocado = 0;

				for(int i=0 ; i<count ; i++) {

					if(recursoStatus[i].equals("Em andamento"))andamento++;
					else if(recursoStatus[i].equals("Alocado"))alocado++;
					else if(recursoStatus[i].equals("Concluído"))concluido++;

					if(recursoAtividadeTipo[i] == 1)aula++;
					else if(recursoAtividadeTipo[i] == 2)lab++;
					else if(recursoAtividadeTipo[i] == 3)apresentacao++;

				}

				System.out.println("Número total de alocações: "+count);
				System.out.println("Número de processos em andamento: "+andamento);
				System.out.println("Número de processos concluídos: "+concluido);
				System.out.println("Número de processos alocados: "+alocado);
				System.out.println("Número de usuários: "+(n_alunos+n_pesquisadores+n_professores));
				System.out.println("Aulas: "+aula);
				System.out.println("Aulas em Laboratórios: "+lab);
				System.out.println("Apresentaçõs: "+apresentacao);

			}
			else if(option == 2) {
				System.out.println("Digite o ID do alocação:");
				int id = readerInt.nextInt();
				if(id > count){
					System.out.println("Alocação inexistente!");
					continue;
				}
				System.out.print("Recurso: ");
				if(tipoRecurso[id] == 1)System.out.println("Sala "+recurso[id]);
				else if(tipoRecurso[id] == 2)System.out.println("Laboratório "+recurso[id]);
				else if(tipoRecurso[id] == 3)System.out.println("Projetor 00"+recurso[id]);
				System.out.println("Responsável: "+recursoResponsavel[id]);
				System.out.println("Status: "+recursoStatus[id]);
				System.out.println("Data: "+recursoData[id]);
				System.out.println("Decrição da atividade:"+recursoAtividadeDescricao[id]);
				System.out.println("Horário:"+recursoHoraInicio[id]+" - "+recursoHoraTermino[id]);

				System.out.println("\nDeseja alterar alguma informação? (y/n)");
				String op = readerStr.nextLine();
				if(op.equals("y")){
					System.out.println("=============================\n"
							+ "\tEscolha uma das opções:\n"
							+ "\t1 - Alterar horário.\n"
							+ "\t2 - Alterar status.\n"
							+ "\t3 - Alterar descrição.");
					int choice = readerInt.nextInt();
					if(choice == 1){
						System.out.println("\nDigite a hora de início: ");
						recursoHoraInicio[id] = readerStr.nextLine();
						System.out.println("\nDigite a hora de término: ");
						recursoHoraTermino[id] = readerStr.nextLine();
					}else if(choice == 2){
						System.out.println("==========================\n"
								+ "\tQual o novo status:\n"
								+ "\t1 - Alocado.\n"
								+ "\t2 - Concluído.\n"
								+ "\t3 - Em andamento.");
						int enter = readerInt.nextInt();
						if(enter == 1)recursoStatus[id] = "Alocado";
						else if(enter == 2)recursoStatus[id] = "Concluído";
						else if(enter == 3)recursoStatus[id] = "Em andamento";
					}
				}
			}
			else if(option == 5) {
				System.out.println("Digite o nome do usuário a ser consultado:");
				String search = readerStr.nextLine();

				boolean find = false;

				for(int i=0 ; i<count ; i++) {
					if(recursoResponsavel[i].equals(search)) {
						find = true;
						System.out.print("Recurso: ");
						if(tipoRecurso[i] == 1)System.out.println("Sala "+recurso[i]);
						else if(tipoRecurso[i] == 2)System.out.println("Laboratório "+recurso[i]);
						else if(tipoRecurso[i] == 3)System.out.println("Projetor 00"+recurso[i]);
						System.out.println("Título: "+recursoAtividadeTitulo[i]);
						System.out.println("Status: "+recursoStatus[i]);
						System.out.println("Data: "+recursoData[i]);
						System.out.println("Decrição da atividade: "+recursoAtividadeDescricao[i]);
						System.out.println("Hora de início: "+recursoHoraInicio[i]);
						System.out.println("Hora de fim: "+recursoHoraTermino[i]);
						System.out.println("\n-----------------------------------\n");
					}
				}

				if(!find)System.out.println("Usuário não encontrado.");
			}
			else if(option == 6) {
				System.out.println("===========================\n"
						+ "\tQual o recurso?\n"
						+ "\t1 - Sala.\n"
						+ "\t2 - Laboratório.\n"
						+ "\t3 - Projetor.\n");
				int type = readerInt.nextInt();

				boolean find = false;

				int i = 0;
				for(i=0 ; i<count ; i++) {
					if(tipoRecurso[i] == type) {
						find = true;
						System.out.println(recursoAtividadeTitulo[i]);
						System.out.println("Responsável: "+recursoResponsavel[i]);
						System.out.println("Status: "+recursoStatus[i]);
						System.out.println("Data: "+recursoData[i]);
						System.out.println("Decrição da atividade:"+recursoAtividadeDescricao[i]);
						System.out.println("Hora de início:"+recursoHoraInicio[i]);
						System.out.println("Hora de fim:"+recursoHoraTermino[i]);
						System.out.println("\n-----------------------------------\n");
					}
				}

				if(!find)System.out.println("Recurso nunca foi alocado!");

			}else if(option == 7){
				System.out.println("==============================\n"
						+ "\tQual o tipo de usuário?\n"
						+ "\t1 - Aluno.\n"
						+ "\t2 - Professor.\n"
						+ "\t3 - Pesquisador.");
				int type = readerInt.nextInt();

				System.out.println("Digite o nome do usuário: ");

				if(type == 1) alunos[n_alunos++] = readerStr.nextLine();
				else if(type == 2) professores[n_professores++] = readerStr.nextLine();
				else if(type == 3) pesquisadores[n_pesquisadores++] = readerStr.nextLine();
				System.out.println("Usuário cadastrado!");
			}
			else if(option == 8)
				break;		
			System.out.println();
		}

		readerInt.close();
		readerStr.close();

	}

}
