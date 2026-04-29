# Módulo 10: Generics e Estruturas de Dados Avançadas

Este módulo consolida o conhecimento em Java Avançado através de dois 
projetos práticos que utilizam Generics, Interfaces e Herança para 
criar sistemas escaláveis e profissionais.

## 🚀 Projetos Desenvolvidos

### 1. Students Challenge (Sistema de Consultas)
Focado na manipulação dinâmica de coleções de dados:
- **`QueryList<T>`**: Uma coleção inteligente que permite filtros 
  dinâmicos e encadeados (Fluent API).
- **Type Bounds**: Uso de `<T extends Student & QueryItem>` para 
  garantir que os objetos tenham as propriedades necessárias.
- **Busca Dinâmica**: Filtros flexíveis baseados em campos e valores 
  usando o poder do `switch expression`.

### 2. Mappable System (Mapeamento Geográfico)
Focado na organização de elementos em camadas usando abstrações:
- **Hierarquia de Geometria**: Uso de classes abstratas (`Point` e `Line`) 
  para definir comportamentos básicos de localização.
- **Camadas Genéricas (`Layer<T>`)**: Uma classe genérica que gerencia 
  e renderiza diferentes tipos de elementos no mapa de forma isolada.
- **Interface `Mappable`**: Contrato que define como qualquer objeto 
  deve ser renderizado e como suas coordenadas devem ser tratadas.
- **Conversão de Dados**: Métodos estáticos para processar strings 
  de localização ("latitude, longitude") de forma eficiente.

## 🧠 Evolução: De Iniciante a Avançado

A conclusão destes projetos marca um divisor de águas na minha jornada:

1. **Abstração de Alto Nível**: 
   Criação de componentes que dependem de comportamentos (interfaces) 
   e não de tipos fixos, permitindo que o sistema cresça sem esforço.
2. **Segurança com Generics**: 
   Entendimento profundo de como o Java evita erros em tempo de 
   compilação através do uso correto de tipos genéricos.
3. **Organização Profissional**: 
   Aplicação de Javadoc em todas as classes, garantindo que o código 
   seja legível e fácil de manter por qualquer desenvolvedor.
4. **Design de Software**: 
   Aprendizado sobre Fluent Interfaces e herança múltipla de tipos 
   através de interfaces.

---
*Estes projetos demonstram a base da engenharia por trás de grandes 
frameworks Java usados no mercado corporativo.*
