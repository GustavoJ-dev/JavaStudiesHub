# Module 18 - JavaFX

Bem-vindo ao **JavaFX**, um projeto prático desenvolvido com o objetivo de estudar e aplicar conceitos de **interfaces 
em Java** utilizando o framework **JavaFX**. A aplicação utiliza o **CineTicket** como projeto principal para demonstrar 
a criação de interfaces utilizando FXML, controllers, layouts, componentes visuais, eventos, listas, imagens, CSS e recursos 
de interação com o usuário. O foco do projeto não é apenas construir uma interface, mas compreender como os diferentes 
recursos do JavaFX podem ser utilizados em conjunto para criar uma aplicação Java organizada, interativa e funcional.

# 📚 Guia do módulo

- Os conteúdos sobre o módulo se encontram na pasta:
- `JavaStudiesHub/module18-Java-POO-JavaFX/src/main/java/com/gustavo/materiais_de_estudo`.

- O projeto sobre o módulo encontram na pasta:
- `JavaStudiesHub/module18-Java-POO-JavaFX/src/main/java/com/gustavo/mainapp`.

---

# 🎯 Objetivos do Projeto

O projeto foi desenvolvido para servir como uma aplicação prática dos conceitos de **JavaFX**. Durante sua construção, 
recursos do JavaFX são utilizados para criar uma interface de gerenciamento de sessões de cinema.
Entre os principais conceitos abordados estão:

- JavaFX
- FXML
- `Application`
- `Stage`
- `Scene`
- `Parent`
- `FXMLLoader`
- Controllers
- `@FXML`
- `fx:id`
- Eventos
- `onAction`
- `initialize()`
- `BorderPane`
- `GridPane`
- `VBox`
- `HBox`
- `StackPane`
- `ToolBar`
- `ListView`
- `TextArea`
- `TextField`
- `ComboBox`
- `RadioButton`
- `CheckBox`
- `ToggleGroup`
- `TitledPane`
- `Accordion`
- `ImageView`
- `FileChooser`
- CSS
- Listeners
- `SortedList`
- `FilteredList`
- Singleton
- Persistência

A ideia é utilizar cada recurso dentro do contexto da aplicação, mantendo a interface organizada e permitindo compreender como cada componente funciona.

---

# 🎬 CineTicket

O **CineTicket** é a aplicação utilizada como projeto principal durante o módulo.
A aplicação representa uma interface de gerenciamento de sessões de cinema, permitindo trabalhar com sessões, salas, horários, 
informações do cliente e elementos relacionados à reserva de bilhetes. A estrutura principal da aplicação utiliza um `BorderPane`, 
dividindo a interface em diferentes regiões.

---

# 🖥️ Interface Principal

A interface principal utiliza um `BorderPane` como container raiz.

A estrutura pode ser organizada da seguinte maneira:

```text
BorderPane
│
├── Top
│   └── ToolBar
│
├── Left
│   └── ListView
│       └── Sessões
│
├── Center
│   └── Área principal
│       ├── Cartaz
│       ├── Informações da sessão
│       ├── Dados do cliente
│       ├── Sala
│       ├── Assento
│       ├── Itens adicionais
│       └── Botões
│
└── Bottom
    └── Informações da aplicação
```

O `BorderPane` permite distribuir os componentes de acordo com suas posições na janela.

---

# 🧱 Layouts

O JavaFX possui diferentes layouts para organizar os componentes da interface.
No projeto são utilizados principalmente:

## `BorderPane`

O `BorderPane` é utilizado como estrutura principal da aplicação.

```xml
<BorderPane>
```

Ele permite organizar componentes nas regiões:

- `top`
- `bottom`
- `left`
- `right`
- `center`

---

## `GridPane`

O `GridPane` organiza componentes em linhas e colunas.

```xml
<GridPane hgap="10"
          vgap="10"
          alignment="CENTER">
```

Os componentes podem ser posicionados utilizando:

```xml
GridPane.rowIndex
GridPane.columnIndex
```

---

## `VBox`

O `VBox` organiza seus componentes verticalmente.

```xml
<VBox spacing="8">
```

É utilizado para agrupar elementos que precisam aparecer um abaixo do outro.

---

## `HBox`

O `HBox` organiza seus componentes horizontalmente.

```xml
<HBox spacing="10">
```

É utilizado, por exemplo, para organizar botões na mesma linha.

---

## `StackPane`

O `StackPane` permite posicionar componentes sobrepostos.

```xml
<StackPane>
```

Esse recurso é útil principalmente quando diferentes elementos precisam ocupar a mesma região visual.

---

# 🎞️ Cartaz do Filme

