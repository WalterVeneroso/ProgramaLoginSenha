import java.util.Arrays;
import java.util.Scanner;

public class ProgramaLoginSenha {
    public static void main(String[] args) {

        /// Variaveis
        String nomeCompleto = new String();
        String primeiraLetraDoNome = new String();
        String ultimoNome = new String();
        String login = new String();
        Scanner scan = new Scanner(System.in);
        String senha = new String();

        String usuarioParaAcessar = new String();
        String senhaParaAcessar = new String();

        ///****************

        //1. Gerar usuario pelo nome
        System.out.println("Digite seu nome completo!"); //Pede o nome na tela
        nomeCompleto = scan.nextLine(); //Salva o nome digitado dentro da variavel nomeCompleto
        //System.out.println("nome completo digitado: " + nomeCompleto);
        //Precisamos gerar o login
        //primeiraLetraDoNome + "_" + ultimoNome
        primeiraLetraDoNome = nomeCompleto.substring(0,1); //Pegando o primeiro caracter
        //System.out.println("primeira letra: " + primeiraLetraDoNome);
        //Separar os nomes
        String[] nomeSeparado = nomeCompleto.split(" "); // Separando o nome pelos espaços
        int comprimentoNome = nomeSeparado.length; //Descobrindo a quantidade de nomes digitados
        ultimoNome = nomeSeparado[comprimentoNome-1]; //Pegando o ultimo nome digitado
        //System.out.println("o ultimo nome digitado foi: "+ ultimoNome);

        login = primeiraLetraDoNome + "_" + ultimoNome;
        System.out.println("Seu login de acesso é : "+login);

        // 2. Cadastrar um senha seguindo as seguintes regras
        //no mínimo 8 caracteres contendo letras pelo menos
        //1 letra maiúscula
        //1 letra minúscula
        //números
        //1 caractere especial

        System.out.println("Agora iremos cadastrar sua senha!\nA senha cadastrada deve ter no mínimo 8 dígitos, contendo letras (pelo menos uma maiuscula e uma minuscula), números e caracteres especiais! \nDigite sua senha!");
        senha = scan.nextLine();

        if(senha.length() >= 8){ //Verifica se o tamanho da senha tem o tamanha minimo
            // Variaveis para validar as condicoes de uma senha
            boolean maiusculaCheck = false;
            boolean minusculaCheck = false;
            boolean numeroCheck = false;
            boolean caracterEspecialCheck = false;

            for(int i=0;i < senha.length();i++) {//Percorreremos letra por letra da senha
                char letra = senha.charAt(i); //converte a letra atual em char
                if(Character.isDigit(letra)){ //Verifica se é numero
                    numeroCheck = true; //Se for, muda o check para Verdadeiro
                } else if (Character.isUpperCase(letra)) { //Verfica se é letra maiuscula
                    maiusculaCheck = true; //Se for, muda o check para verdadeiro
                } else if (Character.isLowerCase(letra)){//Verifica se é letra minuscula
                    minusculaCheck = true;//se for altera o check para verdadeiro
                } else if (letra == '-' || letra == '!'  || letra == '@') { //verifica se é um dos caracteres especiais aceitaveis
                    caracterEspecialCheck = true;//se for altera o check para verdadeiro
                }
            }

            if(maiusculaCheck && minusculaCheck && numeroCheck && caracterEspecialCheck){ //Se todos os requisitos forem verdadeiros
                System.out.println("Senha cadastrada com sucesso!"); //cadastra a senha
            }else{
                System.out.println("A senha não contém pelo menos um dos critérios:\nPelo menos 1 letra Maiuscula\nPelo menos 1 letra Minuscula\nPelo menos 1 numero\nPelo menos 1 caracter Especial.\nTente novamente!");
                senha = null;
            }


        }else{
            System.out.println("A senha digitada não tem 8 dígitos. Tente novamente!");
            senha = null;
        }

        System.out.println("Para acessar, primeiro digite o usuario:");
        usuarioParaAcessar = scan.nextLine();

        if(usuarioParaAcessar.equals(login)){
            System.out.println("Qual a senha?");
            senhaParaAcessar = scan.next();
            if(senhaParaAcessar.equals(senha)){
                System.out.println("Usuario logado com sucesso!");
            }else{
                System.out.println("Senha Incorreta!");
            }
        }else{
            System.out.println("O usuário digitado, não confere!");
        }


    }

}
