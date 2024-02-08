# Caixa Eletrônico
- Sistema para gerenciar as funcionalidades de saque e reabastecimento de estoque de cédulas de um caixa eletrônico.

# 🚨 Requisitos

- Deve-se manter quais cédulas e a quantidade de cada uma que estão disponíveis no caixa eletrônico para saque dos correntistas.
- Deve-se criar uma funcionalidade para reabastecer as cédulas do caixa eletrônico especificando quantidade por cédulas.

      Exemplo:

      40 cédulas de R$ 20,00
      
      100 cédulas de R$ 10,00
      
      50 cédulas de R$ 50,00
      
      10 cédulas de R$ 100,00

- O correntista deve ser capaz de sacar dinheiro da própria conta corrente. Para tanto, o correntista seleciona se deseja escolher as cédulas do saque.
- Se o usuário deseja escolher, o sistema deve exibir todas as opções de combinações de cédulas (opções válidas considerando as cédulas existentes) que utilizem até 3 cédulas. As opções com mais de 3 cédulas devem ser desconsideradas.

      Exemplo:
      
      Saque solicitado : R$ 120,00
      
      Escolha uma das opções de cédulas:
      
      1x R$100,00 + 1x R$ 20,00
      
      2x R$50,00 + 2x R$ 10,00
      
      1x R$100,00 + 2x R$ 10,00
      
      2x R$50,00 + 1x R$ 20,00
      
      5x R$20,00 + 2x R$ 10,00
      
      1x R$50,00 + 1x R$ 10,00 + 3x R$ 20,00
      
      ... (assim por diante)



- Se o usuário NÃO deseja escolher as cédulas, o sistema deve disponibilizar a melhor combinação de cédulas a fim de manter a maior proporção de cada cédula possível.

      Exemplo:
      
      Estoque:
      
      4 cédulas de R$ 20,00
      
      7 cédulas de R$ 10,00
      
      3 cédulas de R$ 50,00
      
      1 cédulas de R$ 100,00
      
      Saque solicitado: R$ 50,00
      
      Saque disponibilizado: 3x R$ 10,00 + 1x R$ 20,00

- Não há necessidade de gerenciar saldo, nem qual conta executa a operação, o foco do algoritmo é gerenciar o controle de cédulas/saque.
