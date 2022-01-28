package TrabalhoPratico01;

//import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class JogoDaForca {

	//variável global
	
	//array criado com tamanho já definido
	
	//o array de colunas deve obter 51 setores
	static String[][] temasPalavras = new String[50][51];
	
	static int contador = 0;
	static int contadorP = 1;
	
	//guarda o id da matriz 50 50 junto com os valores que foram iniciados
	// a linha guarda o id e a coluna guarda o valor de variaveis impostas no array temasPalavras
	static int[][] id = new int [50][51];
	static int[] TemaPalavraExcluida = new int[100];
	static int[] PalavraExcluida = new int[100];
	
	static int[] contExcluido = new int[100];
	static int contadorExclui = 0;
	
	 public static void menu(){
	        System.out.println("Jogo da forca");
	        System.out.println("1. Gerenciar temas");
	        System.out.println("2. Gerenciar palavras");
	        System.out.println("3. Jogar");
	        System.out.println("4. Sair");
	        System.out.println("Escolha uma das opções apresentadas acima:");
	    }

	    public static void gerenciarTemasOption_A(){
	    	
//	    	//array com 50 linhas e 1 coluna
//    		temasPalavras = new String[6][1];
    		
    		//entrada do scanner
    		Scanner entrada = new Scanner(System.in);
    		String entradaTemas;
    		
    		//conta temas
    		System.out.println("Determine quantos temas serão alocados neste momento :");
    		int contaTemas = 0;
    		contaTemas = entrada.nextInt();
    		System.out.println("");
    		
    			do {
    				
    				if(contadorExclui >= 1) {
    					int i=0;
    					
    					if(contadorExclui == 1) {
    						System.out.println("devido "+ contadorExclui + " tema ter sido excluido, por favor insira mais " + 
    								  contadorExclui  +" outro tema.");
    					}else{
    						System.out.println("devido "+ contadorExclui + " temas terem sido excluidos, por favor insira mais "
    		    					+ contadorExclui  +" outros temas.");
    					}
    					
    					do{ 
    						
    						//para a primeira coluna
    	    				entradaTemas = entrada.next(); 
    						temasPalavras[contExcluido[i]][0] = entradaTemas; 
    						
    						i++;
    					}while(i<contadorExclui);
    					
    					 //restabelece o valor original
    					contadorExclui = 0;
    					i=0;
    					
    				}
    				
    				System.out.println("Escreva o seu tema: ");
    				//para a primeira coluna
    				entradaTemas = entrada.next();
    				
    				temasPalavras[contador][0] = entradaTemas;   				
    				
    				//AINDA APRESENTA ERROS DE AO FRISAR BOTAR TEMA JA EXISTENTE				
//    				if(contador >= 1) {
//    					System.out.println("entrou aquiiii");
//
//    					if(temasPalavras[contador][0].equals(temasPalavras[contador-1][0])) {
//    					System.out.println("esse "+ temasPalavras[contador][0] +" tema já existe");
//    					System.out.println("imponha outro tema: ");
//    					
//    					temasPalavras[contador][0] = (entradaTemas = entrada.next());
//    					}
//    					
//    					
//    				}
    				
    				contador++;
    				contaTemas--;
    				
    			}while(contaTemas != 0);
    			  			
    			//passa o array para o método
//    			gerenciarPalavras(temas);
//    			gerenciarTemasOption_C(temas);
    			
    			
    			//passa o array para o método
//    			armazenaTemas(temas);
    			
    			//retorna para o if(a) da main o valor do temas
    			//return temas;
    			
    			System.out.println("");
	       
	    }
	    
	    public static void gerenciarTemasOption_B(){
	        
	        Scanner entradaBD = new Scanner(System.in);
    		String entradaD;
	        
    		System.out.println("Insira o tema a ser excluido aqui: ");
 	        entradaD = entradaBD.nextLine();
 	        
 	       for(int cont=0; cont<50; cont++) {
 	    		
 	    		if(entradaD.equals(temasPalavras[cont][0])) {
 	    			System.out.println("O tema "+ temasPalavras[cont][0] +" foi excluído. ");
 	    			temasPalavras[cont][0] = null;
 	    			
 	    			contExcluido[contadorExclui] = cont;
 	    
 	    			contadorExclui ++;
 	    			
 	    			//ao achar o tema e exclui-lo, sai do loop.
 	    			break;
 	    		}
 	       }
	        
 	      System.out.println("");
	    }
	    
	    public static void gerenciarTemasOption_C(){
	        
	        Scanner entradaCB = new Scanner(System.in);
    		String entradaC;
    		int valor = 0;
    		
	        System.out.println("Insira o tema buscado aqui: ");
	        entradaC = entradaCB.nextLine();
	        System.out.println("");
    		
    		for(int cont=0; cont<50; cont++) {
    		
    		if(entradaC.equals(temasPalavras[cont][0])) {
    			System.out.println("Existe o tema : " + temasPalavras[cont][0]+" no sistema");
    			//o contador "valor" soma 1 ao achar um tema no sistema
    			valor ++;
    			
    			//ao achar o tema sai do loop
    			break;
    		}
    		
    		}
    		
    		if(valor == 0) {
    			System.out.println("Nenhum tema encontrado no sistema, sinto muito");
    		}
    		
    		System.out.println("");
	    }
	    
