package com.example.sephirot;

public class Sephira {

    private String name;
    private String description;
    private int imageResourceId;




    //Sephira é uma esfera da Árvore da Vida

    public static final Sephira[] sephiraLibrary = {
            new Sephira("KETHER",
                "Número 1\n" + "Hierarquia dos Serafins. Número próximo a Deus. Potencialidade de despertar deuses.\n" +
                        "Desenvolvimento filosófico e espiritual é essencial para sua evolução. (Nilton Schutz)\n" +
                        "\n" +
                        "Desenvolver a independência. Reger a vida de acordo consigo mesmo. Geralmente são pessoas dependentes e precisam desenvolver o direcionamento de suas vidas. Coragem de fazer coisas novas. Coragem de ser líder. São pessoas determinadas.\n" +
                        "Profissão: Gosta de novos desafios. Pessoa idealista que gosta de iniciar mas não leva as coisas adiante. Com pressa no resultado desiste muitas vezes e volta para a idealização. Preciso buscar um número de equilíbrio como o 8.\n",
                R.drawable.kether),
            new Sephira("CHOKMAH",
                   "Número 2\n" +
                           "Hierarquia dos Querubins. Trabalhar a força da energia de modo amoroso e do compartilhamento.\n" +
                           "Realidade de uma parceria, diferente do um que é mais individual. (Nilton Schutz)\n" +
                           "\n" +
                           "Lição de vida para aprender a se relacionar com o outro. Aprender a ajudar o outro. Auxiliar do líder.\n" +
                           "Relacionamento de reciprocidade.\n" +
                           "Profissão: Diplomacia, apoia o crescimento do outro, secretária, serviçal, a quem o líder se apoia.",
                    R.drawable.chokmah),
            new Sephira("BINAH",
                    "Número 3\n" +
                            "Saturno. Hierarquia dos Tronos. Necessidade de ter um objetivo disciplinado para realização.\n" +
                            "Deve achar o caminho, principalmente com disciplina na parte profissional. No caso da aposentadoria,\n" +
                            "Vale pensar para onde está dirigindo essa energia. (Nilton Schutz)\n" +
                            "\n" +
                            "Número da comunicação. Lidar com muitas pessoas, com entretenimento e viagens.\n" +
                            "Fazer uma grande networking e trazer alegria para a vida dos outros.\n" +
                            "Profissão: Pessoa livre. Artistas, comunicadores, criativos e viajantes.\n",
                    R.drawable.binah),
            new Sephira("CHESED",
                    "Número 4\n" +
                            "Júpiter. Chesed. Hierarquia dos Domínios. Misericórdia.\n" +
                            "Necessidade de trabalhar a fraternidade, o altruísmo e a doação. Estender a mão em situações de\n" +
                            "Sofrimento. (Nilton Schutz)\n" +
                            "\n" +
                            "Aprender a organizar. Valoriza o trabalho e vai organizar sua vida e a dos outros. Capacidade de construção e de praticidade, que vai do início ao fim. Necessidade de aprendizado da organização da sua própria vida e do meio externo.\n" +
                            "Profissão: Pessoas administradoras e disciplinadas. Falta ousadia e jogo de cintura.\n",
                    R.drawable.chesed),
            new Sephira("GEBURAH",
                    "Número 5\n" +
                            "Regido por Marte. Geburah. Bravura, valentia de Deus. Potestades.\n" +
                            "Pessoas que vêm para correr e perseverar. Desenvolver o poder da bravura, coragem e conquista.\n" +
                            "Aprender a cortar o que não serve em relação à sua vida. Cuidado com o medo, apego e dependência. (Nilton Schutz)\n" +
                            "\n" +
                            "Aprender a lidar com mudanças. Provocar e aceitar as mudanças que o destino condiciona.\n" +
                            "Pessoa cheia de ideias e criativa. Precisa aprender a arriscar, promover o progresso e fazer coisas diferentes.\n" +
                            "Lição de aprendizado do dinamismo, ter vários interesses, e capacidade de adaptação às mudanças o tempo todo.\n" +
                            "Profissão: Criativa no pensamento. Pode se dar bem na maioria das profissões. Número da estrela de 5 pontas.",
                    R.drawable.geburah),
            new Sephira("TIPHERET",
                    "Número 6\n" +
                            "\n" +
                            "Sol. Tifereth. A beleza de Deus. Brilho e criatividade. Hierarquia das virtudes.\n" +
                            "O verdadeiro brilho é aquele que vem de você mesmo. Sem copiar os outros ou depender dos outros para brilhar. (Nilton Schutz)\n" +
                            "\n" +
                            "Lição de vida para ajudar os outros. Responsável pela família, busca solucionar o problema dos outros e justiça.\n" +
                            "Profissão: Enfermeiros e médicos. Pessoas belas, esteticistas, arquitetos, músicos, artesãos. Harmonia e cuidado.\n" +
                            "\n" +
                            "IMPORTANTE: Verificar se deu o número 33 que é um número de sacrifício, difícil de ser seguido, por isso usa-se o 6",
                    R.drawable.tiphareth),
            new Sephira("NETSZACH",
                    "Número 7\n" +
                            "Vênus. Netzach. Hierarquia dos Principados. Afrodite\n" +
                            "Associar-se à pessoas em situações corretas. Parcerias que valham a pena te fazem crescer.\n" +
                            "Evitar pessoas que o reduzem e não acrescentam nada à sua vida.(Nilton Schutz)\n" +
                            "\n" +
                            "Pessoa questionadora. Exigente consigo, detalhista e exigente. É um número de busca e respostas. Geralmente são pessoas pesquisadoras. Gostam de muitos assuntos. Enorme capacidade de observação e resolvem todos os problemas.\n" +
                            "Profissão: Pode se especializar em assuntos. Gosta de estudar. De cultivo de orquídeas ao conhecimento de novas tecnologias são interesses do número 7.\n",
                    R.drawable.netzach),
            new Sephira("HOD",
                    "Número 8\n" +
                            "Hod. Mercúrio. Hierarquia dos Arcanjos. Esplendor de Deus.\n" +
                            "Inteligência que deve ser colocada em prática no dia-a-dia. Comércio, negociações e desenvolvimento do conhecimento.\n" +
                            "Sentido do rigor está na aplicação do conhecimento. Você possui prazer em viver o cotidiano ou não consegue aceitar o sistema que está inserido? (Nilton Schutz)\n" +
                            "\n" +
                            "Aprender a valorizar a si mesmo. Saber que tem poder e com isso tornar-se empreendedora.\n" +
                            "Lidar com o próprio poder e com os negócios. Pessoas que tiveram na família de origem alguém muito forte, dificultando que a pessoa reconhecesse o próprio poder.\n" +
                            "Profissão: Múltiplo do 4. Estrategista, ambicioso, faz o negócio expandir. São bons gerenciadores, executivos e empreendedores.",
                    R.drawable.hod),
            new Sephira("YESOD",
                    "Número 9\n" +
                            "Lua. Hierarquia dos Anjos.\n" +
                            "Aceitação do meio em que se está inserido. Lua é passado, podendo se aprisionar, não aceitando a família ou meio que está inserido. Insegurança emocional. A sua força particular advém da aceitação da sua hereditariedade. Em vez de conjugar o verbo\n" +
                            "No passado deve buscar aprender com ele e realizar no presente. (Nilton Schutz)\n" +
                            "\n" +
                            "Aprender a olhar pro mundo. Muitos jornalistas são 9. Têm a necessidade de cuidar do mundo, viajar e aprender.\n" +
                            "Necessidade de olhar para fora. Empatia com os outros. Escrevem, Ongs, trabalhos voluntários.\n" +
                            "Aprender a desapegar e a sair de si mesma para ter compaixão às outras pessoas.\n",
                    R.drawable.yesod),
            new Sephira("MALKUT",
                    "Número 10\n" +
                            "Malkut retorna para a Coroa (Keter)",
                    R.drawable.malkuth),
            new Sephira("DAAT",
                    "Número 11 (número mestre, 22, 33)\n" +
                            "Compromisso com a vida dos outros. Lição de vida voltada para o aprendizado de relacionamento.\n" +
                            "Capacidade de trazer luz par a vida das pessoas. Antes de trazer luz e influenciar deve aprender a se relacionar.",
                    R.drawable.daath)
    };

    // Constructor
    public Sephira(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }




}