O projeto utiliza `ImageView` para trabalhar com imagens relacionadas ao filme.

Exemplo:

```xml
<ImageView fx:id="cartazFilme"
           fitWidth="140"
           onMouseEntered="#ampliarCartaz"
           onMouseExited="#restaurarCartaz"/>
```

O `ImageView` também pode receber eventos do mouse.

---

# 🖱️ Eventos do Mouse

O JavaFX permite associar eventos diretamente aos componentes através do FXML.

Exemplo:

```xml
<ImageView fx:id="cartazFilme"
           fitWidth="140"
           onMouseEntered="#ampliarCartaz"
           onMouseExited="#restaurarCartaz"/>
```

No controller:

```java
@FXML
private void ampliarCartaz(MouseEvent evento) {
    cartazFilme.setScaleX(1.15);
    cartazFilme.setScaleY(1.15);
}

@FXML
private void restaurarCartaz(MouseEvent evento) {
    cartazFilme.setScaleX(1.0);
    cartazFilme.setScaleY(1.0);
}
```

Quando o mouse entra sobre a imagem, ela pode ser ampliada.

Quando o mouse sai, a escala original pode ser restaurada.

---

# 🎫 Reserva de Bilhete

A aplicação possui um botão destinado à reserva de bilhetes.

```xml
<Button text="Reservar bilhete"
        onAction="#reservarBilhete"/>
```

O evento é recebido pelo controller:

```java
@FXML
private void reservarBilhete(ActionEvent evento) {
    System.out.println("Bilhete reservado!");
}
```

Esse exemplo demonstra a ligação entre o evento definido no FXML e o método existente no controller.

---

# 🎟️ Botão com Ícone

O JavaFX permite adicionar componentes gráficos aos botões.

Exemplo:

```xml
<Button text="Reservar bilhete">
    <graphic>
        <ImageView>
            <Image url="@icones/ticket.png"/>
        </ImageView>
    </graphic>
</Button>
```

Dessa maneira, o botão pode apresentar texto e uma imagem.

---

# 📋 ListView

A `ListView` é utilizada para apresentar as sessões disponíveis.

```xml
<ListView fx:id="listaSessoes"
          prefWidth="220"/>
```

No controller:

```java
@FXML
private ListView<Sessao> listaSessoes;
```

A `ListView` permite que o usuário selecione uma sessão.

---

# 🎥 Classe Sessao

A classe `Sessao` representa uma sessão de cinema.

```java
public class Sessao {

    private String filme;
    private String sala;
    private LocalDateTime horario;

    public Sessao(String filme, String sala, LocalDateTime horario) {
        this.filme = filme;
        this.sala = sala;
        this.horario = horario;
    }

    public String getFilme() {
        return filme;
    }

    public String getSala() {
        return sala;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return filme;
    }
}
```

A classe possui as informações:

- Filme
- Sala
- Horário

O método `toString()` retorna o nome do filme para representação da sessão na `ListView`.

---

# 🕒 Carregamento das Sessões

As sessões podem ser criadas durante a inicialização do controller.

```java
@FXML
public void initialize() {

    sessoes = new ArrayList<>();

    sessoes.add(
        new Sessao(
            "Duna: Parte Três",
            "Sala 1",
            LocalDateTime.of(2026, 9, 12, 19, 0)
        )
    );

    sessoes.add(
        new Sessao(
            "Viagem ao Fundo do Mar",
            "Sala 2",
            LocalDateTime.of(2026, 9, 12, 16, 30)
        )
    );

    listaSessoes.getItems().setAll(sessoes);

    listaSessoes.getSelectionModel()
                .setSelectionMode(SelectionMode.SINGLE);
}
```

---

# 🔎 Seleção de Sessões

A `ListView` permite observar alterações na sessão selecionada.

```java
listaSessoes.getSelectionModel()
    .selectedItemProperty()
    .addListener((observable, valorAntigo, valorNovo) -> {

        if (valorNovo != null) {
            areaDetalhes.setText(
                valorNovo.getSala()
                + "\n"
                + valorNovo.getHorario()
            );
        }
    });
```

Também é possível selecionar automaticamente o primeiro item:

```java
listaSessoes.getSelectionModel().selectFirst();
```

---

# 📝 Área de Detalhes

A aplicação utiliza um `TextArea` para apresentar informações da sessão selecionada.

```xml
<TextArea fx:id="areaDetalhes"
          editable="false"
          wrapText="true"/>
```

O campo é definido como não editável porque sua função é apresentar informações ao usuário.

---

# 👤 Dados do Cliente

O projeto utiliza um `TextField` para receber o nome do cliente.

