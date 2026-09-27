package com.gustavo.mainapp.controller;

import com.gustavo.mainapp.cineticket.Sessao;
import com.gustavo.mainapp.cineticket.SessaoRepositorio;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainController {

    /**
     * Lista de sessões disponíveis para seleção na interface.
     */
    @FXML
    private ListView<Sessao> listaSessoes;

    /**
     * Área responsável por exibir os detalhes da sessão selecionada.
     */
    @FXML
    private TextArea areaDetalhes;

    /**
     * Campo utilizado para informar o nome do cliente.
     */
    @FXML
    private TextField campoNomeCliente;

    /**
     * Caixa de seleção utilizada para escolher a sala.
     */
    @FXML
    private ComboBox<String> comboSala;

    /**
     * Rótulo utilizado para exibir mensagens de status ao usuário.
     */
    @FXML
    private Label labelStatus;

    /**
     * Rótulo utilizado para informar qual sessão está selecionada.
     */
    @FXML
    private Label labelSessaoSelecionada;

    /**
     * Botão utilizado para realizar a reserva de um bilhete.
     */
    @FXML
    private Button botaoReservar;

    /**
     * Botão utilizado para cancelar uma operação ou reserva.
     */
    @FXML
    private Button botaoCancelar;

    /**
     * Componente responsável por exibir o cartaz do filme.
     */
    @FXML
    private ImageView cartazFilme;

    /**
     * Painel principal da interface da aplicação.
     */
    @FXML
    private BorderPane painelRaiz;

    /**
     * Lista contendo as sessões disponíveis no sistema.
     */
    private List<Sessao> sessoes;

    /**
     * Inicializa os componentes e os dados da tela após o carregamento do FXML.
     *
     * <p>Carrega as sessões armazenadas no repositório. Caso ocorra um erro
     * durante o carregamento, cria uma lista com sessões padrão e as adiciona
     * ao repositório.</p>
     *
     * <p>Também configura a lista de sessões, adiciona um listener para atualizar
     * os detalhes da sessão selecionada e seleciona automaticamente o primeiro
     * item da lista. Por fim, habilita o botão de reserva.</p>
     */
    @FXML
    public void initialize(){

        try{
            SessaoRepositorio.getInstance().carregarSessoes();
            sessoes = SessaoRepositorio.getInstance().getSessoes();
        }catch (IOException e){

            sessoes = new ArrayList<>();
            sessoes.add(new Sessao("Duna: Parte Três", "Sala 1",
                    LocalDateTime.of(2026, 9, 12, 19, 0)));
            sessoes.add(new Sessao("Viagem ao Fundo do Mar", "Sala 2",
                    LocalDateTime.of(2026, 9, 12, 16, 30)));

            SessaoRepositorio.getInstance().getSessoes().clear();
            SessaoRepositorio.getInstance().getSessoes().addAll(sessoes);
        }

        listaSessoes.getItems().setAll(sessoes);
        listaSessoes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){

                areaDetalhes.setText(newValue.getSala() + "\n" + newValue.getHorario());
                labelSessaoSelecionada.setText("Sessão selecionada: " + newValue.getFilme());
            }
        });

        listaSessoes.getSelectionModel().selectFirst();
        botaoReservar.setDisable(false);
    }

    /**
     * Realiza a reserva de um bilhete para a sessão selecionada.
     *
     * <p>Obtém o nome do cliente e a sessão selecionada na lista. Caso nenhuma
     * sessão tenha sido selecionada, uma mensagem de orientação é exibida.
     * A confirmação da reserva é executada em uma tarefa separada para evitar
     * o bloqueio da interface gráfica durante o processamento.</p>
     *
     * <p>Após a conclusão da tarefa, o {@link Platform#runLater(Runnable)} é
     * utilizado para atualizar os componentes da interface JavaFX com os
     * detalhes da reserva.</p>
     *
     * @param evento evento responsável por acionar a reserva do bilhete
     */
    @FXML
    private void reservarBilhete(ActionEvent evento) {
        String nome = campoNomeCliente.getText();
        Sessao sessao = listaSessoes.getSelectionModel().getSelectedItem();

        if (sessao == null) {
            labelStatus.setText("Selecione uma sessão.");
            return;
        }

        Runnable tarefa = () -> {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Platform.runLater(() -> {
                labelStatus.setText("Reserva confirmada!");
                areaDetalhes.setText(sessao.getFilme() + "\n" + sessao.getSala()
                        + "\n" + sessao.getHorario() + "\nCliente: " + nome);
            });
        };
        new Thread(tarefa).start();
    }

    /**
     * Abre uma janela para selecionar um arquivo contendo a lista de sessões.
     *
     * <p>Utiliza um {@link FileChooser} para permitir que o usuário selecione
     * um arquivo no sistema. Após a seleção, o nome do arquivo escolhido
     * é exibido no rótulo de status da interface.</p>
     *
     * @param evento evento responsável por acionar a importação das sessões
     */
    @FXML
    private void importarSessoes(ActionEvent evento) {
        FileChooser seletor = new FileChooser();
        seletor.setTitle("Importar lista de sessões");
        File ficheiro = seletor.showOpenDialog(painelRaiz.getScene().getWindow());
        if (ficheiro != null) {
            labelStatus.setText("Ficheiro escolhido: " + ficheiro.getName());
        }
    }

    /**
     * Amplia o cartaz do filme quando o mouse é posicionado sobre ele.
     *
     * <p>Aplica uma escala de 1.15 nos eixos horizontal e vertical,
     * aumentando visualmente o tamanho do cartaz.</p>
     *
     * @param evento evento do mouse responsável por acionar a ampliação
     */
    @FXML
    private void ampliarCartaz(MouseEvent evento) {
        cartazFilme.setScaleX(1.15);
        cartazFilme.setScaleY(1.15);
    }

    /**
     * Restaura o tamanho original do cartaz do filme.
     *
     * <p>Define a escala horizontal e vertical como 1.0, retornando o cartaz
     * ao seu tamanho original.</p>
     *
     * @param evento evento do mouse responsável por acionar a restauração
     */
    @FXML
    private void restaurarCartaz(MouseEvent evento) {
        cartazFilme.setScaleX(1.0);
        cartazFilme.setScaleY(1.0);
    }

    /**
     * Ordena e exibe todas as sessões cadastradas de acordo com o horário.
     *
     * <p>Obtém as sessões armazenadas no repositório e cria uma lista ordenada
     * utilizando o horário de cada sessão como critério de comparação.</p>
     *
     * @param evento evento responsável por acionar a ordenação das sessões
     */
    @FXML
    private void ordenarPorHorario(ActionEvent evento) {
        ObservableList<Sessao> dados = FXCollections.observableArrayList(
                SessaoRepositorio.getInstance().getSessoes());
        SortedList<Sessao> sessoesOrdenadas = new SortedList<>(dados, new Comparator<Sessao>() {
            @Override
            public int compare(Sessao s1, Sessao s2) {
                return s1.getHorario().compareTo(s2.getHorario());
            }
        });
        listaSessoes.setItems(sessoesOrdenadas);
    }

    /**
     * Filtra e exibe apenas as sessões programadas para o dia atual.
     *
     * <p>Obtém todas as sessões cadastradas no repositório e aplica um filtro
     * que mantém somente aquelas cuja data corresponde à data atual.</p>
     *
     * @param evento evento responsável por acionar o filtro das sessões
     */
    @FXML
    private void filtrarHoje(ActionEvent evento) {
        ObservableList<Sessao> dados = FXCollections.observableArrayList(
                SessaoRepositorio.getInstance().getSessoes());
        FilteredList<Sessao> sessoesFiltradas = new FilteredList<>(dados, s -> true);
        sessoesFiltradas.setPredicate(s ->
                s.getHorario().toLocalDate().equals(LocalDate.now()));
        listaSessoes.setItems(sessoesFiltradas);
    }

    /**
     * Exibe todas as sessões cadastradas na lista de sessões.
     *
     * <p>Obtém as sessões armazenadas no repositório, cria uma lista filtrada
     * contendo todos os registros e ordena as sessões de acordo com o horário.
     * O resultado é então associado à lista exibida na interface.</p>
     *
     * @param evento evento responsável por acionar a exibição das sessões
     */
    @FXML
    private void mostrarTodas(ActionEvent evento) {
        ObservableList<Sessao> dados = FXCollections.observableArrayList(
                SessaoRepositorio.getInstance().getSessoes());
        FilteredList<Sessao> sessoesFiltradas = new FilteredList<>(dados, s -> true);
        Comparator<Sessao> comparadorPorHorario =
                (s1, s2) -> s1.getHorario().compareTo(s2.getHorario());
        SortedList<Sessao> resultado =
                new SortedList<>(sessoesFiltradas, comparadorPorHorario);
        listaSessoes.setItems(resultado);
    }
}
