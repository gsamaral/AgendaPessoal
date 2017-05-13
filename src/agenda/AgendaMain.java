//package agenda;
//
//import java.util.Calendar;
//import java.util.List;
//
//public class AgendaMain {
//
//	public static void main(String[] args) {
//		
//		TarefaSQL tarefasql = new TarefaSQL();
//
//	    List<AgendaPessoal> tarefas = tarefasql.getLista();
//
//	    for (AgendaPessoal tarefa : tarefas) {
//	    	System.out.println("Nome: "+tarefa.getNomeTarefa());
//	        System.out.println("Categoria: " + tarefa.getCategoria());
//	        System.out.println("Status: " + tarefa.getStatus());
//	        System.out.println("Id: "+tarefa.getId());
//	    }
//	        
//	    Calendar c = Calendar.getInstance();
//		
//		System.out.println("Data/Hora atual: "+c.get(Calendar.HOUR_OF_DAY));
//		System.out.println("Ano: "+c.get(Calendar.YEAR));
//		System.out.println("Mês: "+c.get(Calendar.MONTH));
//		System.out.println("Dia do Mês: "+c.get(Calendar.DAY_OF_MONTH));
//
//	    
//		
//
////		System.out.println("Conexão aberta!");
////
////		AgendaPessoal tarefa1 = new AgendaPessoal();
////
////		tarefa1.setNomeTarefa("festa");
////		tarefa1.setCategoria("top");
////		tarefa1.setStatus("realizado");
////
////		TarefaSQL tarefaadd = new TarefaSQL();
////		tarefaadd.Inserir(tarefa1);
////		tarefaadd.Excluir(1);
//
//	}
//
//}
