# Module 16 - Java NetWorking

Bem-vindo ao **BolsaAgora**, um projeto prático desenvolvido com o objetivo de estudar e aplicar conceitos de **Java Networking**.

A aplicação simula uma pequena plataforma de consulta de ativos financeiros. O usuário se conecta ao servidor, informa o código 
de um ativo e recebe como resposta sua cotação.

O foco do projeto não é reproduzir uma aplicação real de investimentos, mas utilizar um único sistema para aplicar, na prática, 
diferentes recursos relacionados à comunicação em rede no Java.

---

# 🎯 Objetivos do Projeto

O BolsaAgora foi desenvolvido para servir como um projeto prático de estudo.

Durante sua construção, diferentes tecnologias e conceitos de networking são utilizados de acordo com a necessidade de cada parte da aplicação.

Entre os principais conceitos abordados estão:

- Comunicação TCP
- Comunicação UDP
- Java NIO
- Channels
- Buffers
- Selectors
- URI e URL
- HTTP
- HttpClient
- Operações assíncronas
- CompletableFuture
- WebSocket
- Virtual Threads

A ideia é utilizar cada recurso onde ele fizer mais sentido dentro do sistema, mantendo a aplicação simples e focada no aprendizado.

---

# 📊 Ativos

A aplicação trabalha com ativos financeiros representados pelo modelo `Ativo`.

Cada ativo possui:

- **Código:** identifica o ativo dentro da aplicação.
- **Preço:** representa sua cotação atual.
  
- Obs.: Os códigos abaixo são tickers, usados para identificar ações na Bolsa de Valores (B3):

- PETR4 → Petrobras
- VALE3 → Vale
- ITUB4 → Itaú Unibanco
- ABEV3 → Ambev
- BBAS3 → Banco do Brasil

Os valores ao lado representam o preço de cada ativo utilizado no exemplo.

Atualmente, os ativos são mantidos diretamente na memória do servidor.

Os ativos disponíveis são:

- PETR4 → R$ 38.50
- VALE3 → R$ 62.30
- ITUB4 → R$ 35.80
- ABEV3 → R$ 14.25
- BBAS3 → R$ 28.90

O modelo `Ativo` foi implementado utilizando um `record`, tornando sua representação simples e adequada para armazenar os dados dos ativos.

---

# 🌐 Comunicação TCP

A comunicação principal da aplicação utiliza **TCP**.

O cliente estabelece uma conexão com o servidor e pode realizar múltiplas consultas enquanto a conexão permanece aberta.

O servidor permanece em execução aguardando novas conexões, permitindo que diferentes clientes possam utilizar a aplicação.

Essa comunicação permite aplicar conceitos fundamentais de aplicações em rede, como conexão, envio de dados, recebimento de respostas e encerramento da comunicação.

---

# ☕ Java NIO

O BolsaAgora utiliza a API **Java NIO** para trabalhar com a comunicação em rede.

Entre os principais recursos utilizados estão:

- `SocketChannel`
- `ServerSocketChannel`
- `ByteBuffer`
- `Selector`
- `SelectionKey`

O `ServerSocketChannel` é responsável por receber novas conexões.

O `SocketChannel` representa o canal utilizado na comunicação entre cliente e servidor.

O `ByteBuffer` é utilizado para trabalhar com os dados enviados e recebidos através dos canais.

O `Selector` permite que o servidor monitore diferentes canais e seus respectivos eventos de comunicação.

---

# 🔄 Selector

O `Selector` é utilizado no servidor para gerenciar as conexões de forma não bloqueante.

Com ele, o servidor consegue monitorar eventos como:

- Novas conexões
- Dados disponíveis para leitura
- Encerramento de conexões

Dessa forma, várias conexões podem ser acompanhadas utilizando uma única estrutura de gerenciamento.

---

# 📦 ByteBuffer

O `ByteBuffer` é utilizado para armazenar temporariamente os dados durante a comunicação entre cliente e servidor.

