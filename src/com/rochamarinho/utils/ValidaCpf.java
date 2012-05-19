package com.rochamarinho.utils;

/**
 *
 * @author marlosouza
 */
public class ValidaCpf {
      
    public ValidaCpf() {    
          
    }    
      
    public boolean isCpf(String cpf) {  
    int sm, i, r, num;  
    char dig10, dig11;  
// calcula o 1o. digito verificador do CPF  
    sm = 0;  
    for (i=0; i<9; i++) {  
      num = (int)cpf.charAt(i) - 48; // por exemplo: transforma o caracter '0' no inteiro 0  
                                  // (48 eh a posição de '0' na tabela ASCII)  
      sm = sm + (num * (10 - i));  
    }  
    r = 11 - (sm % 11);  
    if ((r == 10) || (r == 11))  
       dig10 = '0';  
    else  
       dig10 = (char)(r + 48);  
   
// calcula o 2o. digito verificador do CPF  
    sm = 0;  
    for (i=0; i<10; i++) {  
      num = (int)cpf.charAt(i) - 48;  
      sm = sm + (num * (11 - i));  
    }  
    r = 11 - (sm % 11);  
    if ((r == 10) || (r == 11))  
       dig11 = '0';  
    else  
       dig11 = (char)(r + 48);  
   
// compara os dígitos calculados com os dígitos informados  
    if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))  
       return(true);  
    else  
       return(false);  
  }  
    
}
