Convenções Adotadas:

- Criação interface adicionando o I na frente
- Criação da classe que implementa uma interface (concreta) adicionando o Impl no final do nome

Plugins:

https://plugins.jetbrains.com/plugin/4594-qaplug - QAPlug 1.3.13

https://plugins.jetbrains.com/plugin/4596-qaplug--pmd - PMD 1.3.8

https://plugins.jetbrains.com/plugin/4595-qaplug--checkstyle - Checkstyle 1.3.4

https://plugins.jetbrains.com/plugin/4597-qaplug--findbugs - FindBugs 1.3.7


Diário de bordo:

13/10/2017 - Construção da raiz de agregação na fábrica, Criação do DomainBusinessException para regras de negócio e Validação do Domínio por BeanValidation (Antes de salvar, validando também os agregados).Testamos a abordagem de domínio resultante, porém não notamos ganhos em devolver um DTO que pode ou não conter uma lista de erros, achamos melhor utilizar o handler do Spring pegando a exceção do DomainBusinessException.
