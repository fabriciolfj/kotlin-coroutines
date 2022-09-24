# Coroutines
- é um padrão para escrita de programas assincronos
- em uma thread podemos possuir mais de uma coroutines
- são mais leves que as threads 
- são mais eficientes, pois são suspensas e retomadas em vez de bloquear a execução

## Suspend
- uma função que não bloqueará a executação das demais na mesma thread.
- precisa estar dentro de uma função launch

## Construtores
#### runBlocking
- inicia uma coroutine, bloqueando a thread em execução, até que todo o código da coroutine seja concluído
- indicado para uso em classes principais ou testes junit
- server para conectar função de bloqueio a código de suspensão

#### launch
- inicia uma nova corountine que não retorna nenhum resultado
- não bloqueia a thread em execução

#### async
- retorna uma valor
- inicia em paralelo, similar ao launch, mas espera a coroutine chamada (que vai retornar) terminar a conclusão, antes de voltar

## Dispatcher
- dentro da coroutine (coroutine context), podemos indicar um dispatcher, caso deseje utilizar outra thread ou um pool de threads a execução da coroutine
- quando não definimos um dispatcher, um default e inserido (pool de threads de tamanho igual ao núcleo da maquina)
- alguns dispatcher utilizados, serão citados abaixo.

#### newSingleThreadContext
- a coroutine sempre será executada em uma nova thread 
#### Unconfined 
- executa a coroutine na thread da função que a chamou, ate o ponto de suspense, 
- após essa parte a execução volta a thread chamadora e 
- a parte da função suspense ainda não executada, é executada em outra thread
- não é indicado para uso geral no código
- apenas parte que precisa ser executada, mas em paralelo

## Cancelando uma execução de uma coroutine
- caso uma coroutine esteja muito lenta ou executando um processo longo, podemos cancelar a mesma
- podemos utilizar o join.cancelAndJoin(), onde aguadar o cancelamento da coroutine
- ou podemos fazer uso do yield(), onde fará sair da coroutine