//	    ===========================GERENCIAR PALAVRAS===================================
	    
	    public static void gerenciarPalavrasOption_A(){
    		
    		//entrada do scanner
    		Scanner entrada = new Scanner(System.in);
    		String entradaPalavras_A;
    		
    		//verificar o tema que a palavra vai entrar
    		System.out.println("Indique o tema que a palavra vai ser imposta :");
    		entradaPalavras_A = entrada.next();
    		System.out.println("\n");
    		
    		int valor = 0;
    		int cont = 0;
    		
    		for(int CONT=0; CONT<50; CONT++) {
        		if(entradaPalavras_A.equals(temasPalavras[CONT][0])) {

        			//o contador "valor" soma 1 ao achar um tema no sistema
        			valor ++;
        			cont = CONT;
        			
        			
        			//ao achar o tema sai do loop
        			break;
        		}
        		
        	}
        		
        		if(valor == 0) {
        			System.out.println("Nenhum tema encontrado no sistema, sinto muito");
        			
        		}
        		
        			//conta palavras
            		System.out.println("Determine quantas palavras serão alocadas neste momento :");
            		
            		int contaPalavras = 0;
            		contaPalavras = entrada.nextInt();
            		System.out.println("");
        		
    			
    			do {
    				
//    				if(contadorExclui >= 1) {
//    					int i=0;
//    					
//    					if(contadorExclui == 1) {
//    						System.out.println("devido "+ contadorExclui + " tema ter sido excluido, por favor insira mais " + 
//    								  contadorExclui  +" outro tema.");
//    					}else{
//    						System.out.println("devido "+ contadorExclui + " temas terem sido excluidos, por favor insira mais "
//    		    					+ contadorExclui  +" outros temas.");
//    					}
//    					
//    					do{ 
//    						
//    						System.out.println("os array excluidos foram :" + contExcluido[i]);
//    						
//    						//para a primeira coluna
//    	    				entradaTemas = entrada.next(); 
//    						temasPalavras[contExcluido[i]][0] = entradaTemas; 
//    						
//    						i++;
//    					}while(i<contadorExclui);
//    					
//    					 //restabelece o valor original
//    					contadorExclui = 0;
//    					i=0;
//    					
//    				}
    				
    				
    				//para a primeira coluna
    				//for(int i=0; i<contaPalavras; i++) {
    					System.out.println("Escreva a sua palavra: ");
    					entradaPalavras_A = entrada.next();
    				
    				//ou seja, obtiver valor guardado
    				if(id[cont][1] != 0) {
    					temasPalavras[cont][id[cont][1]] = entradaPalavras_A; 
    	    			id[cont][1] =id[cont][1] + contadorP;
    				}else {
    					
        				temasPalavras[cont][contadorP] = entradaPalavras_A; 
        				
    				}
        				
        			//}
    				
        			contadorP++;
    				contaPalavras --;
    				
    			}while(contaPalavras != 0);
    			
    			//a linha identifica o id do (temas)Palavras e a coluna impõe quantas palavras ja foram impostas nele
    			//int guardaValor = guardaValor + contadorP;
    			if(id[cont][1] == 0) {
    				id[cont][1] = contadorP;				
    			}
				
				//reinicia o contador
				contadorP = 1;
				System.out.println("");
	    }
	    
	    public static void gerenciarPalavrasOption_B(){
	        
	        Scanner entradaBD = new Scanner(System.in);
    		String entradaD;
    		
    		//verificar o tema que a palavra vai ter a palavra deletada
    		System.out.println("Indique o tema que a palavra vai ser deletada : ");
    		entradaD= entradaBD.next();
    		System.out.println("\n");
 	        
 	        int cont = 0;
 	        int i = 1;
 	        
 	       for(int CONT=0; CONT<50; CONT++) {
 	    			
 	    		if(entradaD.equals(temasPalavras[CONT][0])) {

 	    			//temasPalavras[CONT][0] = null;
 	    			
 	    			cont = CONT;
 	    			
 	    			
 	    			System.out.println("Insira a palavra a ser excluida aqui: ");
 	    	        entradaD = entradaBD.next();
 	    	   
 	    			
 	    			for(i=1; i<id[cont][1]; i++) {
 	    				
// 	    				System.out.println("valor cont "+ cont);
// 	    				System.out.println("entrou no for ");
// 	    				System.out.println("id  " + id[cont][1]);
// 	    				System.out.println("i === " + i);
 	    				
 	    			if(entradaD.equals(temasPalavras[cont][i])) {
 	    				System.out.println("A palavra "+ temasPalavras[cont][i] +" foi excluída. ");
 	    				
 	    				int contadorT = cont;
 	    				int contadorPalavras = i;
 	    				
 	 	    			temasPalavras[cont][i] = null;
 	 	    			
 	 	    			
 	    			}
 	    			
 	    			}
 	    			
// 	    			contExcluido[contadorExclui] = cont;
// 	    			System.out.println(contExcluido[contadorExclui] + " " + contadorExclui);
// 	    			contadorExclui ++;
// 	    			
// 	    			System.out.println(contExcluido[contadorExclui] + "depoiss " + contadorExclui);
 	    			
 	    			//ao achar o tema e exclui-lo, sai do loop.
// 	    			break;
 	    		}
 	       }
 	    
 	      System.out.println("");
 	       
	    }
	    
	    public static void gerenciarPalavrasOption_C(){
	    	
	    	Scanner entradaCB = new Scanner(System.in);
	    	String entradaC;
	    	
	    	System.out.println("Indique a palavra a ser buscada nos temas : ");
    		entradaC= entradaCB.next();
	    	System.out.println("\n");
    		
	    	for(int i=0; i<50; i++) {
	    		for(int cont=1; cont<51; cont++) {
	    		
	    		if(entradaC.equals(temasPalavras[i][cont])) {
	    			System.out.println("A palavra ("+ temasPalavras[i][cont] +") foi achada no tema : "+ temasPalavras[i][0] + "\n");
	    		}
	    		
	    	}   	
	    		
	     }
	    
	    	System.out.println("");
	  }
	    
	    public static void gerenciarPalavrasOption_D(){
	        
	      //entrada do scanner
    		Scanner entrada = new Scanner(System.in);
    		String entradaPalavras_D;
    		
    		//verificar o tema que a palavra vai entrar
    		System.out.println("Indique o tema pra ver todas as suas palavras guardadas:");
    		entradaPalavras_D = entrada.next();
	        
	        for(int cont=0; cont<50; cont++) {
	    		
	    		if(entradaPalavras_D.equals(temasPalavras[cont][0])) {
	    			System.out.println("Tema : " + temasPalavras[cont][0]);
	    			//o contador "valor" soma 1 ao achar um tema no sistema
	    			
	    			System.out.println("Palavras cadastradas:");
	    			
	    			for(int i=1; i<id[cont][1]; i++) {
	    				System.out.println(temasPalavras[cont][i]);
	    				
		    		if(temasPalavras[cont][i] == null) {	
		    		}else {
		    			
		    		}
		    		
	    		}
	    			
	    			//ao achar o tema sai do loop
	    			break;
	    		}
	        }
	        System.out.println("");
	       
	    }
	    
