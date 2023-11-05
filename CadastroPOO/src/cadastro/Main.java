package cadastro;

import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();

        while (true) {
            System.out.println("===========================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("===========================");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("F - Pessoa Fisica | J - Pessoa Juridica: ");
                    String tipo = scanner.nextLine().toUpperCase();

                    if (tipo.equals("F")) {
                        System.out.print("Digite o Id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();

                        PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                        repoPessoaFisica.inserir(pessoaFisica);
                        System.out.println("Pessoa Física incluída com sucesso.");
                    } else if (tipo.equals("J")) {
                        System.out.print("Digite o Id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();

                        PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
                        repoPessoaJuridica.inserir(pessoaJuridica);
                        System.out.println("Pessoa Jurídica incluída com sucesso.");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.print("F - Pessoa Fisica | J - Pessoa Juridica: ");
                    String tipoAlteracao = scanner.nextLine().toUpperCase();

                    if (tipoAlteracao.equals("F")) {
                        System.out.print("Digite o Id da pessoa a ser alterada: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        PessoaFisica pessoaFisicaExistente = repoPessoaFisica.obter(id);
                        if (pessoaFisicaExistente == null) {
                            System.out.println("Pessoa Física não encontrada.");
                        } else {
                            System.out.println("Dados atuais da Pessoa Física:");
                            System.out.println(pessoaFisicaExistente.toString());

                            System.out.print("Novo nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("Novo CPF: ");
                            String novoCpf = scanner.nextLine();
                            System.out.print("Nova idade: ");
                            int novaIdade = scanner.nextInt();
                            scanner.nextLine();

                            pessoaFisicaExistente.setNome(novoNome);
                            pessoaFisicaExistente.setCpf(novoCpf);
                            pessoaFisicaExistente.setIdade(novaIdade);

                            System.out.println("Pessoa Física alterada com sucesso.");
                        }
                    } else if (tipoAlteracao.equals("J")) {
                        System.out.print("Digite o Id da pessoa a ser alterada: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        PessoaJuridica pessoaJuridicaExistente = repoPessoaJuridica.obter(id);
                        if (pessoaJuridicaExistente == null) {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        } else {
                            System.out.println("Dados atuais da Pessoa Jurídica:");
                            System.out.println(pessoaJuridicaExistente.toString());

                            System.out.print("Novo nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("Novo CNPJ: ");
                            String novoCnpj = scanner.nextLine();

                            pessoaJuridicaExistente.setNome(novoNome);
                            pessoaJuridicaExistente.setCnpj(novoCnpj);

                            System.out.println("Pessoa Jurídica alterada com sucesso.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.print("F - Pessoa Fisica | J - Pessoa Juridica: ");
                    String tipoExclusao = scanner.nextLine().toUpperCase();

                    if (tipoExclusao.equals("F")) {
                        System.out.print("Digite o Id da pessoa a ser excluída: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        boolean removido = repoPessoaFisica.remover(id);
                        if (removido) {
                            System.out.println("Pessoa Física removida com sucesso.");
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipoExclusao.equals("J")) {
                        System.out.print("Digite o Id da pessoa a ser excluída: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        boolean removido = repoPessoaJuridica.remover(id);
                        if (removido) {
                            System.out.println("Pessoa Jurídica removida com sucesso.");
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 4:
                    System.out.print("F - Pessoa Fisica | J - Pessoa Juridica: ");
                    String tipoBusca = scanner.nextLine().toUpperCase();

                    if (tipoBusca.equals("F")) {
                        System.out.print("Digite o Id da pessoa a ser buscada: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        PessoaFisica pessoaFisicaBusca = repoPessoaFisica.obter(id);
                        if (pessoaFisicaBusca != null) {
                            System.out.println("Pessoa Física encontrada:");
                            System.out.println(pessoaFisicaBusca.toString());
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipoBusca.equals("J")) {
                        System.out.print("Digite o Id da pessoa a ser buscada: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        PessoaJuridica pessoaJuridicaBusca = repoPessoaJuridica.obter(id);
                        if (pessoaJuridicaBusca != null) {
                            System.out.println("Pessoa Jurídica encontrada:");
                            System.out.println(pessoaJuridicaBusca.toString());
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 5:
                    System.out.print("F - Pessoa Fisica | J - Pessoa Juridica: ");
                    String tipoExibicao = scanner.nextLine().toUpperCase();

                    if (tipoExibicao.equals("F")) {
                        System.out.println("Pessoas Físicas no Repositório:");
                        for (PessoaFisica pessoa : repoPessoaFisica.obterTodos()) {
                            System.out.println(pessoa.toString());
                        }
                    } else if (tipoExibicao.equals("J")) {
                        System.out.println("Pessoas Jurídicas no Repositório:");
                        for (PessoaJuridica pessoa : repoPessoaJuridica.obterTodos()) {
                            System.out.println(pessoa.toString());
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 6:
                    System.out.print("Digite o prefixo para os arquivos de persistência: ");
                    String prefixo = scanner.nextLine();
                    try {
                        repoPessoaFisica.persistir(prefixo + ".fisica.bin");
                        repoPessoaJuridica.persistir(prefixo + ".juridica.bin");
                        System.out.println("Dados persistidos com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao persistir os dados: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.print("Digite o prefixo para os arquivos de recuperação: ");
                    String prefixoRecuperacao = scanner.nextLine();
                    try {
                        repoPessoaFisica.recuperar(prefixoRecuperacao + ".fisica.bin");
                        repoPessoaJuridica.recuperar(prefixoRecuperacao + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Finalizando o programa.");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}