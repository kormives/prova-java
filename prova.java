class Dispositivo {
    private String problema;
    private int prazoMaximoDias;

    public Dispositivo(String problema, int prazoMaximoDias) {
        this.problema = problema;
        this.prazoMaximoDias = prazoMaximoDias;
    }

    public String getProblema() {
        return problema;
    }

    public int getPrazoMaximoDias() {
        return prazoMaximoDias;
    }
}

class Smartphone extends Dispositivo {
    public Smartphone(String problema) {
        super(problema, 3);
    }
}

class Notebook extends Dispositivo {
    public Notebook(String problema) {
        super(problema, 7);
    }
}

class Console extends Dispositivo {
    public Console(String problema) {
        super(problema, 10);
    }
}

class Tecnico {
    private String nome;
    private String especialidade;

    public Tecnico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }
}

class OrdemServico {
    private Dispositivo dispositivo;
    private Tecnico tecnico;
    private int custo;
    private boolean aprovado = false;
    private String status = "Orçamento não aprovado";

    public OrdemServico(Dispositivo dispositivo, Tecnico tecnico) {
        this.dispositivo = dispositivo;
        this.tecnico = tecnico;
    }

    public void diagnosticar() {
        if (dispositivo instanceof Smartphone) {
            this.custo = 300;
        } else if (dispositivo instanceof Notebook) {
            this.custo = 200;
        } else if (dispositivo instanceof Console) {
            this.custo = 400;
        }
    }

    public int getCusto() {
        return this.custo;
    }

    public boolean isAprovado() {
        return this.aprovado;
    }

    public void aprovarOrcamento() {
        this.aprovado = true;
        this.status = "Em reparo";
    }

    public Dispositivo getDispositivo() {
        return this.dispositivo;
    }

    public Tecnico getTecnico() {
        return this.tecnico;
    }

    public String getStatus() {
        return this.status;
    }
}