```xml
<TextField fx:id="campoNomeCliente"
           promptText="Nome do cliente"/>
```

O `TextField` permite que o usuário digite informações.

---

# 🏛️ Seleção da Sala

O `ComboBox` é utilizado para apresentar opções de sala.

```xml
<ComboBox fx:id="comboSala"
          promptText="Escolha a sala">
```

As opções estudadas são:

```text
Sala 1
Sala 2
Sala 3 — IMAX
```

---

# 💺 Seleção de Assento

O projeto utiliza `RadioButton` para representar diferentes categorias de assento.

```xml
<fx:define>
    <ToggleGroup fx:id="grupoAssento"/>
</fx:define>

<RadioButton text="Plateia"
             toggleGroup="$grupoAssento"
             selected="true"/>

<RadioButton text="Balcão"
             toggleGroup="$grupoAssento"/>

<RadioButton text="VIP"
             toggleGroup="$grupoAssento"/>
```

Os `RadioButton` utilizam o mesmo `ToggleGroup`.

---

# 🍿 Itens Adicionais

O projeto utiliza `CheckBox` para representar itens adicionais.

```xml
<VBox spacing="6">
    <CheckBox text="Pipoca grande"/>
    <CheckBox text="Refrigerante"/>
    <CheckBox text="Óculos 3D"/>
</VBox>
```

Diferentemente dos `RadioButton`, os `CheckBox` permitem trabalhar com múltiplas seleções.

---

# 📄 FXML

O **FXML** é utilizado para definir a estrutura visual da aplicação.

Ele permite separar a interface da lógica Java.

Exemplo:

```xml
<BorderPane fx:controller="cineticket.MainController"
            xmlns:fx="http://javafx.com/fxml">
```

A propriedade `fx:controller` associa o arquivo FXML ao controller.

---

# 🎮 Controller

O controller é responsável por controlar o comportamento da interface.

Os componentes podem ser associados através de `fx:id`.

No FXML:

```xml
<ListView fx:id="listaSessoes"/>
```

No controller:

```java
@FXML
private ListView<Sessao> listaSessoes;
```

A anotação `@FXML` permite que o componente seja injetado pelo `FXMLLoader`.

---

# ⚡ Eventos `onAction`

Eventos de componentes podem ser associados diretamente através do FXML.

```xml
<Button text="Reservar"
        onAction="#reservarBilhete"/>
```

O método correspondente deve existir no controller:

```java
@FXML
private void reservarBilhete(ActionEvent evento) {
    System.out.println("Bilhete reservado!");
}
```

---

# 🪟 Stage

O `Stage` representa a janela da aplicação.

Exemplo:

```java
@Override
public void start(Stage stage) throws Exception {
    // configuração da janela
}
```

O `Stage` recebe a `Scene` que será apresentada ao usuário.

---

# 🎬 Scene

A `Scene` representa o conteúdo visual exibido dentro da janela.

Exemplo:

```java
Scene scene = new Scene(root, 900, 550);
```

Depois, ela é associada ao `Stage`:

```java
stage.setScene(scene);
```

---

# 🌳 Parent

O `Parent` representa o nó raiz da interface carregada pelo FXML.

Exemplo:

```java
Parent root =
        FXMLLoader.load(getClass().getResource("main.fxml"));
```

O objeto `root` é utilizado posteriormente para criar a `Scene`.

---

# 🚀 Inicialização da Aplicação

A classe principal estende `Application`.

Exemplo:

```java
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root =
                FXMLLoader.load(
                    getClass().getResource("main.fxml")
                );

        Scene scene =
                new Scene(root, 900, 550);

        stage.setTitle("CineTicket");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

---

# 🔧 initialize()

O método `initialize()` é executado durante a inicialização do controller.

```java
@FXML
public void initialize() {
    // configuração inicial
}
```

Ele pode ser utilizado para:

- Carregar sessões.
- Configurar listas.
- Configurar listeners.
- Definir valores iniciais.
- Configurar componentes.
- Preparar o estado inicial da interface.

---

# 🔄 Listeners

Listeners permitem observar alterações nas propriedades dos componentes.

Exemplo:

```java
listaSessoes.getSelectionModel()
    .selectedItemProperty()
    .addListener((observable, valorAntigo, valorNovo) -> {

        if (valorNovo != null) {
            areaDetalhes.setText(
                valorNovo.getSala()
                + "\n"
                + valorNovo.getHorario()
            );
        }
    });