//	    <//////////////////////////////GERENCIAR PALAVRAS///////////////////////////////////>
	    
	    
	    public static void jogar(){
	        
	        //impõe o gerador de numeros aleatórios 
	        Random geradorAleatorio = new Random();
	        int contadorAleatorio;
	        
	        //entrada do scanner
    		Scanner entrada = new Scanner(System.in);
    		String entradaJ;
    		char entradachar;
    		String nulo = "null";
    		
    		System.out.println("Selecione um tema para jogar:");
    		entradaJ = entrada.next();
    		System.out.println("");
	       
    		for(int cont=0; cont<50; cont++) {
	    		
    			if(entradaJ.equals(temasPalavras[cont][0])){
    				System.out.println("Tema escolhido : " + temasPalavras[cont][0]);
    				System.out.println("");
    				
    				//=============>permite colocar 5 numeros aleatorios sem contar com a palavra do tema por isso o mais +1
//		            System.out.println(temasPalavras[cont][geradorAleatorio.nextInt(4)+1]);
    				
    				
		            
		            do {
		            	//=============>permite colocar 5 (colocar 50) numeros aleatorios sem contar com a palavra do tema por isso o mais +1
		            	contadorAleatorio = geradorAleatorio.nextInt(50)+1;
		            	
		            }while(contadorAleatorio > (id[cont][1]) - 1);
    				
    				char[] ch = (temasPalavras[cont][contadorAleatorio]).toCharArray();
    				//impoe o tamanho da palavra aleatoria achada
    				int len = ch.length;
    				
    				int vida = 5;
    	    		
    	    		int[] idAcertadas = new int[len];
    	    		char[] letrasTentadas = new char[100];
    	    		int qtd = 0;
    	    		int acertos = 0;
    	    		int contletras = 0;
    	    		int parada = 0;
    	    		
    	    		while(parada < len) {
    	    			
    	    		System.out.println("Selecione uma letra para jogar:");
    	    		entradachar = entrada.next().charAt(0);
    	    		
    	    		letrasTentadas[contletras] = entradachar;
    	    		
    	    		if(contletras >= 1) {
    	    		for(int x=0; x<contletras; x++) {
        			if(letrasTentadas[x] == entradachar) {
        				System.out.println("Você já tentou essa letra : "+ entradachar);
        				System.out.println("Por favor coloque outra letra.");
        				entradachar = entrada.next().charAt(0);
        			}
    	    		
    	    		}//for cont letras
    	    		
    	    	}//if cont letras
    	    		
    	    		contletras++;
    	    		
    	    		for(int i=0; i<len; i++) {
    	    			
    	    		if(entradachar == ch[i]) {
    	    			
    	    			qtd++;
    	    			idAcertadas[i] = qtd; 
    	    			
    	    			for(int k=i+1; k<len; k++) {
    	    				if(entradachar == ch[k]) {
    	    					qtd++;
    	    					
    	    	    			idAcertadas[k] = qtd; 
    	    	    			qtd--;
    	    				}
    	    			}
    	    			
    	    			
    	    			
    	    		}
    	    		
    	    	}//for1
    	    		
    	    		if(qtd > 0) {
    	    			
    	    			parada = parada + qtd;
    	    			
    	    			System.out.println("letras acertadas :");
    	    			for(int i=0; i<len; i++) {
    	    				if(idAcertadas[i] != 0) {
    	    					System.out.print(" " +ch[i]+" ");
    	    					acertos++;
    	    				}else {
    	    					System.out.print(" _ ");
    	    				}
    	    			}
    	    		}else if(qtd == 0) {
    	    			
    	    			for(int i=0; i<len; i++) {
    	    				if(idAcertadas[i] != 0) {
    	    					System.out.print(" "+ch[i]+" ");
    	    					acertos++;
    	    				}else {
    	    					System.out.print(" _ ");
    	    				}
    	    			}
    	    			
    	    			vida--;
    	    			
    	    		}
    	    		qtd = 0;
    	    		System.out.println("\n\n Vidas :" + vida);
    	    		System.out.println("");
    	    		
    	    		if(vida == 0) {
    	    			break;
    	    		}
    	    	
    	    }//while
    	    		System.out.println("");
    	    		
    	    		if(vida==0) {
	    				System.out.println("Você perdeu! Deseja jogar novamente? ");
	    			}else {
	    				System.out.println("Parabéns!\n" + 
	    									"Você acertou a palavra! Deseja jogar novamente? ");
	    			}
    	    		
    	    		System.out.println("");
    		      
    			}
    		
    		}
	        
	    }
	    
	    public static void sair(){
	        System.out.println("O jogo foi encerrado");
	    }
	    
		public static void main(String[] args) {
	        int opcao;
	        Scanner entrada = new Scanner(System.in);
	        
	        
	        do{
	        	//chama o método menu
	            menu();
	            opcao = entrada.nextInt();
	            System.out.println("");
	            
	            switch(opcao){
	            
	            case 1:
	            	
	            	System.out.println("Escolha uma das opções a seguir:");
	            	System.out.println("a) Cadastrar");
	            	System.out.println("b) Excluir");
	            	System.out.println("c) Buscar");
	            	
	            	char input1;
	            	input1 = entrada.next().charAt(0);
	            	System.out.println("");
	            	
	            	if(input1 == 'a') {
	            		
	            		//chama o método de cadastro
	            		gerenciarTemasOption_A();
	            	
	            		
	            		//retorna do método os temas e passa o vetor String[]
//	            		String[] temas = gerenciarTemasOption_A();
//	            		 System.out.println(temas[0]);
	            		            		
	            	}else if(input1 == 'b') {
	            		
	            		gerenciarTemasOption_B();
	            		
//	            		armazenaTemas();
//	            		String[] tem = new String[3];
//	            		tem = armazenaTemas(temas);
//	            		gerenciarPalavras(tem);
	            		
	            	}else if(input1 == 'c') {
	            		
	            		//chama o método de busca
	            		gerenciarTemasOption_C();
	            		
	            	}
	            	
	                break;
	                
	            case 2:
	            		
	            	System.out.println("Escolha uma das opções a seguir:");
	            	System.out.println("a) Cadastrar");
	            	System.out.println("b) Excluir");
	            	System.out.println("c) Buscar");
	            	System.out.println("d) Listar");
	            	
	            	char input2;
	            	input2 = entrada.next().charAt(0);
	            	System.out.println("");
	            	
	            	if(input2 == 'a') {
	            		
	            		//chama o método de cadastro
	            		gerenciarPalavrasOption_A();
	            		           		
	            	}else if(input2 == 'b') {
	            		
	            		gerenciarPalavrasOption_B();
	            		
	            	}else if(input2 == 'c') {
	            		
	            		gerenciarPalavrasOption_C();
	            		
	            	}else if(input2 == 'd') {
	            		
	            		gerenciarPalavrasOption_D();
	            		
	            	}
	            	
	                break; 
	                
	            case 3:
	            	jogar();
	                break;
	                
	            case 4:
	                sair();
	                break;
				default:
	                System.out.println("Opção inválida, por favor escolha uma opçao valida");
	            }
	        } while(opcao != 4);
	    }

}
