import java.util.LinkedList;
import java.util.Queue;

class Aluno {
    String matricula;
    String nome;
    String curso;

    public Aluno(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }
}

class Professor {
    String siape;
    String nome;
    String titulacao;

    public Professor(String siape, String nome, String titulacao) {
        this.siape = siape;
        this.nome = nome;
        this.titulacao = titulacao;
    }
}

class Tecnico {
    String siape;
    String nome;

    public Tecnico(String siape, String nome) {
        this.siape = siape;
        this.nome = nome;
    }
}

class FilaRefeitorio {
    Queue<Object> fila = new LinkedList<>();

    public void entrarNaFila(Object pessoa) {
        fila.add(pessoa);
    }

    public Object sairDaFila() {
        return fila.poll();
    }
}

public class Main {
    public static void main(String[] args) {
        FilaRefeitorio filaRefeitorio = new FilaRefeitorio();

        Aluno aluno1 = new Aluno("2023001", "João", "Engenharia Civil");
        Professor professor1 = new Professor("123456", "Maria", "Doutorado em Física");
        Tecnico tecnico1 = new Tecnico("98765", "José");

        filaRefeitorio.entrarNaFila(aluno1);
        filaRefeitorio.entrarNaFila(professor1);
        filaRefeitorio.entrarNaFila(tecnico1);

        System.out.println("Fila do refeitório:");
        for (Object pessoa : filaRefeitorio.fila) {
            if (pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;
                System.out.println("Aluno: " + aluno.nome + ", Matrícula: " + aluno.matricula + ", Curso: " + aluno.curso);
            } else if (pessoa instanceof Professor) {
                Professor professor = (Professor) pessoa;
                System.out.println("Professor: " + professor.nome + ", SIAPE: " + professor.siape + ", Titulação: " + professor.titulacao);
            } else if (pessoa instanceof Tecnico) {
                Tecnico tecnico = (Tecnico) pessoa;
                System.out.println("Técnico: " + tecnico.nome + ", SIAPE: " + tecnico.siape);
            }
        }

        System.out.println("\nAtendendo próxima pessoa:");
        Object pessoaAtendida = filaRefeitorio.sairDaFila();
        if (pessoaAtendida != null) {
            if (pessoaAtendida instanceof Aluno) {
                Aluno aluno = (Aluno) pessoaAtendida;
                System.out.println("Atendendo Aluno: " + aluno.nome);
            } else if (pessoaAtendida instanceof Professor) {
                Professor professor = (Professor) pessoaAtendida;
                System.out.println("Atendendo Professor: " + professor.nome);
            } else if (pessoaAtendida instanceof Tecnico) {
                Tecnico tecnico = (Tecnico) pessoaAtendida;
                System.out.println("Atendendo Técnico: " + tecnico.nome);
            }
        } else {
            System.out.println("A fila está vazia.");
        }
    }
}
