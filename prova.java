import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe base abstrata
abstract class Evento {
    private String nome;
    private String data;

    public Evento(String nome, String data) {
        this.nome = nome;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public abstract void detalhes();
}

// Classe Workshop
class Workshop extends Evento {
    private int maxParticipantes;
    private List<String> participantes;

    public Workshop(String nome, String data, int maxParticipantes) {
        super(nome, data);
        this.maxParticipantes = maxParticipantes;
        this.participantes = new ArrayList<>();
    }

    public boolean inscreverParticipante(String participante) {
        if (participantes.size() < maxParticipantes) {
            participantes.add(participante);
            System.out.println(participante + " inscrito no workshop.");
            return true;
        } else {
            System.out.println("O número máximo de participantes foi atingido.");
            return false;
        }
    }

    @Override
    public void detalhes() {
        System.out.println("Workshop: " + getNome() + " | Data: " + getData() + " | Participantes: " + participantes.size() + "/" + maxParticipantes);
    }
}

// Classe Reuniao
class Reuniao extends Evento {
    private boolean isPrivada;
    private String senha;

    public Reuniao(String nome, String data, boolean isPrivada, String senha) {
        super(nome, data);
        this.isPrivada = isPrivada;
        this.senha = isPrivada ? senha : null;
    }

    public boolean acessarReuniao(String senha) {
        if (isPrivada) {
            if (this.senha.equals(senha)) {
                System.out.println("Acesso à reunião privado permitido.");
                return true;
            } else {
                System.out.println("Senha incorreta.");
                return false;
            }
        } else {
            System.out.println("Reunião pública, acesso permitido.");
            return true;
        }
    }

    @Override
    public void detalhes() {
        System.out.println("Reunião: " + getNome() + " | Data: " + getData() + " | Tipo: " + (isPrivada ? "Privada" : "Pública"));
    }
}

// Classe Evento Corporativo
class EventoCorporativo extends Evento {
    private String ambienteReservado;

    public EventoCorporativo(String nome, String data, String ambienteReservado) {
        super(nome, data);
        this.ambienteReservado = ambienteReservado;
    }

    @Override
    public void detalhes() {
        System.out.println("Evento Corporativo: " + getNome() + " | Data: " + getData() + " | Ambiente: " + ambienteReservado);
    }
}

// Classe principal para executar o sistema
class SistemaDeEventos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Criação de um workshop
        Workshop workshop = new Workshop("Workshop Java", "12/09/2024", 30);
        workshop.inscreverParticipante("Ana");
        workshop.inscreverParticipante("Carlos");
        workshop.detalhes();
        
        // Criação de uma reunião
        Reuniao reuniaoPublica = new Reuniao("Reunião de Equipe", "13/09/2024", false, "");
        reuniaoPublica.detalhes();
        
        Reuniao reuniaoPrivada = new Reuniao("Reunião de Gerentes", "14/09/2024", true, "12345");
        System.out.print("Digite a senha para acessar a reunião privada: ");
        String senha = sc.nextLine();
        reuniaoPrivada.acessarReuniao(senha);
        reuniaoPrivada.detalhes();
        
        // Criação de um evento corporativo
        EventoCorporativo eventoCorporativo = new EventoCorporativo("Conferência Anual", "15/09/2024", "Sala de Conferências");
        eventoCorporativo.detalhes();
        
        sc.close();
    }
}