Ele permite trabalhar diretamente com os bytes enviados através dos `Channels`, sendo um dos principais recursos da API NIO.

---

# 🔌 SocketChannel

O `SocketChannel` é utilizado pelo cliente para estabelecer a comunicação TCP com o servidor.

Ele permite enviar as solicitações dos ativos e receber as respectivas respostas.

A utilização do `SocketChannel` também permite aplicar os conceitos de canais e buffers presentes na API NIO.

---

# 🖥️ Cliente

O cliente é responsável pela interação com o usuário.

Ele estabelece uma conexão com o servidor e permite informar os códigos dos ativos que deseja consultar.

O usuário pode realizar diversas consultas durante a mesma conexão e utilizar o comando `sair` para encerrar o cliente.

---

# 🖥️ Servidor

O servidor é responsável por receber as conexões dos clientes e processar suas solicitações.

Ao receber o código de um ativo, o servidor realiza a busca entre os ativos disponíveis e retorna sua cotação.

O servidor utiliza `ServerSocketChannel`, `SocketChannel`, `ByteBuffer` e `Selector` para realizar o gerenciamento da comunicação.

---

# 📂 Estrutura do Projeto

A estrutura do projeto está organizada da seguinte forma:

- `model` — contém o modelo `Ativo`, responsável pela representação dos ativos.
- `server` — contém o servidor principal da aplicação.
- `client` — contém o cliente responsável pelas consultas.

---

# 📡 Networking

Durante o desenvolvimento do projeto são estudados e aplicados diferentes recursos relacionados à comunicação em rede no Java.

Entre eles:

- TCP
- UDP
- Sockets
- NIO
- Channels
- Buffers
- Selectors
- HTTP
- HttpClient
- WebSocket

Cada tecnologia é estudada considerando sua finalidade e aplicação dentro do contexto do projeto.

---

# 🧵 Concorrência e Assincronismo

O projeto também aborda conceitos relacionados à execução concorrente e assíncrona no Java.

Entre os recursos estudados estão:

- `CompletableFuture`
- Comunicação assíncrona
- Virtual Threads

Esses recursos fazem parte do estudo de diferentes formas de lidar com operações de rede e execução concorrente.

---

# 📦 Tecnologias Utilizadas

- **Java**
- **Java NIO**
- **TCP**
- **UDP**
- **HTTP**
- **HttpClient**
- **WebSocket**
- **CompletableFuture**
- **Virtual Threads**

---

# 💡 Conceitos-Chave Aprendidos

Durante o desenvolvimento do BolsaAgora, foram praticados conceitos como:

- Comunicação entre cliente e servidor
- Comunicação TCP e UDP
- Sockets
- Java NIO
- Channels
- Buffers
- Selectors
- Comunicação HTTP
- Requisições assíncronas
- CompletableFuture
- WebSocket
- Virtual Threads
- Gerenciamento de conexões
- Comunicação baseada em eventos

---

# 🎓 Resumo de Aprendizagem

O BolsaAgora foi desenvolvido como uma forma prática de consolidar os conhecimentos estudados sobre **Java Networking**.

O projeto permite compreender como diferentes mecanismos de comunicação podem ser utilizados em uma aplicação Java, desde a
comunicação através de sockets até recursos mais modernos como NIO, comunicação assíncrona, WebSocket e Virtual Threads.

Além de estudar cada tecnologia individualmente, o projeto busca demonstrar como escolher diferentes recursos de acordo com a 
necessidade de cada parte de uma aplicação.

---

# 🚀 Objetivo Final

O objetivo final do BolsaAgora é servir como um projeto de demonstração dos conhecimentos adquiridos em **Java Networking**, 
reunindo diferentes conceitos estudados em uma única aplicação prática.

O projeto faz parte dos estudos de Java e tem como foco principal **aprendizado, prática e demonstração de conhecimento**.