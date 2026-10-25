Prática 05 – TDD em Java
Respostas da reflexão

1. No Ciclo 1 usamos "return 70". Por que isso é aceitável no TDD? O que obrigou a escrever a soma de verdade?

Porque no TDD a gente começa fazendo o mínimo necessário para o teste passar. No primeiro teste, colocar return 70 já funcionava, mas quando fizemos outro teste com notas diferentes, ele não deu o resultado esperado. Então tivemos que mudar o código para realmente somar as três notas.

2. No Ciclo 3, por que testar com 69 e 70, e não com 50 e 90?

Porque 69 e 70 são as notas que ficam bem no limite entre reprovar e passar. Assim, conseguimos verificar se o código está funcionando corretamente, já que com 69 o aluno reprova e com 70 ele passa. Se usássemos 50 e 90, poderia passar despercebido algum erro nessa condição.

3. No Ciclo 4, o que mudou na refatoração? Como você teve certeza de que não quebrou nada?

A gente tinha três if fazendo praticamente a mesma coisa, então mudamos para um único método chamado validarNota(). Também colocamos constantes para as notas máximas. Depois disso, rodei os testes novamente e todos continuaram verdes, então consegui confirmar que as mudanças não atrapalharam o funcionamento do código.

4. No Ciclo 8, por que alteramos os testes antes de mudar o código?

Porque no TDD primeiro precisamos testar o que queremos que o programa faça. Como a regra mudou e agora precisava mostrar o motivo da reprovação, tivemos que alterar os testes primeiro. Depois mudamos o código para que ele atendesse às novas condições e os testes passassem.

5. Qual ciclo foi o mais difícil para você, e por quê?

Pra mim, o Ciclo mais dicil foi o Ciclo 4, porque no começo fiquei confusa com as validações das notas e principalmente com a parte de transformar os três ifs em um método só. Também me confundi um pouco com a ordem dos commits e dos testes, fiz ate confusão se tinha dado os commits certo em alguns momentos, e demorei 1 hora pra entender kkk
Mas conforme fui fazendo e corrigindo os erros, consegui entender melhor como funcionava e fui conferindo parte a parte pra ver se tava certinho.