```

Esse mecanismo permite que a interface responda às ações realizadas pelo usuário.

---

# 🗃️ SessaoRepositorio

O módulo também aborda a utilização de um repositório para centralizar o gerenciamento das sessões. O `SessaoRepositorio`
trabalha como uma estrutura responsável pelo acesso aos dados das sessões. A utilização de um repositório permite separar 
gerenciamento dos dados das demais partes da aplicação.

---

# 💾 Persistência

O projeto também aborda mecanismos de carregamento e salvamento das sessões. A persistência permite armazenar informações 
para que elas possam ser recuperadas posteriormente. O módulo apresenta o conceito de carregar e salvar os dados das sessões.

---

# 🔀 SortedList

O JavaFX fornece `SortedList` para trabalhar com listas ordenadas.
Esse recurso pode ser utilizado para organizar as sessões de acordo com determinado critério.

Exemplo:

```java
SortedList<Sessao> sessoesOrdenadas =
        new SortedList<>(listaFiltrada);
```

---

# 🔎 FilteredList

A `FilteredList` permite trabalhar com uma lista filtrada.

Ela pode ser utilizada para apresentar somente os elementos que atendem a determinada condição.

Exemplo:

```java
FilteredList<Sessao> sessoesFiltradas =
        new FilteredList<>(sessoes);
```

A combinação de `FilteredList` e `SortedList` permite trabalhar com filtragem e ordenação dos dados.

---

# 🎨 CSS

O JavaFX permite utilizar CSS para definir a aparência dos componentes.

Exemplo:

```css
.button {
    -fx-background-color: #B45309;
    -fx-text-fill: white;
}

#botaoCancelar {
    -fx-background-color: #6B7280;
}
```

O CSS permite separar a estilização visual da lógica da aplicação.

---

# 🆔 `fx:id`

O `fx:id` identifica componentes que precisam ser acessados pelo controller.

Exemplo:

```xml
<Button fx:id="botaoCancelar"/>
```

No controller:

```java
@FXML
private Button botaoCancelar;
```

Dessa maneira, o controller consegue acessar o componente definido no FXML.

---

# 🆔 `id`

O `id` também pode ser utilizado para identificar um componente.
Uma das utilizações é permitir sua seleção através do CSS.

Exemplo:

```xml
<Button id="botaoCancelar"/>
```

No CSS:

```css
#botaoCancelar {
    -fx-background-color: #6B7280;
}
```

---

# 📂 FileChooser

O `FileChooser` permite abrir o seletor de arquivos do sistema operacional.

Exemplo:

```java
@FXML
private void importarSessoes(ActionEvent evento) {

    FileChooser seletor = new FileChooser();

    seletor.setTitle("Importar lista de sessões");

    File ficheiro =
            seletor.showOpenDialog(
                painelRaiz.getScene().getWindow()
            );

    if (ficheiro != null) {
        // processar o ficheiro escolhido
    }
}
```

Esse recurso pode ser utilizado para selecionar arquivos que serão posteriormente processados pela aplicação.

---

# 🖼️ Imagens

O JavaFX utiliza `Image` e `ImageView` para trabalhar com imagens.
Exemplo:

```xml
<ImageView>
    <Image url="@icones/ticket.png"/>
</ImageView>
```

As imagens podem ser utilizadas em componentes visuais e também como gráficos de botões.

---

# ✨ DropShadow

O JavaFX permite adicionar efeitos visuais aos componentes.
Um exemplo é o `DropShadow`.

```java
@FXML
private Button botaoDestaque;

@FXML
public void initialize() {
    botaoDestaque.setEffect(new DropShadow());
}
```

O efeito pode ser aplicado a componentes como botões.

---

# 📑 TitledPane

O `TitledPane` permite criar uma área que pode ser expandida ou recolhida.

Exemplo:

```xml
<TitledPane text="Política de cancelamento"
            expanded="false">
    <Label text="Reservas podem ser canceladas até 2 horas antes da sessão."
           wrapText="true"/>
</TitledPane>
```

---

# 🗂️ Accordion

O `Accordion` permite organizar múltiplos `TitledPane`.

Exemplo:

```xml
<Accordion>
    <panes>

        <TitledPane text="Formas de pagamento">
            <Label text="Aceitamos cartão e Multibanco."
                   wrapText="true"/>
        </TitledPane>

        <TitledPane text="Trocas e devoluções">
            <Label text="Bilhetes não são reembolsáveis após o início da sessão."
                   wrapText="true"/>
        </TitledPane>

    </panes>
</Accordion>
```

---

# 🧩 Estrutura do Projeto

A estrutura principal do módulo é organizada da seguinte maneira:

```text
module18-Java-POO-JavaFX/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── gustavo/
│   │   │           └── mainapp/
│   │   │               ├── MainApp.java
│   │   │               └── controller/
│   │   │                   └── MainController.java
│   │   │
│   │   └── resources/
│   │       ├── App.fxml
│   │       ├── styles.css
│   │       └── icones/
│   │
│   ├── materiais_de_estudo/
│   │
│   └── praticas/
│
├── pom.xml
└── README.md
```

---

# 📦 Maven

O projeto utiliza **Maven** para gerenciamento da aplicação e das dependências.
O arquivo responsável pela configuração do projeto é:

```text
pom.xml
```

O Maven é utilizado para:

- Gerenciar dependências.
- Compilar o projeto.
- Executar o ciclo de build.
- Gerar o arquivo `.jar`.
- Organizar o projeto.

---

# ☕ Java

O projeto utiliza **Java** como linguagem principal.
A configuração do projeto utiliza Java 21.

```xml
<source>21</source>
<target>21</target>
```

---

# 🖥️ JavaFX

O **JavaFX** é utilizado para construir a interface gráfica da aplicação.
Através dele é possível trabalhar com:

- Janelas.
- Cenas.
- Layouts.
- Controles.
- Eventos.
- Imagens.
- CSS.
- FXML.
- Efeitos.
- Componentes interativos.

---

# 🛠️ Tecnologias Utilizadas

- **Java**
- **JavaFX**
- **FXML**
- **CSS**
- **Maven**
- **IntelliJ IDEA**

---

# 💡 Conceitos-Chave Aprendidos

Durante o desenvolvimento do projeto foram praticados conceitos como:

- JavaFX
- FXML
- `Application`
- `Stage`
- `Scene`
- `Parent`
- `FXMLLoader`
- Controllers
- `@FXML`
- `fx:id`
- `id`
- Eventos
- `onAction`
- `initialize()`
- Listeners
- `BorderPane`
- `GridPane`
- `VBox`
- `HBox`
- `StackPane`
- `ToolBar`
- `ListView`
- `TextArea`
- `TextField`
- `ComboBox`
- `RadioButton`
- `ToggleGroup`
- `CheckBox`
- `TitledPane`
- `Accordion`
- `ImageView`
- `Image`
- `FileChooser`
- CSS
- `FilteredList`
- `SortedList`
- Singleton
- Persistência

---

# 📖 Boas Práticas Trabalhadas

Durante o desenvolvimento da aplicação, também são praticadas algumas boas práticas importantes:

- Separar a interface da lógica da aplicação.
- Utilizar FXML para estruturar a interface.
- Utilizar controllers para controlar comportamentos.
- Utilizar `fx:id` para acessar componentes.
- Escolher layouts de acordo com a necessidade da interface.
- Utilizar CSS para estilização.
- Organizar os arquivos dentro da estrutura do projeto.
- Utilizar classes específicas para representar os dados.
- Centralizar o gerenciamento das sessões.
- Utilizar listeners para responder às alterações da interface.
- Manter os métodos responsáveis por comportamentos específicos.

---

# 🎓 Resumo de Aprendizagem

O projeto foi desenvolvido como uma forma prática de consolidar os conhecimentos estudados sobre **JavaFX**. Durante sua 
construção, foram estudados diferentes componentes utilizados para desenvolver interfaces gráficas em Java. Foram trabalhados
recursos como FXML, controllers, layouts, eventos, componentes de entrada, listas, imagens, CSS e efeitos visuais. O 
projeto também permite compreender como a interface gráfica pode se comunicar com classes Java através do `FXMLLoader`, 
`@FXML`, `fx:id` e métodos de eventos. Além disso, os conceitos de `FilteredList`, `SortedList`, repositório e persistência 
formas de trabalhar com os dados da aplicação de maneira mais organizada.

---

# 🚀 Objetivo Final

O objetivo final do projeto é servir como uma demonstração prática dos conhecimentos adquiridos em **desenvolvimento de interfaces gráficas com JavaFX**.
O projeto faz parte dos estudos de Java e tem como foco principal:

- **Aprendizado**
- **Prática**
- **Interfaces gráficas**
- **JavaFX**
- **FXML**
- **Eventos**
- **Organização de código**
- **Interação com o usuário**
- **Desenvolvimento de aplicações desktop**

Através do desenvolvimento do **CineTicket**, o projeto busca consolidar os fundamentos necessários para criar, organizar
e controlar interfaces gráficas utilizando JavaFX. O conhecimento adquirido neste módulo também serve como base para estudos 
posteriores relacionados ao desenvolvimento desktop, interfaces gráficas e integração entre componentes visuais e lógica de aplicação.
